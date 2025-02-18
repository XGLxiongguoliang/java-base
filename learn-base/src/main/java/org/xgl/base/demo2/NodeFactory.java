package org.xgl.base.demo2;

import java.util.List;

public class NodeFactory {

    public static Node createNode(String nodeId, String nodeName, String cancelStrategyType, List<ConcreteTask> taskList) {
        CancelStrategy cancelStrategy = createCancelStrategy(cancelStrategyType);
        return new ConcreteNode(nodeId, nodeName, cancelStrategy, taskList);
    }

    private static CancelStrategy createCancelStrategy(String cancelStrategyType) {
        switch (cancelStrategyType) {
            case "ImmediateCancel":
                return new ImmediateCancelStrategy();
            case "DelayedCancel":
                return new DelayedCancelStrategy();
            default:
                throw new IllegalArgumentException("Unknown cancel strategy: " + cancelStrategyType);
        }
    }
}
