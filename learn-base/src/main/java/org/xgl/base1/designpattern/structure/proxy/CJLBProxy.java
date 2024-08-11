package org.xgl.base1.designpattern.structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CJLBProxy {
    static class Target {
        //如果方法被private、static、final修饰，则代理对象得不到增强
        public void eat() {
            System.out.println("吃吃吃~~。。。。。");
        }
    }

    public static void main(String[] args) {
        Target object = (Target) Enhancer.create(Target.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("吃吃吃~~Before。。。。。");
                method.invoke(new Target(), objects);// 用的反射
                methodProxy.invoke(new Target(), objects);// 用的不是反射
                methodProxy.invokeSuper(o, objects);// 用的不是反射
                System.out.println("吃吃吃~~After。。。。。");
                return null;
            }
        });
        object.eat();
    }
}
