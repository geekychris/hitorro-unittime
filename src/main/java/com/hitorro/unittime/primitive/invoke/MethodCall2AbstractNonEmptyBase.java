package com.hitorro.unittime.primitive.invoke;

import com.hitorro.unittime.primitive.PrimitiveTimers;


/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:52 PM
 */
public abstract class MethodCall2AbstractNonEmptyBase extends PrimitiveTimers {

    static MethodCall2AbstractNonEmptyBase o;
    static int x = 0;
    static int y = 3;

    public MethodCall2AbstractNonEmptyBase() {
        super("(abstract)o.f (int, int) (f = {if (x != 0) c();})");
        setIterations(40);
    }

    public abstract void f(int x1, int x2);

    void g() {
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
