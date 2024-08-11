package org.xgl.base1.designpattern.createpattern.singleton;

/**
 * @program designpattern.singleton
 * @description 懒加载单例模式
 * @auther Mr.Xiong
 * @create 2022-02-26 10:40:35
 */
public class LazySingleton {
    //添加volatile关键字，防止指令重排
    private volatile static LazySingleton instance = null;

    private LazySingleton() {

    }

    /**
     * 双重判断，防止多线程并发问题
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(LazySingleton.getInstance().hashCode())).start();
        }
    }
}
