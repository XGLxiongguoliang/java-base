package org.xgl.base1;

import java.util.Scanner;

/**
 * 流程控制if-else
 * 1、条件判断之间可以嵌套
 * 2、条件语句的顺序问题
 * @如果多个条件之间是互斥的关系，多个条件语句上下顺序是自由的
 * @如果多个条件之间存在包含关系，要求范围小的写在范围大的上面
 */
public class Day002ProcessControl {
    public static void main(String[] args){
//        ifAndElse();
//        scannerTest();
//        scannerIfAndEles();
        scannerSort();
    }

    public static void ifAndElse(){
        int age = 25;

        if(age == 16){
            System.out.println("还只是个初中生呢！");
        }

        if(age>=18){
            System.out.println("你已经成年了！");
        }else{
            System.out.println("你还未成年！");
        }

        if(age>130 || age<0){
            System.out.println("估计你不是人！");
        }else if(age<30){
            System.out.println("伦家还很年轻呢，只有"+age+"岁！");
        }else{
            System.out.println("哈哈哈，年纪貌似有点大了撒。。。");
        }
    }

    public static void scannerTest(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个字符串！");
        String str = s.next();
        System.out.println(str);
    }

    public static void scannerIfAndEles(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入小明的期末成绩：（分）!");
        int score = s.nextInt();
        if(score == 100){
            System.out.println("奖励一辆BMW！");
        }else if(score > 80 && score <= 99){
            System.out.println("奖励一台iphone5s！");
        }else if(score >= 60 && score <= 80){
            System.out.println("奖励一本参考书！");
        }else{
            System.out.println("什么都没有！");
        }
    }

    public static void scannerSort(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入第一个整数！");
        int num1 = s.nextInt();
        System.out.println("请输入第二个整数！");
        int num2 = s.nextInt();
        System.out.println("请输入第三个整数！");
        int num3 = s.nextInt();

        if(num1 > num2){
            if(num3 > num1){
                System.out.println(num2+"-"+num1+"-"+num3);
            }else if(num3 < num2){
                System.out.println(num3+"-"+num2+"-"+num1);
            }else{
                System.out.println(num2+"-"+num3+"-"+num1);
            }
        }else{
            if(num3 > num2){
                System.out.println(num1+"-"+num2+"-"+num3);
            }else if(num3 < num1){
                System.out.println(num3+"-"+num1+"-"+num2);
            }else{
                System.out.println(num1+"-"+num3+"-"+num2);
            }
        }
    }
}
