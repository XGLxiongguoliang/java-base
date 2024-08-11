package org.xgl.base1.temp;

/**
 * @program temp
 * @description 测试
 * @auther Mr.Xiong
 * @create 2020-07-11 16:
 */
public class Foo {
    static int boolValue;
    public static void main( String[] args) {
        boolValue = 3;
        if (boolValue == 3) {
            System.out.println("Hello java");
        }
        if (boolValue == 3) {
            System.out.println("hello jvm");
        }
    }
}
