package com.hitorro.unittime.primitive.math;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:44 PM
 */
public class IntGreater extends MathTimers {

    private int xx = 10, yy = 5;

    public IntGreater() {
        super("x > y , x < y (member int)");
        setIterations(2);
    }


    public void test() throws Exception {
        if (yy > xx) {
            if (yy < xx) {
            }
        }
    }
}
