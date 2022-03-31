package com.tang.concurren.chap1;


/**
 * @Title: JoinTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 16:07
 * @Version: 1.0
 */

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("child threadOne over ");
        }, "A");

        Thread b = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("child threadTwo over ");
        }, "B");

        a.start();
        b.start();
        System.out.println("wait all child thread over !");
        a.join();
        b.join();

        System.out.println("all child thread over");


    }
}