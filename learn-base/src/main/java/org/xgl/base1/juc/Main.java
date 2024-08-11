package org.xgl.base1.juc;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            Thread.State.NEW.name();
            TimeUnit.DAYS.sleep(100);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}