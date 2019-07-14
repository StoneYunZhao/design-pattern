package com.zhaoyun.pattern.concurrency.balking;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyun
 * create at 2019-07-14 08:54
 */
public final class AutoSave {
    private boolean changed = false;

    private ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    private void startAutoSave() {
        ses.scheduleWithFixedDelay(this::autoSave, 5, 5, TimeUnit.SECONDS);
    }

    private void autoSave() {
        synchronized (this) {
            if (!changed) {
                return;
            }
            changed = false;
        }

        execSave();
    }

    private void execSave() {
        System.out.println("save");
    }

    public void edit() {
        System.out.println("edit");

        change();
    }

    private void change() {
        synchronized (this) {
            changed = true;
        }
    }
}
