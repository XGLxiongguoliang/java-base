package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 华为工厂
 * @auther Mr.Xiong
 * @create 2023-12-24 15:56:42
 */
public class HuaweiFactory implements Factory {
    @Override
    public Phone getPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Router getRouter() {
        return new HuaweiRouter();
    }
}
