package com.hitorro.unittime.primitive.threads;

/**
 */
public class ThreadNewAndStart extends ThreadTimers {
    public ThreadNewAndStart() {
        super("new Thread ().start ()");
    }

    public void test() throws Exception {
        new Thread().start();
    }
}
