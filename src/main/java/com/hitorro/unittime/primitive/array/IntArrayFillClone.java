package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:42 PM
 */
public class IntArrayFillClone extends ArrayTimers {

    public static final int NOT_AVAILABLE = Integer.MIN_VALUE;
    private int[] m_m;
    private int[] m_array;
    private int m_n;

    public IntArrayFillClone() {
        super("IntArrayFillClone[ 5 ] with clone");
        this.m_n = 5;
        m_m = new int[m_n];
        m_array = new int[m_n];

        for (int i = 0; i < m_n; i++) {
            m_array[i] = NOT_AVAILABLE;
        }
    }


    public void test() throws Exception {
        m_m = m_array.clone();
    }
}
