package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 华为路由器
 * @auther Mr.Xiong
 * @create 2023-12-24 15:55:01
 */
public class HuaweiRouter implements Router {
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void changeNet() {
        System.out.println("华为路由器转换网络");
    }
}
