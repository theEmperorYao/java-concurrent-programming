package com.tang.concurren.chap1;


import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

/**
 * @Title: ThreadLocalTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 18:01
 * @Version: 1.0
 */

public class ThreadLocalTest {


    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            localVariable.set("threadOne local variable");
            print("threadOne");
            System.out.println("threadOne remove after" + ":" + localVariable.get());
        }, "A").start();

        new Thread(() -> {
            localVariable.set("threadTwo local variable");
            print("threadTwo");
            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        }, "B").start();

    }

    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }

}