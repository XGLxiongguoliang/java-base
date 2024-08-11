package org.xgl.base1.designpattern.structure.proxy;

/**
 * @program designpattern.structure.proxy
 * @description 真实的项目类
 * @auther Mr.Xiong
 * @create 2022-02-26 14:39:28
 */
public class RealSubject implements Subject {
    @Override
    public void createSubject() {
        System.out.println("创建一个真实的项目");
    }
}
