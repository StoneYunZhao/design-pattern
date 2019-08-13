package com.zhaoyun.pattern.concurrency.workthread;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoyun
 * create at 2019-08-13 11:38
 */
public final class EchoWorkThreadImpl {


    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(500);
        try (ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080))) {
            try {
                while (true) {
                    SocketChannel sc = ssc.accept();
                    es.execute(() -> {
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
                es.shutdown();
            }
        }
    }
}
