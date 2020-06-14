package com.java.pool.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 练习Executors获取ExecutorService,然后调用方法,提交任务;
 */
public class MyTest02 {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test2() {
        // 使用工厂类获取线程池对象
        // 创建一个可重用固定线程数的线程池且线程池中的所有线程都使用ThreadFactory来创建
        ExecutorService es = Executors.newFixedThreadPool(3, new ThreadFactory() {
            int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "线程名称:" + n++);
            }
        });
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale1(i));

        }
    }

    private static void test1() {
        // 使用工厂类获取线程池对象
        // 创建一个可重用固定线程数的线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale1(i));

        }
    }
}

class MyRunnale1 implements Runnable {
    private int id;

    public MyRunnale1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了..." + id);
    }
}