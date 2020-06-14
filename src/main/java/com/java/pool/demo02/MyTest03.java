package com.java.pool.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 练习Executors获取ExecutorService,然后调用方法,提交任务;
 */
public class MyTest03 {
    public static void main(String[] args) {
        test1();
        // test2();
    }

    private static void test2() {
        // 使用工厂类获取线程池对象
        // 创建一个使用单个worker线程的Executor, 且线程池中的所有线程都使用ThreadFactory来创建
        ExecutorService es = Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "线程名称:" + n++);
            }
        });
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale2(i));

        }
    }

    private static void test1() {
        // 使用工厂类获取线程池对象
        // 创建一个使用单个worker线程的Executor,以无界队列方式来运行该线程
        ExecutorService es = Executors.newSingleThreadExecutor();
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale2(i));

        }
    }
}

class MyRunnale2 implements Runnable {
    private int id;

    public MyRunnale2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了..." + id);
    }
}