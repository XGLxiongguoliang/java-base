package org.xgl.base1.designpattern.createpattern.factory.factorymethod;

public class HuaWeiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new HuaWeiPhone();
    }
}
