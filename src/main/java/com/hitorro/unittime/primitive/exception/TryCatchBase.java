package com.hitorro.unittime.primitive.exception;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 23, 2006 Time: 12:04:04 AM
 */
public class TryCatchBase extends ExceptionTimers {

    static int x0;
    static TryCatchBase o;

    public TryCatchBase() {
        super("Try Catch Base Test");
        setIterations(20);
    }

    void f() throws TryCatchBase.StubException {
        if (x0 != 0) {
            g();
        }
    }

    void g() {
        // Do nothing
    }

    public void preTest() {
        o = new TryCatchBase();
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

    @SuppressWarnings("serial")
    static class StubException extends Exception {
        // Do nothing
    }
}
