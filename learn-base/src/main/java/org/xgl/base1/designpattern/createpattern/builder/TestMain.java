package org.xgl.base1.designpattern.createpattern.builder;

public class TestMain {
    public static void main(String[] args) {
        House house = new BuilderCreater().buildDiJi().buildQiang().buildWuding().buildFenShua().getHouse();
        System.out.println(house.toString());
    }
}
