package org.xgl.spring.a12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {
    interface Foo {
        void foo();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("Target----foo");
        }
    }

    public static void main(String[] args) {
        //目标对象
        Target target = new Target();
        //用来加载运行期间动态生成的字节码
        ClassLoader loader = JdkProxyDemo.class.getClassLoader();
        Foo foo = (Foo) Proxy.newProxyInstance(
                loader,
                new Class[]{Foo.class}, //代理类要实现的接口
                new InvocationHandler(){ //代理类要执行的一些行为
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before----");
                        Object object = method.invoke(target, args);
                        return object;
                    }
                }
        );

        foo.foo();
    }
}
