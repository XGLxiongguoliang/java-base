package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 华为手机类
 * @auther Mr.Xiong
 * @create 2023-12-24 15:51:20
 */
public class HuaweiPhone implements Phone {
    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void listenMusic() {
        System.out.println("华为手机挺音乐");
    }
}
