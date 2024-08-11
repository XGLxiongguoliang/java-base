package org.xgl.base1.designpattern.behavior.mediator;

/**
 * @program designpattern.behavior.mediator
 * @description 中介抽象类
 * @auther Mr.Xiong
 * @create 2022-03-05 11:02:24
 */
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague);
}
