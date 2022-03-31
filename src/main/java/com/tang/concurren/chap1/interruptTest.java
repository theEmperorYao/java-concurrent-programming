package com.tang.concurren.chap1;


/**
 * @Title: interruptTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 16:10
 * @Version: 1.0
 */

public class interruptTest {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println("ThreadOne begin ");
            for (; ; ) {

            }
        }, "A");

        Thread main = Thread.currentThread();
        Thread b = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            main.interrupt();
        }, "B");
        a.start();
        b.start();

        try {
           a.join();
        } catch (Exception e) {
           e.printStackTrace();
        } 

    }
}