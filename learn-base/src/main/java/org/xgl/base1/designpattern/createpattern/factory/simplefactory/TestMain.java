package org.xgl.base1.designpattern.createpattern.factory.simplefactory;

public class TestMain {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.getPhone("xiaomi").call();
        phoneFactory.getPhone("huawei").call();
        phoneFactory.getPhone("oppo").call();
    }
}
