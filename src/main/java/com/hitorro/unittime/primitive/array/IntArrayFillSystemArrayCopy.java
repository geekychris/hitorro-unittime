package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:42 PM
 */
public class IntArrayFillSystemArrayCopy extends ArrayTimers {

    public static final int NOT_AVAILABLE = Integer.MIN_VALUE;
    private int[] m_array;
    private int[] m_arrayTarget;
    private int m_n;

    public IntArrayFillSystemArrayCopy() {
        super("IntArrayFillSystemArrayCopy[ 5 ]");
        this.m_n = 5;
        m_array = new int[m_n];
        m_arrayTarget = new int[m_n];

        for (int i = 0; i < m_n; i++) {
            m_arrayTarget[i] = NOT_AVAILABLE;
        }
    }


    public void test() throws Exception {
        System.arraycopy(m_arrayTarget, 0, m_array, 0, m_n);
    }
}
