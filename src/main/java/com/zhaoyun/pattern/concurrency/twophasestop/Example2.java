package com.zhaoyun.pattern.concurrency.twophasestop;

/**
 * @author zhaoyun
 * create at 2019-08-13 15:06
 */
public final class Example2 {

    private volatile boolean terminated = false;
    private Thread t = null;
    private boolean started = false;

    public synchronized void start() {
        if (started) return;

        started = true;
        terminated = false;
        t = new Thread(() -> {
            while (!terminated) {
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
        terminated = true;
        if (t != null) {
            t.interrupt();
        }
    }

    private void report() { }
}
