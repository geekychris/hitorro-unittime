package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MethodCall3ArgInt extends InvokeTimers {

    static MethodCall3ArgInt o;
    static int y = 3;

    public MethodCall3ArgInt() {
        super("o.f(int, int, int)");
        setIterations(40);
    }

    void f(int x1, int x2, int x3) {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall3ArgInt();
    }

    public void test() throws Exception {
        int x1 = y, x2 = y, x3 = y;
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
    }
}
