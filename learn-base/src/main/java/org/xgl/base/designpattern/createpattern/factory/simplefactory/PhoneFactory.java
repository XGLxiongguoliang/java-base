package org.xgl.base.designpattern.createpattern.factory.simplefactory;

public class PhoneFactory {
    public Phone getPhone(String type) {
        if ("xiaomi".equals(type)) {
            return new XiaoMiPhone();
        } else if ("huawei".equals(type)) {
            return new HuaWeiPhone();
        } else if ("oppo".equals(type)) {
            return new OppoPhone();
        }
        return null;
    }
}
