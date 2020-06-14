package com.java.pool.demo06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MyTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactory() {
            int id = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "ATM" + id++);
            }
        });
        for (int i = 1; i <= 2; i++) {
            MyTask myTask = new MyTask("客户" + i, 800);
            es.submit(myTask);
        }
        es.shutdown();
    }
}
/**
 * 总结: 线程池使用步骤:
 * 1. 利用Executors工厂类的静态方法,创建线程池对象
 * 2. 编写Runnable或Callable实现类的实例对象
 * 3. 利用ExecutorService的submit方法或ScheduledExecutorService的schedule方法提交并执行线程任务
 * 4. 如果有执行机结果,则处理异步执行结果(Future)
 * 5. 调用shutdown()方法,关闭线程池
 */
