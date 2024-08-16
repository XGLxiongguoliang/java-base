package org.xgl.spring.a13;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A13 {
    interface Foo{

        void foo();

        int bar();
    }

    /*interface InvocationHandler {
        Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
    }*/

    static class Target implements Foo {
        public void foo() {
            System.out.println("target---foo");
        }

        @Override
        public int bar() {
            System.out.println("target---bar");
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
         Foo proxy = new $Proxy0(new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                 System.out.println("before~~~~~");
                 new Target().foo();
               return method.invoke(new Target(), args);
             }
         });

        proxy.foo();
        int bar = proxy.bar();
        System.out.println("bar----" + bar);
        System.in.read();
    }
}
