package org.springframework.aop.framework.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.SingletonAspectInstanceFactory;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.annotation.AspectJAdvisorFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class A17_2 {
    static class Aspect {
        @Before("execution(* foo())")
        public void before1() {
            System.out.println("before1");
        }

        @Before("execution(* foo())")
        public void before2() {
            System.out.println("before2");
        }

        public void after() {
            System.out.println("after");
        }

        public void afterReturning() {
            System.out.println("afterReturning");
        }

        public void afterThrowing() {
            System.out.println("afterThrowing");
        }

        public Object around(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("around");
            return pjp.proceed();
        }
    }

    static class Target {
        public void foo() {
            System.out.println("Target---foo");
        }
    }

    public static void main(String[] args) {
        AspectInstanceFactory factory = new SingletonAspectInstanceFactory(new Aspect());
        List<Advisor> list = new ArrayList<>();
        for (Method method : Aspect.class.getDeclaredMethods()) {
           if (method.isAnnotationPresent(Before.class)) {
               String expression = method.getAnnotation(Before.class).value();
               AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
               pointcut.setExpression(expression);

               AspectJMethodBeforeAdvice advice = new AspectJMethodBeforeAdvice(method, pointcut, factory);
               Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
               list.add(advisor);
           }
        }

        for (Advisor advisor : list) {
            System.out.println(advisor);
        }

        /**
         * @Before 前置通知会被转换成下面原始的AspectJmethodBeforeAdvice形式，该对象包含了如下信息
         * 1、通知代码从哪里来
         * 2、切点是什么
         * 3、通知对象如何创建，本例子共用了同一个Aspect对象，
         * 类似的通知还有
         * 1、AspectJAroundAdvice
         * 2、AspectJAfterAdvice
         * 3、AspectJReturningAdvice
         * 4、AspectJThrowingAdvice
         */
    }
}
