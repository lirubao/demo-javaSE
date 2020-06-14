package com.java.pool.demo03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 测试ScheduleExecutorService接口中延迟执行任务和重复执行任务的功能
 */
public class ScheduleExecutorServiceDemo03 {

    public static void main(String[] args) {
        // 获取一个具备延迟执行任务的线程池对象
        // 创建一个可重用固定线程数的线程池且允许延迟运行或定期执行任务
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "线程名称:" + n++);
            }
        });
        // 创建多个任务对象, 提交任务,每个任务延迟2秒执行
        //for (int i = 1; i <= 10; i++) {
        es.scheduleWithFixedDelay(new MyRunnable3(1), 1, 2, TimeUnit.SECONDS);
        // }
        System.out.println("over");

    }
}

class MyRunnable3 implements Runnable {
    private int id;

    public MyRunnable3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "执行了任务" + id);
    }
}