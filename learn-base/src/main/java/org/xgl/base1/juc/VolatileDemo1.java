package org.xgl.base1.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo1 {
    private static AtomicInteger num = new AtomicInteger();
    public static void add() {
        num.getAndIncrement();
    }

//    private static volatile int num = 0;
//    public static void add() {
//        num++;
//    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "    " + num);
    }
}
