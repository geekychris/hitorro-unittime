package com.hitorro.unittime.primitive.threads;

/**
 */
public class ThreadJoin extends ThreadTimers {
    private Thread t;

    public ThreadJoin() {
        super("thread.join ()");
    }

    public void preTest() {
        t = new Thread();
        t.start();
    }

    public void test() throws Exception {
        try {
            t.join();
        } catch (InterruptedException e) {
            // Do nothing
        }
    }
}
