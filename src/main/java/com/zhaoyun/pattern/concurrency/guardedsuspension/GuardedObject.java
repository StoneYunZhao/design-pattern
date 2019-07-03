package com.zhaoyun.pattern.concurrency.guardedsuspension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public final class GuardedObject {
    private String obj;

    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();

    private static final int TIMEOUT = 1;

    private final static Map<String, GuardedObject> gos = new ConcurrentHashMap<>();

    public static GuardedObject create(String key) {
        GuardedObject go = new GuardedObject();
        gos.put(key, go);
        return go;
    }

    public static  void handle(String key, String obj) {
        GuardedObject go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    public String get(Predicate<String> p) {
        lock.lock();
        try {
            while (!p.test(obj)) {
                done.await(TIMEOUT, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
        return obj;
    }

    private void onChanged(String obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
