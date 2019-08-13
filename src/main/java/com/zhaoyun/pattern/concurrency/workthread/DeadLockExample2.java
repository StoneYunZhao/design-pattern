package com.zhaoyun.pattern.concurrency.workthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoyun
 * create at 2019-08-13 11:59
 */
public final class DeadLockExample2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            es.execute(() -> {
                CountDownLatch l2 = new CountDownLatch(2);
                for (int j = 0; j < 2; j++) {
                    es.execute(l2::countDown);
                }
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }

        l1.await();

        es.shutdown();
    }
}
