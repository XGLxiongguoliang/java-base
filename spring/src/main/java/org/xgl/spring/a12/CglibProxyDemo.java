package org.xgl.spring.a12;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo {
    static class Target {
        public void foo() {
            System.out.println("Target---foo");
        }
    }

    public static void main(String[] args) {
        //目标对象
        Target target = new Target();
        Target proxy = (Target) Enhancer.create(Target.class,
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        System.out.println("before---");
                        //底层使用反射
                        //Object result = method.invoke(target, args);
                        //内部没有用反射
                        //Object result = methodProxy.invoke(target, args);
                        Object result = methodProxy.invokeSuper(o, args);
                        System.out.println("after····");
                        return result;
                    }
                }
        );
        proxy.foo();
    }
}
