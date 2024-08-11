package org.xgl.base1.designpattern.behavior.template;

public class TestMain {
    public static void main(String[] args) {
        AbstractClass abstractClass = new SpecificClass();
        abstractClass.templateMethod();
    }
}
