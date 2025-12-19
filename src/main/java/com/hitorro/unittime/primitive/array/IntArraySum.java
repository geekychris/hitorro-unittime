package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class IntArraySum extends ArrayTimers {
    private int m_array[] = new int[1000];

    public IntArraySum() {
        super("sum +=int[1000]");
        setIterations(1);
    }


    public void test() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += m_array[i];
        }
    }
}
