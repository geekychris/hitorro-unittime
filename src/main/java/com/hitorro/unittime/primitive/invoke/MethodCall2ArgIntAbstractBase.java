package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public abstract class MethodCall2ArgIntAbstractBase extends InvokeTimers {

    static MethodCall2ArgIntAbstractBase o;
    static int y = 3;

    public MethodCall2ArgIntAbstractBase() {
        super("(abstract)o.f (int, int)");
        setIterations(40);
    }

    void f(int x1, int x2) {
        //Do Nothing
    }

    public void test() throws Exception {
        int x1 = y, x2 = y;
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
    }
}
