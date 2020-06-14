package com.java.pool.demo05;

/**
 * 任务类:
 * 包含了商品数量,客户名称,送商品的行为
 */
public class MyTask implements Runnable {

    // 设计一个变量,用于表示商品的数量
    private static int id = 10;
    // 表示客户名称的变量
    private String username;

    public MyTask(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(username + "正在使用" + name + "参与秒杀任务...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 保证线程安全
        synchronized (MyTask.class) {
            if (id > 0)
                System.out.println(username + "使用" + name + "秒杀:" + id-- + "号商品成功啦!");
            else
                System.out.println(username + "使用" + name + "秒杀失败!");
        }
    }
}
