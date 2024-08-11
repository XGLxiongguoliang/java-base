package org.xgl.base1.designpattern.behavior.template;

public abstract class AbstractClass {
    public void templateMethod() {
        specificTemplateMethod();
        abstractTemplateMethod01();
        abstractTemplateMethod02();
    }

    public void specificTemplateMethod() {
        System.out.println("抽象类中的具体方法");
    }

    public abstract void abstractTemplateMethod01();

    public abstract void abstractTemplateMethod02();
}
