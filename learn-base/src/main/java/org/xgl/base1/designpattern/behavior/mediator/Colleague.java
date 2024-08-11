package org.xgl.base1.designpattern.behavior.mediator;

/**
 * @program designpattern.behavior.mediator
 * @description 抽象同事类
 * @auther Mr.Xiong
 * @create 2022-03-05 11:05:58
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}
