package com.hitorro.unittime.primitive.exception;

import com.hitorro.unittime.primitive.invoke.MethodCall0ArgsNonEmpty;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class ThrowsClause extends ExceptionTimers {

    static int x = 0;
    static ThrowsClause.StubObject o;

    public ThrowsClause() {
        super("throws clause: <method> throws StubException {...}");
    }

    public void init() {
        setIterations(20);
        setBaseMsecsPerTest(getContext().executeTest(new MethodCall0ArgsNonEmpty()).milliSecondsPerUnit);
        o = new ThrowsClause.StubObject();
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

    static class StubObject {
        void f() throws ThrowsClause.StubException {
            if (x != 0) {
                g();
            }
        }

        void g() throws ThrowsClause.StubException {
            throw new ThrowsClause.StubException();
        }
    }
}
