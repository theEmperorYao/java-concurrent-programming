package com.tang.concurren.chap1;


/**
 * @Title: Test1
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 15:10
 * @Version: 1.0
 */

public class Test1 {


    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread a = new Thread(() -> {
            methodA();
        }, "A");
        a.start();

        Thread b = new Thread(() -> {
            methodB();
        }, "B");
        b.start();

        a.join();
        b.join();
        System.out.println("main over");


    }

    private static void methodB() {
        try {
            Thread.sleep(1000);
            synchronized (resourceA) {
                System.out.println("threadB get resourceA lock");
                System.out.println("threadB try get resourceB lock...");
                synchronized (resourceB) {
                    System.out.println("threadB get resourceB lock");
                    System.out.println("ThreadB release resourceA lock");
                    resourceA.wait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void methodA() {
        try {
            synchronized (resourceA) {
                System.out.println("threadA get resourceA lock");
                synchronized (resourceB) {
                    System.out.println("threadA get resourceB lock");
                    System.out.println("ThreadA release resourceA lock");
                    resourceA.wait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}