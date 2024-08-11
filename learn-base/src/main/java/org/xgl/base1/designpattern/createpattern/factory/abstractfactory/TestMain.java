package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

public class TestMain {
    public static void main(String[] args) {
        Factory huaweiFactory = new HuaweiFactory();
        Phone huaweiPhone = huaweiFactory.getPhone();
        huaweiPhone.start();
        huaweiPhone.listenMusic();
        huaweiPhone.call();

        Router huaweiRouter = huaweiFactory.getRouter();
        huaweiRouter.start();
        huaweiRouter.changeNet();

        Factory xiaomiFactory = new XiaomiFactory();
        Phone xiaomiPhone = xiaomiFactory.getPhone();
        xiaomiPhone.start();
        xiaomiPhone.listenMusic();
        xiaomiPhone.call();

        Router xiaomiRouter = xiaomiFactory.getRouter();
        xiaomiRouter.start();
        xiaomiRouter.changeNet();
    }
}
