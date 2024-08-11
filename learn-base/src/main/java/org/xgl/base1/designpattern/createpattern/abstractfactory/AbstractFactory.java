package org.xgl.base1.designpattern.createpattern.abstractfactory;

public interface AbstractFactory {
    public Phone getPhone(String type);
    public Router getRouter(String type);
}
