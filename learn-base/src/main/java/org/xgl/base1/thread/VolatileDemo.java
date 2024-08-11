package org.xgl.base1.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        VolatileThread volatileThread = new VolatileThread();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(volatileThread);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println("count---" + volatileThread.count);
        ReentrantLock reentrantLock = new ReentrantLock();
    }
}
class VolatileThread implements Runnable {

    public AtomicInteger count = new AtomicInteger();

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        addCount();
    }

    void addCount() {
        for (int i = 0; i < 10000; i++) {
            count.getAndIncrement();
        }
    }
}
