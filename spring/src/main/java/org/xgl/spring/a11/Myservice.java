package org.xgl.spring.a11;

import org.springframework.stereotype.Service;

@Service
public class Myservice {
    public Myservice() {

    }

    final public void foo() {
        System.out.println("foo()----");
        bar();
    }

    public void bar() {
        System.out.println("bar()---");
    }
}
