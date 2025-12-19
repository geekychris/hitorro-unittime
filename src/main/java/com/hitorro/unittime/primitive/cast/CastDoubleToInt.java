package com.hitorro.unittime.primitive.cast;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:33 PM
 */
public class CastDoubleToInt extends CastTimers {
    private int xx;
    private double xxD = 1344234.00;

    public CastDoubleToInt() {
        super("double xx = (int)xxD");
        setIterations(1);
    }

    public void test() throws Exception {
        xx = (int) xxD;
    }
}
