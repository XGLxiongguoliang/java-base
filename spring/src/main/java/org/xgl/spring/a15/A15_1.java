package org.xgl.spring.a15;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class A15_1 {

    @Aspect
    static class MyAspect {
        @Before("execution(* foo())")
        public void before() {
            System.out.println("前置切点");
        }

        @After("execution(* foo())")
        public void after() {
            System.out.println("后置切点");
        }
    }

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
    }
}
