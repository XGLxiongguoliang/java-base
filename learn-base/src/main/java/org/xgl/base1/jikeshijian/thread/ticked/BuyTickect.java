package org.xgl.base1.jikeshijian.thread.ticked;

/**
 * @program jikeshijian.thread.ticked
 * @description 买票
 * @auther Mr.Xiong
 * @create 2021-05-30 17:23:05
 */
public class BuyTickect implements Runnable {
    private int total = 0;

    public BuyTickect (int total) {
        this.total = total;
    }

    @Override
    public void run() {
        while (total >= 0 && total <= 100) {
            -- total;
            System.out.println("减票线程:---" +Thread.currentThread().getName() + "----剩余票数：" + total);
            if (total == 0) {
                System.out.println("票已经卖完了,开始生产票啦。。。");
                System.out.println("停止10秒卖票，等待票生产到100张");
                try {
                    Thread.currentThread().sleep(10000);
                    SellTicket sellTicket = new SellTicket();
                    Thread sellThread = new Thread(sellTicket);
                    sellThread.start();
                } catch (Exception e) {

                }
            }
        }
    }
}
