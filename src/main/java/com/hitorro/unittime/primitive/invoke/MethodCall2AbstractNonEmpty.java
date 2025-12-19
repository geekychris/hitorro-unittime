package com.hitorro.unittime.primitive.invoke;


/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:51 PM
 */
public class MethodCall2AbstractNonEmpty extends MethodCall2AbstractNonEmptyBase {
    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    public void preTest() {
        MethodCall2AbstractNonEmptyBase.o = new MethodCall2AbstractNonEmpty();
    }
}
