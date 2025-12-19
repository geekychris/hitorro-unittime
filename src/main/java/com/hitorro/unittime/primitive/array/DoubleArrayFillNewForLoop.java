package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class DoubleArrayFillNewForLoop extends ArrayTimers {
    public static final double VAL = Double.POSITIVE_INFINITY;
    private double[] d;
    private int n;


    public DoubleArrayFillNewForLoop() {
        super("DoubleArrayFillNewForLoop[ 100 ] with for");
        this.n = 100;
        d = new double[n];
    }


    public void test() throws Exception {
        for (int i = 0; i < n; i++) {
            d[i] = VAL;
        }
    }
}
