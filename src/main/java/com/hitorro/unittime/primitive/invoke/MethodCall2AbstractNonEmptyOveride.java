package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:55 PM
 */
public class MethodCall2AbstractNonEmptyOveride extends MethodCall2AbstractNonEmptyBaseOveride {
    public MethodCall2AbstractNonEmptyOveride() {
        // Do nothing
    }

    public MethodCall2AbstractNonEmptyOveride(String message) {
        super(message);
    }

    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    public void preTest() {
        o = new MethodCall2AbstractNonEmptyOveride();
    }
}
