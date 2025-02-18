package org.xgl.base.demo;


/**
 * 立即取消策略
 */
public class ImmediateCancelStrategy implements CancelStrategy {
    @Override
    public boolean shouldCancel(String nodeName) {
        System.out.println("Node " + nodeName + "：Immediate Cancel");
        return true;
    }
}
