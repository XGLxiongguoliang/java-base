package org.xgl.base1.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        Integer result = (Integer) futureTask.get();
        System.out.println(result);
    }
}

class MyThread implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "---all()");
        return 1024;
    }
}
