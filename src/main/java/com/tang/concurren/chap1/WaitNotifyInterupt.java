package com.tang.concurren.chap1;


/**
 * @Title: WaitNotifyInterupt
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 15:25
 * @Version: 1.0
 */

public class WaitNotifyInterupt {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

//        m1();

        Thread a = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                    System.out.println("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread b = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                    System.out.println("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        Thread c = new Thread(() -> {
            synchronized (object) {
                object.notify();
            }
        }, "C");

//        a.start();

        c.start();
        Thread.sleep(1000);
        b.start();


        a.join();
        b.join();
        c.join();

        System.out.println("main over");


    }

    private static void m1() throws InterruptedException {
        Thread a = new Thread(() -> {

            try {
                System.out.println("---begin---");
                //阻塞当前线程
                synchronized (object) {
                    object.wait();
                    System.out.println(1);
                }

                System.out.println("111111");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "A");
        a.start();


        Thread.sleep(10000);
        synchronized (object) {
            object.notifyAll();
        }

        System.out.println("---beign interrupt threadA---");
        a.interrupt();
        System.out.println("---end interrupt threadA---");
    }

}