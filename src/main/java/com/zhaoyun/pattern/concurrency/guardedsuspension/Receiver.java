package com.zhaoyun.pattern.concurrency.guardedsuspension;

/**
 * 服务 A 另外一个线程收到服务 B 的返回后，把结果反映到 GuardedObject
 */
public final class Receiver {
    public void handle(String id, String resp) {
        GuardedObject.handle(id, resp);
    }
}
