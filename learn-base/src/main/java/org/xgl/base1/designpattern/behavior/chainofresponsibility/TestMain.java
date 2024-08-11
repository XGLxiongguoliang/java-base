package org.xgl.base1.designpattern.behavior.chainofresponsibility;

public class TestMain {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();
        Handler handlerD = new ConcreteHandlerD();

        handlerA.setHandler(handlerB);
        handlerB.setHandler(handlerC);
        handlerC.setHandler(handlerD);

        //handlerA.handlerRequest("A");
        handlerA.handlerRequest("C");
    }
}
