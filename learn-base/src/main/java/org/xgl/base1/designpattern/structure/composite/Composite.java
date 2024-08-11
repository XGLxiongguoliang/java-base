package org.xgl.base1.designpattern.structure.composite;

import java.util.ArrayList;

public class Composite implements Component {

    private String name;

    private ArrayList<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChild(int i) {
        return children.get(i);
    }

    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void operation() {
        System.out.println("容器---" + this.getName() + "---被访问");
        for (Component child : children) {
            child.operation();
        }
    }
}
