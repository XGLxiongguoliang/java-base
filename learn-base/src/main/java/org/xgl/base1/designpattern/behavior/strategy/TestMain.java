package org.xgl.base1.designpattern.behavior.strategy;

public class TestMain {
    public static void main(String[] args) {
        Strategy strategyA = new ConcreteStrategyA();
        strategyA.strategyMethod();

        Strategy strategyB = new ConcreteStrategyB();
        strategyB.strategyMethod();
    }
}
