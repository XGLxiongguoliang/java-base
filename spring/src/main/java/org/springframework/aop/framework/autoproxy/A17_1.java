package org.springframework.aop.framework.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

public class A17_1 {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(ConfigurationClassPostProcessor.class);
        context.registerBean(Config.class);

        context.refresh();
        context.close();

        //依赖注入之前或者初始化之后 创建->（*）依赖注入->初始化（*）
        /**
         * 学到了什么
         * a、代理的创建时机
         * 1、初始化之后（无循环依赖时）
         * 2、实例创建后，依赖注入前（循环依赖时），并暂存二级缓存
         *
         * b、依赖注入与初始化不应该被增强，扔仍应该施加在原始对象
         */
    }

    @Configuration
    static class Config {
       @Bean
       public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
       }

       @Bean
       public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcess() {
        return new AutowiredAnnotationBeanPostProcessor();
       }

       @Bean
       public CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor() {
        return new CommonAnnotationBeanPostProcessor();
       }

       @Bean
       public Advisor advisor(MethodInterceptor advice) {
         AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
         pointcut.setExpression("execution(* foo())");
         return new DefaultPointcutAdvisor(pointcut, advice);
       }

       @Bean
       public MethodInterceptor advice() {
           return methodInvocation -> {
               System.out.println("before----");
               return methodInvocation.proceed();
           };
       }

       @Bean
       public Bean1 bean1() {
         return new Bean1();
       }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    static class Bean1 {
        public void foo() {
            System.out.println("Bean1 foo");
        }
        public Bean1() {
            System.out.println("Bean1()");
        }
        @Autowired
        public void setBean2(Bean2 bean2) {
            System.out.println(bean2.getClass());
        }
        @PostConstruct
        public void init() {
            System.out.println("Bean1 init");
        }
    }

    static class Bean2 {

        public Bean2() {
            System.out.println("Bean2()");
        }

        @Autowired
        public void setBean1(Bean1 bean1) {
            System.out.println(bean1.getClass());
        }

        @PostConstruct
        public void init() {
            System.out.println("Bean2 init");
        }
    }
}
