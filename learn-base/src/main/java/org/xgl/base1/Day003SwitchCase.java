package org.xgl.base1;

import java.util.Scanner;

/**
 * switch(变量){
 *     case 量1:
 *
 *     case 量2:
 *
 *     case 量3:
 *
 *     default:
 *
 * }
 * 1、根据变量的值，选择相应的case去判断，一旦满足case条件
 * 就执行case相应的语句。如果没有break或者已经到结尾的华，会继续执行其下的case语句
 * 2、default:是可选的，而且位置是灵活的
 * 3、变量可以是哪些类型？ char byte short int String(jdk1.7)
 * 4、case之后的条件只能是明确的值，不能是个范围
 */
public class Day003SwitchCase {
    public static void main(String[] args){
//        testSwitch1(2);
//        testSwitch2("WINNER");
//        testSwitch3(8);
        testSwitch4(15);
    }

    public static void testSwitch1(int i){
        switch (i){
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
                break;
        }
    }

    public static void testSwitch2(String s){
        switch (s){
            case "SPRING":
                System.out.println("春天");
                break;
            case "SUMMER":
                System.out.println("夏天");
                break;
            case "AUTUMN":
                System.out.println("秋天");
                break;
            case "WINNER":
                System.out.println("冬天");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }

    public static void testSwitch3(int i){
        switch (i){
            case 12:
            case 1:
            case 2:
                System.out.println("春天！");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春天！");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏天！");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋天！");
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    public static void testSwitch4(int i){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        System.out.println("请输入日期：");
        int day = sc.nextInt();
        int sum =0; //记录是2014年的第几谈
        switch (month){
            case 12:
                sum += 30;
            case 11:
                sum += 31;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                sum += 28;
            case 2:
                sum += 31;
            case 1:
                sum += day;
        }
        System.out.println(sum);
    }
}
