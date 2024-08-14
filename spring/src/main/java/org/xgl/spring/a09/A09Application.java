package org.xgl.spring.a09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("org.xgl.spring.a09")
public class A09Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(A09Application.class);
        E e = context.getBean(E.class);
        System.out.println(e.getF1());
        System.out.println(e.getF1());
        System.out.println(e.getF1());

        System.out.println(e.getF2());
        System.out.println(e.getF2());
        System.out.println(e.getF2());

        System.out.println(e.getF3());
        System.out.println(e.getF3());
        System.out.println(e.getF3());

        System.out.println(e.getF4());
        System.out.println(e.getF4());
        System.out.println(e.getF4());
    }
}
