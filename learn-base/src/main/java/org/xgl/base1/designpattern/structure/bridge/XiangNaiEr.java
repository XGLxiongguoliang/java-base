package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 香奈儿
 * @auther Mr.Xiong
 * @create 2022-02-26 16:02:53
 */
public class XiangNaiEr implements Brand {
    @Override
    public void getBrand() {
        System.out.println("我是香奈儿包包");
    }
}
