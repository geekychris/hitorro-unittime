package com.hitorro.unittime.primitive.array;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class DoubleArraySum extends PrimitiveTimers {

    double list[] = new double[1000];

    public DoubleArraySum() {
        super("sum +=double[1000]");
        setIterations(1);
    }


    public void test() throws Exception {
        double sum = 0.0;
        for (int i = 0; i < 1000; i++) {
            sum += list[i];
        }
    }
}
