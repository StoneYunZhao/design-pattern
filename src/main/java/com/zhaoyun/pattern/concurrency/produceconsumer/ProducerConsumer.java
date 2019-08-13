package com.zhaoyun.pattern.concurrency.produceconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhaoyun
 * create at 2019-08-13 19:58
 */
public final class ProducerConsumer {
    private BlockingQueue<Task> bq = new LinkedBlockingQueue<>(2000);

    public void start() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                while (true) {
                    try {
                        List<Task> tasks = pollTasks();
                        // 执行任务
                    } catch (InterruptedException e) { }
                }
            });
        }
    }

    private List<Task> pollTasks() throws InterruptedException {
        List<Task> ts = new LinkedList<>();
        Task t = bq.take();
        while (t != null) {
            ts.add(t);
            t = bq.poll();
        }
        return ts;
    }

    private static class Task { }
}
