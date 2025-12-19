package com.hitorro.unittime.primitive.threads;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class ThreadNewAndStart extends ThreadTimers {
    public ThreadNewAndStart() {
        super("new Thread ().start ()");
    }

    public void test() throws Exception {
        new Thread().start();
    }
}
