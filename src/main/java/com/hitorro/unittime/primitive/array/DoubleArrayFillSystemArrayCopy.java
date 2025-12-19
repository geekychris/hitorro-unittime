package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:37 PM
 */
public class DoubleArrayFillSystemArrayCopy extends ArrayTimers {
    public static final double VAL = Double.POSITIVE_INFINITY;
    double[] d;
    double[] dFill;
    int n;

    public DoubleArrayFillSystemArrayCopy() {
        super("DoubleArrayFillSystemArrayCopy[ 100 ] with System.arrayCopy");
        this.n = 100;
        d = new double[n];
        dFill = new double[n];

        for (int i = 0; i < n; i++) {
            dFill[i] = VAL;
        }
    }


    public void test() throws Exception {
        System.arraycopy(dFill, 0, d, 0, n);
    }
}
