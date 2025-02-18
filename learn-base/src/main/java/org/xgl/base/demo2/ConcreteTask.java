package org.xgl.base.demo2;

public class ConcreteTask extends Task {
    public ConcreteTask(String name, Task task) {
        super(name, task);
    }

    @Override
    public void cancel() {
        System.out.println("ConcreteTask " + name + ": Processing...");
    }
}
