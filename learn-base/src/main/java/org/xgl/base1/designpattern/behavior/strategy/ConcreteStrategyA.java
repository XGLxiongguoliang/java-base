package org.xgl.base1.designpattern.behavior.strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略 A");
    }
}
