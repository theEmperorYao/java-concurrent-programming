package com.tang.concurren.chap1;


/**
 * @Title: TestThreadLocal
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 18:29
 * @Version: 1.0
 */

public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    InheritableThreadLocal

    public static void main(String[] args) {

        threadLocal.set("Hello World!");
        new Thread(() -> {
            System.out.println("thread:" + threadLocal.get());
        }, "A").start();
        System.out.println("main :" + threadLocal.get());
    }
}