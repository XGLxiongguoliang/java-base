package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 包
 * @auther Mr.Xiong
 * @create 2022-02-26 15:59:55
 */
abstract class Bag {
    protected Color color;
    protected Brand brand;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void getName() {
    }
}
