package org.xgl.base1.designpattern.structure.adapter.object;

public class TestMain {
    public static void main(String[] args) {
        XiaoMiPhoneLine xiaoMiPhoneLine = new XiaoMiPhoneLine(new Adapter());
        xiaoMiPhoneLine.phonePower();
        xiaoMiPhoneLine.computerPower();
    }
}
