package com.zhaoyun.pattern.concurrency.workthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池不当，出现死锁的情景
 *
 * @author zhaoyun
 * create at 2019-08-13 11:48
 */
public final class DeadLockExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(() -> {
            try {
                String qq = es.submit(() -> "QQ").get();
                System.out.println(qq);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        es.shutdown();
    }
}
