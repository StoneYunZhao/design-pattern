package com.zhaoyun.pattern.concurrency.threadpermessage;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author zhaoyun
 * create at 2019-07-14 14:28
 */
public final class EchoThreadImpl {

    public static void main(String[] args) throws IOException {
        try (ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080))) {
            try {
                while (true) {
                    SocketChannel sc = ssc.accept();
                    new Thread(() -> {
                        try {
                            ByteBuffer rb = ByteBuffer.allocate(2048);
                            sc.read(rb);
                            rb.flip();
                            sc.write(rb);
                            sc.close();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    }).start();
                }
            } finally {
                ssc.close();
            }
        }
    }

}
