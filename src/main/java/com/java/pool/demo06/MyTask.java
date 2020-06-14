package com.java.pool.demo06;

public class MyTask implements Runnable {
    private String username;
    private double money;
    private static double total = 1000;

    public MyTask(String username, double money) {
        this.username = username;
        this.money = money;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(username + "正在准备使用" + name + "取款:" + money + "元");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (MyTask.class) {
            if (total - money > 0) {
                System.out.println(username + "使用" + name + "取款:" + money + "元成功,余额:" + (total - money));
                total -= money;
            } else
                System.out.println(username + "使用" + name + "取款:" + money + "元失败,余额:" + total);
        }
    }
}
