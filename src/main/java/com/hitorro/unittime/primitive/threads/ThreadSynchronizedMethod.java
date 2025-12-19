package com.hitorro.unittime.primitive.threads;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class ThreadSynchronizedMethod extends ThreadTimers {

    ThreadSynchronizedMethod.Stub o;

    public ThreadSynchronizedMethod() {
        super("object. synchronized f () ");
        setIterations(20);
        o = new ThreadSynchronizedMethod.Stub();
    }

    public void test() throws Exception {
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
    }

    class Stub {
        Stub() {
            // Do nothing
        }

        synchronized void f() {
            // Do nothing
        }
    }
}
