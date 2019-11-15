package com.lazyxu.study.thread;

public class TicketThread extends Thread{

    private int ticket=20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：" + (this.ticket--));
            }
        }
    }
}
