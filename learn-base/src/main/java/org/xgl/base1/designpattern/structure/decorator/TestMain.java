package org.xgl.base1.designpattern.structure.decorator;

public class TestMain {
    public static void main(String[] args) {
        SunWukong sunWukong = new Original();
        sunWukong.display();

        SunWukong sunWukong1 = new ZhuBaJie(sunWukong);
        sunWukong1.display();

        SunWukong sunWukong2 = new ErLangShen(sunWukong);
        sunWukong2.display();
    }
}
