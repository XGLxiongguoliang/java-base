package org.xgl.base1.designpattern.behavior.observer;

/**
 * @program designpattern.behavior.observer
 * @description 具体观察者A
 * @auther Mr.Xiong
 * @create 2022-03-05 10:38:58
 */
public class ContreteObserverA implements Observer {
    @Override
    public void response() {
        System.out.println("观察者A收到变动");
    }
}
