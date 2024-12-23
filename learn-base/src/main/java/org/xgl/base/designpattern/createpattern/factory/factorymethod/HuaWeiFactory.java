package org.xgl.base.designpattern.createpattern.factory.factorymethod;

public class HuaWeiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new HuaWeiPhone();
    }
}
