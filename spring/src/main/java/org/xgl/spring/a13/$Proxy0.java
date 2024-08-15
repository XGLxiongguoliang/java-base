package org.xgl.spring.a13;

public class $Proxy0 implements A13.Foo {

    private A13.InvocationHandler h;

    public $Proxy0(A13.InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void foo() {
        //1、功能的增强
        h.invoke();
    }

    @Override
    public void bar() {
        //1、功能的增强
        h.invoke();
    }
}
