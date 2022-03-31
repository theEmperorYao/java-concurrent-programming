package com.tang.concurren.chap1;


/**
 * @Title: DaemonThreadTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 17:51
 * @Version: 1.0
 */

public class DaemonThreadTest {

    public static void main(String[] args) {

        Thread a = new Thread(() -> {

            for (; ; ) {

            }
        }, "A");
        a.setDaemon(true);
        a.start();
        System.out.println("main thread is over");



    }
}