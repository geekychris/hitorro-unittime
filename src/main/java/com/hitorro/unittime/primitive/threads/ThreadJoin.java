package com.hitorro.unittime.primitive.threads;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
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
