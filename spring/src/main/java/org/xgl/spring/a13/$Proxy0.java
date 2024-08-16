package org.xgl.spring.a13;

import java.lang.reflect.Method;

public class $Proxy0 implements A13.Foo {

    private A13.InvocationHandler h;

    public $Proxy0(A13.InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void foo() {
        //1、功能的增强
        try {
            Method foo = A13.Foo.class.getMethod("foo");
            h.invoke(foo, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bar() {
        //1、功能的增强
        try {
            Method bar = A13.Foo.class.getMethod("bar");
            h.invoke(bar, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
