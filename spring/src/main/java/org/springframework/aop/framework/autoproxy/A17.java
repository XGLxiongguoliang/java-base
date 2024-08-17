package org.springframework.aop.framework.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;

import java.util.List;

public class A17 {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("aspect1", Aspect1.class);
        context.registerBean("config", Aspect1.Config.class);
        context.registerBean(ConfigurationClassPostProcessor.class);

        //切面注解相关的后置处理器 AnnotationAwareAspectJAutoProxyCreator
        //依赖注入之前，初始化之后
        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);

        context.refresh();
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        /**
         * 第一个重要的方法findEligibleAdvisors，找到有资格的Advisor
         * 1、有资格的Advisor，一部分是低级切面，一部分是自己编写的，如Advisor3
         * 2、有资格的Advisor，另一部分是高级的，由本章的主角解析@Aspect后获取
         */
        AnnotationAwareAspectJAutoProxyCreator creator = context.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        List<Advisor> advisors = creator.findEligibleAdvisors(Target2.class, "target1");

        for (Advisor advisor : advisors) {
            System.out.println("advisor" + advisor);
        }

        /**
         * 第二个重要的方法 wrapIfNecessary
         * 1、它内部调用findEligibleAdvisors,只要返回集合不为空，则表示需要创建代理
         *
         */
        Object o1 = creator.wrapIfNecessary(new Target1(), "target1", "target1");
        System.out.println(o1.getClass());
        Object o2 = creator.wrapIfNecessary(new Target2(), "target2", "target2");
        System.out.println(o2.getClass());

    }

    static class Target1 {
        public void foo() {
            System.out.println("Target1 foo");
        }
    }

    static class Target2 {
        public void bar() {
            System.out.println("Target1 bar");
        }
    }

    @Aspect
    static class Aspect1 {
        @Before("execution(* foo())")
        public void before() {
            System.out.println("Aspect1 before---");
        }

        @After("execution(* foo())")
        public void after() {
            System.out.println("Aspect1 before---");
        }

        @Configuration
        @Order(1)
        static class Config {
            @Bean
            public Advisor advisor3(MethodInterceptor advice3) {
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression("execution(* foo())");
                DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice3);
                defaultPointcutAdvisor.setOrder(2);
                return defaultPointcutAdvisor;
            }

            @Bean
            public MethodInterceptor advice3() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                        System.out.println("advice3 before----");
                        methodInvocation.proceed();
                        System.out.println("advice3 after----");
                        return null;
                    }
                };
            }
        }
    }
}
