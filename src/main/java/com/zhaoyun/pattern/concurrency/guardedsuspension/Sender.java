package com.zhaoyun.pattern.concurrency.guardedsuspension;

import java.util.Objects;

/**
 * 服务 A 发送请求给服务 B，然后等待请求返回
 */
public final class Sender {
    public void send() {
        String req = "request", id ="id";
        System.out.println("Service A send request to service B: " + req);

        GuardedObject go = GuardedObject.create(id);
        go.get(Objects::nonNull);
    }
}
