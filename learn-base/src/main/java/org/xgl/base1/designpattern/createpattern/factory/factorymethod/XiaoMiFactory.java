package org.xgl.base1.designpattern.createpattern.factory.factorymethod;

public class XiaoMiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new XiaoMiPhone();
    }
}
