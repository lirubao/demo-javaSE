package com.java.pool.demo05;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 主程序类,测试任务类
 */
public class MyTest {
    public static void main(String[] args) {
        // 1.创建一个线程对象
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(15));
        // 2.创建任务对象
        for (int i = 1; i <= 20; i++) {
            MyTask task = new MyTask("客户:" + i);
            poolExecutor.submit(task);
        }
        // 3.关闭线程池
        poolExecutor.shutdown();
    }
}
