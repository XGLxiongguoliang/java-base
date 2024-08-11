package org.xgl.base1;

public class Day001ArithmeticOperation {
    public static void main(String[] args){
        int i = 12;
        int j =i/5;
        double d = i/5;
        double d1 = i/5.0;
        System.out.println(j);
        System.out.println(d);//2.0
        System.out.println(d1);//2.4

        int i1 = 12 % 5;//2
        int i2 = -12 % 5;//-2
        int i3 = 12 % (-5);//2
        int i4 = -12 % (-5);//-2
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        int myInt1 = 10;
        int myInt2 = myInt1++;
        System.out.println(myInt1);//11
        System.out.println(myInt2);//10
        int myInt3 = 10;
        int myInt4 = ++myInt3;
        System.out.println(myInt3);//11
        System.out.println(myInt4);//11

        int myInt5 = 10;
        int myInt6 = myInt5--;
        System.out.println(myInt5);//9
        System.out.println(myInt6);//10
        int myInt7 = 10;
        int myInt8 = --myInt7;
        System.out.println(myInt7);//9
        System.out.println(myInt8);//9

    }
}
