package org.xgl.base1.designpattern.behavior.memento;

/**
 * @program designpattern.behavior.memento
 * @description 管理者具体类
 * @auther Mr.Xiong
 * @create 2022-03-05 14:54:39
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
