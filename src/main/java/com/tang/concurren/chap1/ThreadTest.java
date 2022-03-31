package com.tang.concurren.chap1;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/31 11:53
 * @Version: 1.0
 */

public class ThreadTest {


    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread2");
        }
    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //调用start 为就绪状态，
        // 就绪状态指的是该线程已经获取了除了CPU资源外的其他资源
        new MyThread().start();

        // 任务和代码分离，多个线程可以执行一样的任务
        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();

        String result = futureTask.get();
        System.out.println("result = " + result);

        synchronized (ThreadTest.class) {
            while (true) {
                new ThreadTest().wait();
            }
        }

    }


}