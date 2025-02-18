package org.xgl.base.demo2;

public abstract class Task<T> {
    protected String name;
    protected T source;

    public Task(String name, T task) {
        this.name = name;
        this.source = task;
    }

    public abstract void cancel();
}
