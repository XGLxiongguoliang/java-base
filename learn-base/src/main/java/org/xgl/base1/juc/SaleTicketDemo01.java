package org.xgl.base1.juc;

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket02 ticket = new Ticket02();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }
        ).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }).start();
    }
}

class Ticket {
    //票的总张数
    private int number = 50;
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余---" + number);
        }
    }
}