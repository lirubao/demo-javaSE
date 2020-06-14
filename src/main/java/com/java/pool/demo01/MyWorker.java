package com.java.pool.demo01;

import java.util.List;

/**
 * 需求：
 * 编写一个线程类,需要继承Thread类,设计一个属性,用于保存线程的名字;
 * 设计一个集合,用于保存所有的任务;
 */
public class MyWorker extends Thread {

    private List<Runnable> tasks;

    public MyWorker() {
    }

    // 保存线程名字name
    public MyWorker(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        // 判断集合中是否有任务,只要有,就一直执行任务
        while (tasks.size() > 0) {
            Runnable r = tasks.remove(0);
            r.run();
        }
    }

    @Override
    public String toString() {
        return "MyWorker{" +
                "tasks=" + tasks +
                '}';
    }
}
