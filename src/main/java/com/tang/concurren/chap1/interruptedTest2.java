package com.tang.concurren.chap1;


/**
 * @Title: interruptedTest2
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 17:14
 * @Version: 1.0
 */

public class interruptedTest2 {

    public static void main(String[] args) throws InterruptedException {
//        m1();
        m2();

    }

    private static void m2() throws InterruptedException {
        Thread a = new Thread(() -> {
            while (!Thread.interrupted()) {

            }
            System.out.println("threadOne isInterrupted :" + Thread.currentThread());
        }, "A");

        a.start();
        a.interrupt();
//        System.out.println("isInterrupted:" + a.isInterrupted());
//        System.out.println("isInterrupted:" + a.interrupted());
//        System.out.println("isInterrupted:" + Thread.interrupted());
//        System.out.println("isInterrupted:" + a.isInterrupted());
        a.join();
        System.out.println("main thread is over ");


    }

    private static void m1() throws InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println("thread one begin sleep for 2000 seconds");
            try {
                Thread.sleep(2_000_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadOne-leaving normally");
        }, "A");
        a.start();
        Thread.sleep(1000);

        a.interrupt();
        a.join();
        System.out.println("main thread is over ");
    }
}