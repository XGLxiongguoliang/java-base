package org.xgl.base.designpattern.behavior.visitor;

public interface Element {
    public void accept(Visitor visitor);
}
