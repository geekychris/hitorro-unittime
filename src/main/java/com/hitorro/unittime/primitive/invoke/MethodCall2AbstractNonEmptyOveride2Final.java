package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:56 PM
 */
public class MethodCall2AbstractNonEmptyOveride2Final extends MethodCall2AbstractNonEmptyOveride {
    public MethodCall2AbstractNonEmptyOveride2Final() {
        super("(overide method2 final)o.f (int, int) (f = { //Do Nothing })");
        setIterations(40);
    }

    public final void f(final int x1, final int x2) {
        if (x != 1) {
            g();
        }
    }

    public void preTest() {
        o = new MethodCall2AbstractNonEmptyOveride2Final();
    }
}
