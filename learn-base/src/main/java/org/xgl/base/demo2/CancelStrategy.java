package org.xgl.base.demo2;

/**
 * 取消策略接口
 */
public interface CancelStrategy {
    boolean shouldCancel(String nodeName);
}
