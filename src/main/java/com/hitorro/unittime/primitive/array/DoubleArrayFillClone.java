package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:38 PM
 */
public class DoubleArrayFillClone extends ArrayTimers {
    public static final double VAL = Double.POSITIVE_INFINITY;
    private double[] d;
    private double[] dFill;
    private int n;


    public DoubleArrayFillClone() {
        super("DoubleArrayFillClone[ 100 ] with clone");
        this.n = 100;
        d = new double[n];
        dFill = new double[n];

        for (int i = 0; i < n; i++) {
            dFill[i] = VAL;
        }
    }


    public void test() throws Exception {
        d = dFill.clone();
    }
}
