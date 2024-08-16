package org.xgl.spring.a13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethodInvoke {
    public static void main(String[] args) throws Exception {
        Method foo = TestMethodInvoke.class.getMethod("foo", int.class);
        for (int i = 0; i <= 17; i++) {
            show(i, foo);
            foo.invoke(null, i);
        }
        System.in.read();
    }

    private static void show(int i, Method foo) {
        System.out.println(foo.getName());
        System.out.println(".....");
    }

    public static void foo(int i) {
        System.out.println(i + ":" + "foo");
    }
}
