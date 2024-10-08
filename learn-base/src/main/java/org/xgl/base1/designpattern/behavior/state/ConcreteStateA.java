package org.xgl.base1.designpattern.behavior.state;

/**
 * @program designpattern.behavior.state
 * @description 环境A
 * @auther Mr.Xiong
 * @create 2022-03-05 10:00:48
 */
public class ConcreteStateA extends State {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是A");
        context.setName("A");
        context.setState(new ConcreteStateB());
    }
}
