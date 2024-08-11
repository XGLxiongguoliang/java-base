package org.xgl.base1.designpattern.createpattern.singleton;

/**
 * @program designpattern.createpattern.singleton
 * @description 内部类单列模式
 * @auther Mr.Xiong
 * @create 2023-12-24 14:29:43
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class InnerClass {
        private final static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerClass.instance;
    }
}
