package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 黄色
 * @auther Mr.Xiong
 * @create 2022-02-26 16:01:35
 */
public class Yellow implements Color  {
    @Override
    public void getColor() {
        System.out.println("我是黄色的");
    }
}
