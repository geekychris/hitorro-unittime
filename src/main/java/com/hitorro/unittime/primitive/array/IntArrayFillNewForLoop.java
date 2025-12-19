package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:41 PM
 */
public class IntArrayFillNewForLoop extends ArrayTimers {

    public static final int NOT_AVAILABLE = Integer.MIN_VALUE;
    private int[] m_array;
    private int m_n;

    public IntArrayFillNewForLoop() {

        super("IntArrayFillNewForLoop[  5 ]");
        this.m_n = 5;
        m_array = new int[m_n];

    }


    public void test() throws Exception {
        for (int i = 0; i < m_n; i++) {
            m_array[i] = NOT_AVAILABLE;
        }
    }
}
