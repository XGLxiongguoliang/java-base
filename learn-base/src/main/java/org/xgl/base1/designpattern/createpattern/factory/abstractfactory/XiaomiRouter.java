package org.xgl.base1.designpattern.createpattern.factory.abstractfactory;

/**
 * @program designpattern.createpattern.factory.abstractfactory
 * @description 小米路由器
 * @auther Mr.Xiong
 * @create 2023-12-24 15:54:41
 */
public class XiaomiRouter implements Router {
    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void changeNet() {
        System.out.println("小米路由器转换网络");
    }
}
