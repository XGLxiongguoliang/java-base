package org.xgl.base1;

/**
 * @program PACKAGE_NAME
 * @description ***
 * @auther Mr.Xiong
 * @create 2020-01-16 16:50
 */
public class CheckStringSame {
    public static boolean checkSame(String str, String same) {
        String[] array = str.split(same);
        if (array.length > 2) {
            return true;
        } else if (array.length == 2) {
            if (array[0].split(same).length > 1 || array[1].split(same).length > 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b = checkSame("xxxxxxxsfsfsfxxxxx", "sfsfsf");
        System.out.println(b);
    }
}
