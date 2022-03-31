package com.tang.concurren.chap1;


/**
 * @Title: YieldTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 16:25
 * @Version: 1.0
 */

public class YieldTest implements Runnable {

    public YieldTest() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5 == 0)) {
                String s = Thread.currentThread() + "yield cpu";
                System.out.println(s);
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();

    }
}