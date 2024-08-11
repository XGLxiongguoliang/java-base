package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 迪奥
 * @auther Mr.Xiong
 * @create 2022-02-26 16:04:09
 */
public class Dior implements Brand {
    @Override
    public void getBrand() {
        System.out.println("我是迪奥包包");
    }
}
