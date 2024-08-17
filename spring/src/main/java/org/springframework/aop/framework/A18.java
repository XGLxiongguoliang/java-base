package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.*;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class A18 {
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

        @AfterReturning("execution(* foo())")
        public void afterReturning() {
            System.out.println("afterReturning");
        }

        @AfterThrowing("execution(* foo())")
        public void afterThrowing() {
            System.out.println("afterThrowing");
        }

        @Around("execution(* foo())")
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

    public static void main(String[] args) throws Throwable {
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
           } else if (method.isAnnotationPresent(AfterReturning.class)) {
               String expression = method.getAnnotation(AfterReturning.class).value();
               AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
               pointcut.setExpression(expression);

               AspectJAfterReturningAdvice advice = new AspectJAfterReturningAdvice(method, pointcut, factory);
               Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
               list.add(advisor);
           } else if (method.isAnnotationPresent(Around.class)) {
               String expression = method.getAnnotation(Around.class).value();
               AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
               pointcut.setExpression(expression);

               AspectJAroundAdvice advice = new AspectJAroundAdvice(method, pointcut, factory);
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
         * 2、AspectJAfterAdvice（自身就是一个环绕通知）
         * 3、AspectJReturningAdvice
         * 4、AspectJThrowingAdvice
         */

        /**
         * 通知统一转成环绕通知 MethodInterceptor
         * 其实无论ProxyFactory基于哪种方式创建代理，最后干活的都是调用advice的是一个MethodInvocation对象
         * 1、因为advisor有多个，且一个套一个调用。因此需要一个调用链对象，即MethodInvocation
         * 2、MethodInvocation需要知道有哪些advice，还要知道目标，调用次序如下
         * ---before1------------------------------
         * -------before2---------------
         * ----------target-------advice2    advice1
         * -------after2----------------
         * ---after1--------------------------------
         *
         * 3、从上图看出，环绕通知才适合作为advice,因此before、afterReturning、afterThrowing都会转换成环绕通知
         * 4、统一转换为环绕通知，体现的设计模式中的适配器模式
         * ---对外为了方便使用区分before、afterReturning、afterThrowing
         * ---对内统一都是环绕通知。统一用MethodInterceptor表示
         *
         * 此步骤所有的执行时需要的advice（静态）
         * 1、即统一转换为MethodInterceptor环绕通知。这体现在方法名中的Interceptors上
         * 2、适配如下
         * - MethodBeforeAdviceAdapter将@Before AspectJMethodBeforeAdvice适配为MethodBeforeAdviceInterceptor
         * - AfterReturnAdviceAdapter将@AfterReturning AspectJAfterReturningAdvice适配为AfterReturningAdviceInterceptor
         */
        Target target = new Target();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Target());
        //准备把MethodInvocation放入当前线程
        proxyFactory.addAdvice(ExposeInvocationInterceptor.INSTANCE);
        proxyFactory.addAdvisors(list);

        System.out.println("---------------------------------------------------");
        List<Object> methodInterceptorList = proxyFactory.getInterceptorsAndDynamicInterceptionAdvice(Target.class.getMethod("foo"), Target.class);
        for (Object object : methodInterceptorList) {
            System.out.println(object);
        }


        /**
         * 创建并执行调用链（环绕通知+目标）
         *
         *
         */
        System.out.println("=======================");
        MethodInvocation methodInvocation = new ReflectiveMethodInvocation(
                null,
                target,
                Target.class.getMethod("foo"),
                new Object[0],
                Target.class,
                methodInterceptorList);
        methodInvocation.proceed();

        /**
         * 此步骤模拟调用链过程，是一个简单的递归过程
         * 1、proceed()方法调用链中下一个环绕通知
         * 2、每个环绕通知内部继续调用proceed()
         * 3、调用到没有更多通知了，就调用目标方法
         */


    }
}
