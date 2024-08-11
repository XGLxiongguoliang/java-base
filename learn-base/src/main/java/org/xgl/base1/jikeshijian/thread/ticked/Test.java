package org.xgl.base1.jikeshijian.thread.ticked;

/**
 * @program jikeshijian.thread.ticked
 * @description 生产票
 * @auther Mr.Xiong
 * @create 2021-05-30 17:14:24
 */
public class Test {

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread sellThread = new Thread(sellTicket);
        sellThread.start();
    }

}
