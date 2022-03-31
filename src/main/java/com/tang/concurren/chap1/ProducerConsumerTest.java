package com.tang.concurren.chap1;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Title: ProducerConsumerTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 14:34
 * @Version: 1.0
 */

public class ProducerConsumerTest {

    static final int MAX_SIZE = 10;
    static volatile Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {


        new Thread(() -> {
            producer();
        }, "A").start();

        new Thread(() -> {
            consumer();
        }, "B").start();


    }

    private static void consumer() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            queue.poll();
            System.out.println("消费者消费一个");
            queue.notifyAll();

        }
    }

    private static void producer() {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            queue.add(queue.size());
            System.out.println("生产者生产一个");
            queue.notifyAll();

        }
    }

}