package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MethodCall2ArgIntInterfaceTestNonEmpty extends InvokeTimers implements MethodCall2ArgIntInterface {

    static MethodCall2ArgIntInterface o;
    static int x = 0;
    static int y = 3;

    public MethodCall2ArgIntInterfaceTestNonEmpty() {
        super("(interface )o.f (int, int) (f = {if (x != 310687) g();})");
        setIterations(40);
    }

    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall2ArgIntInterfaceTest();
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
