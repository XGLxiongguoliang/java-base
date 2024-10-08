package org.xgl.base1.designpattern.createpattern.abstractfactory;

public class TestMain {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new PhoneFactory();
        Phone phone = abstractFactory.getPhone("HuaWei");
        phone.call();

        AbstractFactory abstractFactory2 = new RouterFactory();
        Router router = abstractFactory2.getRouter("HuaWei");
        router.receiveNet();
    }
}
