package org.xgl.base.demo2;

import java.util.List;

public abstract class Node {
    protected String id;
    protected String name;
    //当前节点中包含的任务
    protected List<ConcreteTask> taskList;
    protected CancelStrategy cancelStrategy;
    protected Node nextNode;

    public Node(String id, String name, CancelStrategy cancelStrategy, List<ConcreteTask> taskList) {
        this.id = id;
        this.name = name;
        this.cancelStrategy = cancelStrategy;
        this.taskList = taskList;
    }

    // 执行节点逻辑
    public abstract boolean handle();

    // 设置下一个节点
    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    // 当前节点的取消逻辑
    public void cancel() {
        if (cancelStrategy.shouldCancel(name)) {
            nextNode.cancel();
        } else {
            System.out.println("节点 " + name + " 不需要取消");
        }
    }
}
