package org.xgl.base.demo2;

/**
 * 延时取消策略
 */
public class DelayedCancelStrategy implements CancelStrategy {
    @Override
    public boolean shouldCancel(String nodeName) {
        System.out.println("Node " + nodeName + "延迟取消");
        return false;
    }
}
