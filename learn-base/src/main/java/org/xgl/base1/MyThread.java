package org.xgl.base1;

/**
 * @program PACKAGE_NAME
 * @description 定义一个线程类
 * @auther Mr.Xiong
 * @create 2020-01-16 16:54
 */
public class MyThread extends Thread {
    public void run() {
        for (int i = 1; i < 51; i++) {
            System.out.println("第" + i + "次循环：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();

        System.out.println(myThread.getName() + "******************");
    }
}
