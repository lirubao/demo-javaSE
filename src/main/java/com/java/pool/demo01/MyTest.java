package com.java.pool.demo01;

public class MyTest {

    public static void main(String[] args) {
        // 核心线程数(2) / 单个任务执行时间(0.2秒) * 2 = 任务队列长度(20)
        MyThreadPool pool = new MyThreadPool(2, 4, 20);
        for (int i = 0; i < 30; i++) {
            MyTask my = new MyTask(i);
            pool.submit(my);
        }
    }
}
