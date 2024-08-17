package org.xgl.spring.a15;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class A15 {
    public static void main(String[] args) {
        /**
         * 两个切面的概念
         * aspect
         * 通知1（advice）+ 切点1（pointcut）
         * 通知2（advice）+ 切点2（pointcut）
         * 通知3（advice）+ 切点3（pointcut）
         *
         * advisor = 更细粒度的切面，包含一个通知和切点
          */
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");

        //备好通知
        MethodInterceptor adivce = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("before-----");
                Object result = methodInvocation.proceed();
                System.out.println("after-----");
                return result;
            }
        };

        //备好切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, adivce);

        /**
         * 创建代理
         * a、proxyTargetClass = false.目标实现了接口，用jdk实现
         * b、proxyTargetClass = false.目标未实现了接口，用cglib实现
         * c、proxyTargetClass = true，总是用cglib实现
         */
        Target2 target = new Target2();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);
        factory.setInterfaces(target.getClass().getInterfaces());
        factory.setProxyTargetClass(true);
        Target2 proxy = (Target2) factory.getProxy();
        System.out.println(proxy.getClass());
        proxy.foo();
        proxy.bar();
    }

    interface T1 {
        void foo();
        void bar();
    }

    static class Target1 implements T1 {

        @Override
        public void foo() {
            System.out.println("target1 foo");
        }

        @Override
        public void bar() {
            System.out.println("target1 bar");
        }
    }

    static class Target2 {

        public void foo() {
            System.out.println("target1 foo");
        }

        public void bar() {
            System.out.println("target1 bar");
        }
    }
}
