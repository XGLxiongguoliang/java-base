package org.xgl.base.designpattern.createpattern.factory.factorymethod;

public class XiaoMiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new XiaoMiPhone();
    }
}
