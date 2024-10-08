package org.xgl.base1.designpattern.behavior.chainofresponsibility;

/**
 * @program designpattern.behavior.chainofresponsibility
 * @description 抽象处理实现类B
 * @auther Mr.Xiong
 * @create 2022-03-05 09:32:04
 */
public class ConcreteHandlerB extends Handler {

    @Override
    public void handlerRequest(String request) {
        if ("B".equals(request)) {
            System.out.println("B实现类处理请求");
        } else {
            System.out.println("B继续找下一个处理者");
            if (getHandler() != null) {
                getHandler().handlerRequest(request);
            } else {
                System.out.println("没有可以处理的啦。。。");
            }
        }
    }
}
