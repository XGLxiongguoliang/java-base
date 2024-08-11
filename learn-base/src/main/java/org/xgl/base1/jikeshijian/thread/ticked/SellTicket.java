package org.xgl.base1.jikeshijian.thread.ticked;

/**
 * @program jikeshijian.thread.ticked
 * @description 卖票
 * @auther Mr.Xiong
 * @create 2021-05-30 17:11:56
 */
public class SellTicket implements Runnable {
    //定义总票数100
    private int total = 0;

    @Override
    public void run() {
        while (total <= 100) {
            ++ total;
            System.out.println("增票线程:---" +Thread.currentThread().getName() + "----剩余票数：" + total);

            if (total == 100) {
                try {
                    System.out.println("票数已经达到100,开始卖票啦。。。。");
                    System.out.println("停止生产票,待票售卖完。。。");
                    Thread.currentThread().sleep(10000);
                    BuyTickect buyTickect = new BuyTickect(total);
                    Thread buyThread = new Thread(buyTickect);
                    buyThread.start();
                } catch (Exception e) {

                }
            }
        }
    }
}
