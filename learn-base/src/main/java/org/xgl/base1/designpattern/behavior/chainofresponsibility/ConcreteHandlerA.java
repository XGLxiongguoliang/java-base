package org.xgl.base1.designpattern.behavior.chainofresponsibility;

/**
 * @program designpattern.behavior.chainofresponsibility
 * @description 抽象处理实现类A
 * @auther Mr.Xiong
 * @create 2022-03-05 09:24:47
 */
public class ConcreteHandlerA extends Handler {

    @Override
    public void handlerRequest(String request) {
        if ("A".equals(request)) {
            System.out.println("A实现类处理请求");
        } else {
            if (getHandler() != null) {
                System.out.println("A继续找下一个处理者");
                getHandler().handlerRequest(request);
            } else {
                System.out.println("没有可以处理的啦。。。");
            }
        }
    }
}
