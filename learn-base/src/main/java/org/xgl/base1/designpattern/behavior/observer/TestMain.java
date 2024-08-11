package org.xgl.base1.designpattern.behavior.observer;

public class TestMain {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observerA = new ContreteObserverA();
        Observer observerB = new ContreteObserverB();
        subject.add(observerA);
        subject.add(observerB);

        subject.notifyAllObserver();
    }
}
