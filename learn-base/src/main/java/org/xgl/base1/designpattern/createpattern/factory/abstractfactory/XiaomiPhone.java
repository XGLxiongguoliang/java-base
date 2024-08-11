package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 小米手机对象
 * @auther Mr.Xiong
 * @create 2023-12-24 15:50:39
 */
public class XiaomiPhone implements Phone {
    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void listenMusic() {
        System.out.println("小米手机挺音乐");
    }
}
