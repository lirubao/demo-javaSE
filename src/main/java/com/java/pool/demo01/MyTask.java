package com.java.pool.demo01;

/**
 * 需求：
 * <p>自定义线程池练习，只是任务类</p>
 * <p>包含任务编号，每一个任务执行时间设计为0.2秒</p>
 */
public class MyTask implements Runnable {
    private int id;

    public MyTask() {
    }

    //由于run方法是重写接口中的方法，因此id初始化可以利用构造器方法完成
    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程:" + name + "即将执行任务:" + id);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:" + name + "完成了任务:" + id);
    }
}
