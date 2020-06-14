package com.java.pool.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 练习Executors获取ExecutorService,然后调用方法,提交任务;
 * 创建一个默认的线程池对象,里面的线程可重用,且在第一次使用时才创建
 * Executors.newCachedThreadPool(new ThreadFactory()
 */
public class MyTest01 {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test2() {
        // 使用工厂类获取线程池对象
        // 线程池中的所有线程都使用ThreadFactory来创建,这样的线程无需手动启动,自动执行
        ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
            int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "线程名称:" + n++);
            }
        });
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale(i));

        }
    }

    private static void test1() {
        // 使用工厂类获取线程池对象
        // 创建一个默认的线程池对象,里面的线程可重用,且在第一次使用时才创建
        ExecutorService es = Executors.newCachedThreadPool();
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale(i));

        }
    }
}

class MyRunnale implements Runnable {
    private int id;

    public MyRunnale(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了..." + id);
    }
}