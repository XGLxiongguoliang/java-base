package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 挎包
 * @auther Mr.Xiong
 * @create 2022-02-26 16:21:03
 */
public class HandBag extends Bag {
    @Override
    public void getName() {
        System.out.println("我是一个手提包包");
    }
}
