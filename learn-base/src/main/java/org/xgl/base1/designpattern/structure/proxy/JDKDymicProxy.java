package org.xgl.base1.designpattern.structure.proxy;

import java.lang.reflect.Proxy;

public class JDKDymicProxy {
    interface Person {
        Integer eat();
    }

     static class Men implements Person {
        @Override
        public Integer eat() {
            System.out.println("男人喜欢吃肉！！！");
            return 10;
        }
    }

    public static void main(String[] args) {
        Person proxy = (Person) Proxy.newProxyInstance(JDKDymicProxy.class.getClassLoader(),
                new Class[]{Person.class},
                (proxy1, method, args1) -> {
                    System.out.println("eat之前增强-----------");
                    method.invoke(new Men(), args1);
                    System.out.println("eat之后增强-----------");
                    return 100;
                });
        proxy.eat();
    }
}
