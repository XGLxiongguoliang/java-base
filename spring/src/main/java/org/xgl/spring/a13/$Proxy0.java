package org.xgl.spring.a13;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class $Proxy0 extends Proxy implements A13.Foo {

    //private InvocationHandler h;

    public $Proxy0(InvocationHandler h) {
        //this.h = h;
        super(h);
    }

    @Override
    public void foo() {
        //1、功能的增强
        try {
            h.invoke(this, foo, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int bar() {
        //1、功能的增强
        try {
            return (int) h.invoke(this, bar, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    static Method foo;
    static Method bar;
    static {
        try {
            foo = A13.Foo.class.getMethod("foo");
            bar = A13.Foo.class.getMethod("bar");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }
}
