package org.xgl.base1.designpattern.structure.composite;

public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子节点" + name + "被访问");
    }
}
