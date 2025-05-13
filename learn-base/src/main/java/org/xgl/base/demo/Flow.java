package org.xgl.base.demo;

import java.util.HashMap;
import java.util.Map;

public class Flow {
    private Map<String, Node> nodes = new HashMap<>();
    private Node startNode;

    public Flow() {
        // 创建节点及其取消策略
        Node node1 = new ConcreteNode("Node1", "Start Process", new ImmediateCancelStrategy());

        Node node2 = new ConcreteNode("Node2", "Process Step 1", new DelayedCancelStrategy());

        Node node3 = new ConcreteNode("Node3", "Process Step 2", new ImmediateCancelStrategy());

        Node node4 = new ConcreteNode("Node4", "End Process", new ImmediateCancelStrategy());

        // 设置节点间的顺序
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        // 设置流程的起始节点
        this.startNode = node1;

        // 将节点放入节点映射
        nodes.put(node1.id, node1);
        nodes.put(node2.id, node2);
        nodes.put(node3.id, node3);
        nodes.put(node4.id, node4);
    }

    // 执行流程
    public void execute() {
        startNode.handle();
    }
}
