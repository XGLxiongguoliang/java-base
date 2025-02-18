package org.xgl.base.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flow {
    private Map<String, Node> nodes = new HashMap<>();
    private Node startNode;

    public Flow() {
        // 创建节点及其取消策略
        ConcreteTask task11 = new ConcreteTask("task11", null);
        ConcreteTask task12 = new ConcreteTask("task12", null);
        List<ConcreteTask> taskList11 = new ArrayList<>();
        taskList11.add(task11);
        taskList11.add(task12);
        Node node1 = new ConcreteNode("Node1", "Start Process", new ImmediateCancelStrategy(), taskList11);

        ConcreteTask task21 = new ConcreteTask("task21", null);
        ConcreteTask task22 = new ConcreteTask("task22", null);
        List<ConcreteTask> taskList22 = new ArrayList<>();
        taskList22.add(task21);
        taskList22.add(task22);
        Node node2 = new ConcreteNode("Node2", "Process Step 1", new DelayedCancelStrategy(), taskList22);

        ConcreteTask task31 = new ConcreteTask("task31", null);
        ConcreteTask task32 = new ConcreteTask("task32", null);
        List<ConcreteTask> taskList33 = new ArrayList<>();
        taskList33.add(task31);
        taskList33.add(task32);
        Node node3 = new ConcreteNode("Node3", "Process Step 2", new ImmediateCancelStrategy(), taskList33);

        // 设置节点间的顺序
        node1.setNext(node2);
        node2.setNext(node3);

        // 设置流程的起始节点
        this.startNode = node1;

        // 将节点放入节点映射
        nodes.put(node1.id, node1);
        nodes.put(node2.id, node2);
        nodes.put(node3.id, node3);
    }

    // 执行流程
    public void execute() {
        if (startNode != null) {
            startNode.handle();
        }
    }
}
