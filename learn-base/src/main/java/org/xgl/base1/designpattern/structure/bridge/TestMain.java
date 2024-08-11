package org.xgl.base1.designpattern.structure.bridge;

public class TestMain {
    public static void main(String[] args) {
        Brand brand = new Dior();
        Color color = new Red();

        Bag bag = new HandBag();
        bag.setBrand(brand);
        bag.setColor(color);

        bag.getName();
        bag.brand.getBrand();
        bag.color.getColor();
    }
}
