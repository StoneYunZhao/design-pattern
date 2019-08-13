package com.zhaoyun.pattern.concurrency.twophasestop;

/**
 * @author zhaoyun
 * create at 2019-08-13 15:06
 */
public final class Example1 {

    private Thread t = null;
    private boolean started = false;

    public synchronized void start() {
        if (started) return;

        started = true;
        t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                report();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            started = false;
        });
        t.start();
    }

    public synchronized void stop() {
        if (t != null) {
            t.interrupt();
        }
    }

    private void report() { }
}
