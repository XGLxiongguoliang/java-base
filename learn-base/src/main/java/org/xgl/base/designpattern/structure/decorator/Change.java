package org.xgl.base.designpattern.structure.decorator;

public class Change implements SunWukong {

    public SunWukong sunWukong;

    public Change(SunWukong sunWukong) {
        this.sunWukong = sunWukong;
    }

    @Override
    public void display() {
    }
}
