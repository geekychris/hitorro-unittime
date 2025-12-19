package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:41 PM
 */
public class IntArrayDependencyBreakSum2Way extends ArrayTimers {
    private int list[] = new int[1000];

    public IntArrayDependencyBreakSum2Way() {
        super("sum +=int[1000] (break dependency 2 way) ");
        setIterations(1);
    }


    public void test() throws Exception {
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < 1000; i += 2) {
            sum += list[i];
            sum1 += list[i + 1];
        }
        sum += sum1;
    }
}
