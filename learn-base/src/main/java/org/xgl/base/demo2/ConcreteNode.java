package org.xgl.base.demo2;

import java.util.List;

public class ConcreteNode extends Node {

    public ConcreteNode(String id, String name, CancelStrategy cancelStrategy, List<ConcreteTask> taskList) {
        super(id, name, cancelStrategy, taskList);
    }

    @Override
    public boolean handle() {
        System.out.println("ConcreteNode " + name + ": Processing...");
        // 节点中需要处理的任务，进行取消处理
        if (this.taskList != null) {
            this.taskList.forEach(task -> task.cancel());
        }
        return true;
    }
}
