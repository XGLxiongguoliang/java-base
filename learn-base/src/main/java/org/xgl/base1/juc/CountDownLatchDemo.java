package org.xgl.base1.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "----OUT");
                count.countDown();
            }, String.valueOf(i)).start();
        }
        count.await();
        System.out.println("close door!!!");
    }
}
