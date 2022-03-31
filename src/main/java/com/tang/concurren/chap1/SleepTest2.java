package com.tang.concurren.chap1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: SleepTest2
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 16:15
 * @Version: 1.0
 */

public class SleepTest2 {
    final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("child threadA is in sleep ");
                Thread.sleep(10000);
                System.out.println("child threadA is awaked");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();


        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("child threadB is in sleep ");
                Thread.sleep(10000);
                System.out.println("child threadB is awaked");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();



    }
}