package org.xgl.spring.a13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A13 {
    interface Foo{

        void foo();

        void bar();
    }

    interface InvocationHandler {
        void invoke(Method method, Object[] args) throws Throwable;
    }

    static class Target implements Foo {
        public void foo() {
            System.out.println("target---foo");
        }

        @Override
        public void bar() {
            System.out.println("target---bar");
        }
    }

    public static void main(String[] args) {
         Foo proxy = new $Proxy0(new InvocationHandler() {
             @Override
             public void invoke(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                 System.out.println("before~~~~~");
                 new Target().foo();
                 method.invoke(new Target(), args);
             }
         });

        proxy.foo();
        proxy.bar();
    }
}
