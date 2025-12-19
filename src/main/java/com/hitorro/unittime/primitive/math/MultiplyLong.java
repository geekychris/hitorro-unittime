package com.hitorro.unittime.primitive.math;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MultiplyLong extends MathTimers {

    private long m_m;
    private long m_n;

    public MultiplyLong() {
        super("x = x * y (local long)");
        setIterations(100);
    }


    public void preTest() {
        m_m = m_n = 1;
    }

    public void test() throws Exception {
        long x, y;
        x = m_m;
        y = m_n;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        x = x * y;
        m_m = x;
    }
}
