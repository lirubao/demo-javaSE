package com.java.pool.demo02;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 练习Executors获取ExecutorService,测试关闭线程池的方法;
 */
public class MyTest04 {
    public static void main(String[] args) {
        // test1();
        test2();
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
        for (int i = 1; i <= 10; i++) {
            es.submit(new MyRunnale3(i));
        }
        // 立刻关闭线程池,如果线程池中还有缓存的任务,没有执行,则取消执行,并返回这些任务
        List<Runnable> nowList = es.shutdownNow();
        System.out.println(nowList);
    }

    private static void test1() {
        // 使用工厂类获取线程池对象
        // 创建一个使用单个worker线程的Executor,以无界队列方式来运行该线程
        ExecutorService es = Executors.newSingleThreadExecutor();
        // 提交任务
        for (int i = 0; i <= 10; i++) {
            es.submit(new MyRunnale3(i));
        }
        // 关闭线程池,仅仅是不再接受新的任务, 以前的任务还会继续执行
        es.shutdown();
        // es.submit(new MyRunnale3(88)); // 不能再次提交新的任务了
    }
}

class MyRunnale3 implements Runnable {
    private int id;

    public MyRunnale3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了..." + id);
    }

    @Override
    public String toString() {
        return "MyRunnale3{" +
                "id=" + id +
                '}';
    }
}