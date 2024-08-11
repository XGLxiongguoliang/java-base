package org.xgl.base1.designpattern.structure.adapter.classa;

/**
 * @program designpattern.structure.adapter.classa
 * @description 小米手机
 * @auther Mr.Xiong
 * @create 2022-02-26 15:17:53
 */
public class XiaoMiPhoneLine extends Adapter implements XiaoMiPowerHead {
    @Override
    public void phonePower() {
        System.out.println("小米手机充电");
    }
}
