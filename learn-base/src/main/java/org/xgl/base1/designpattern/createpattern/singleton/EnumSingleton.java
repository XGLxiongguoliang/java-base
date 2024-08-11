package org.xgl.base1.designpattern.createpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;

public enum EnumSingleton {
    INSTANCE;

    private static ConcurrentHashMap<String, String> instance = new ConcurrentHashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            instance.put(Integer.toString(i), Integer.toString(i));
        }
    }

    private static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(EnumSingleton.getInstance().hashCode());
                System.out.println(EnumSingleton.getInstance().instance);
            }).start();
        }
    }
}
