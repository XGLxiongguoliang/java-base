package org.xgl.base.demo;

public class ConcreteNode extends Node {

    public ConcreteNode(String id, String name, CancelStrategy cancelStrategy) {
        super(id, name, cancelStrategy);
    }

    @Override
    public boolean handle() {
        System.out.println("ConcreteNode " + name);
        if (nextNode != null) {
          //  if (cancelStrategy.shouldCancel(nextNode.name)) {
                nextNode.handle();
            //}
        }
        return true;
    }
}
