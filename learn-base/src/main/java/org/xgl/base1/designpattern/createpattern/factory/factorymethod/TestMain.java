package org.xgl.base1.designpattern.createpattern.factory.factorymethod;

public class TestMain {
    public static void main(String[] args) {
        new HuaWeiFactory().getPhone().call();

        new XiaoMiFactory().getPhone().call();
    }
}
