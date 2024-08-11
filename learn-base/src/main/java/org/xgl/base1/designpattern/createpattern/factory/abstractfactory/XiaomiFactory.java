package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 小米工厂
 * @auther Mr.Xiong
 * @create 2023-12-24 15:57:08
 */
public class XiaomiFactory implements Factory {
    @Override
    public Phone getPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Router getRouter() {
        return new XiaomiRouter();
    }
}
