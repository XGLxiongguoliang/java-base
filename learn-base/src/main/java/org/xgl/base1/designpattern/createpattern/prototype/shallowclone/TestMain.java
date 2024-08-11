package org.xgl.base1.designpattern.createpattern.prototype.shallowclone;

public class TestMain {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Bike cloneBike = bike.clone();
        System.out.println("bike---" + bike);
        System.out.println("cloneBike---" + cloneBike);
        System.out.println(bike.equals(cloneBike));
    }
}
