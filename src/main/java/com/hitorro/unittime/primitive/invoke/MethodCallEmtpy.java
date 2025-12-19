package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MethodCallEmtpy extends InvokeTimers {

    static MethodCallEmtpy o;

    public MethodCallEmtpy() {
        super("o.f ()");
        setIterations(40);
    }

    void f() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCallEmtpy();
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
}
