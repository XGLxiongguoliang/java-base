package org.xgl.base1.designpattern.structure.bridge;

/**
 * @program designpattern.structure.bridge
 * @description 钱包
 * @auther Mr.Xiong
 * @create 2022-02-26 16:21:24
 */
public class Wallet extends Bag {
    @Override
    public void getName() {
        System.out.println("我是一个钱包包");
    }
}
