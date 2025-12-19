package com.hitorro.unittime.primitive.math;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:40 PM
 */
public class FloatGreater extends MathTimers {
    private float m_m = 5.6f;
    private float m_n = 2.5f;

    public FloatGreater() {
        super("x > y (member float)");
        setIterations(2);
    }

    public void test() throws Exception {
        if (m_m > m_n) {
            if (m_m < m_n) {
            }
        }
    }
}
