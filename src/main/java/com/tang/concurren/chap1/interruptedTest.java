package com.tang.concurren.chap1;


/**
 * @Title: interruptTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 16:10
 * @Version: 1.0
 */

public class interruptedTest {

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread() + " hello");
            }
        }, "A");
        a.start();

        Thread.sleep(1000);

        System.out.println("main thread interrupt thread");
        a.interrupt();
        a.join();
        System.out.println("main is over");


    }
}