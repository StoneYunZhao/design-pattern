package com.zhaoyun.pattern.concurrency.threadpermessage;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author zhaoyun
 * create at 2019-07-14 14:40
 */
public final class EchoLoomImpl {
    public static void main(String[] args) throws IOException {
        try (ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080))) {
            try {
                while (true) {
                    SocketChannel sc = ssc.accept();
                    Fiber.schedule(() -> {
                        try {
                            ByteBuffer rb = ByteBuffer.allocate(2048);
                            sc.read(rb);
                            rb.flip();
                            sc.write(rb);
                            sc.close();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
                }
            } finally {
                ssc.close();
            }
        }
    }

    /**
     * OpenJDK 的 Loom 项目模拟类，模拟协程的实现。
     */
    private static class Fiber {
        private static void schedule(Runnable r) {

        }
    }
}


