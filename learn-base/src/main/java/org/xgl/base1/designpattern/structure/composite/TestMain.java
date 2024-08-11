package org.xgl.base1.designpattern.structure.composite;

public class TestMain {
    public static void main(String[] args) {
        Composite c0 = new Composite("容器0号");
        Composite c1 = new Composite("容器1号");
        Composite c2 = new Composite("容器2号");
        Component l1 = new Leaf("1");
        Component l2 = new Leaf("2");
        Component l3 = new Leaf("3");
        Component l4 = new Leaf("4");
        Component l5 = new Leaf("5");
        c1.add(l1);
        c1.add(l2);
        c1.add(l3);

        c2.add(l4);
        c2.add(l5);

        c0.add(c1);
        c0.add(c2);

        c0.operation();
    }
}
