package org.xgl.spring.a11;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //该切面没有被Spring容器管理
public class MyAspect {
    @Before("execution(* org.xgl.spring.a11.Myservice.*())")
    public void before() {
        System.out.println("before()");
    }
}
