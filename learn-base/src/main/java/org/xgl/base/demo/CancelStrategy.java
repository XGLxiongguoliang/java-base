package org.xgl.base.demo;

/**
 * 取消策略接口
 */
public interface CancelStrategy {
    boolean shouldCancel(String nodeName);
}
