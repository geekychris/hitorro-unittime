package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class Array2DAssign extends ArrayTimers {
    private Object[][] m_array;
    private int n;

    public Array2DAssign() {
        super("x = m_array[ i + c ][i + c]");
        setIterations(10);
        m_array = new Object[20][20];
    }

    public void test() throws Exception {
        int i = 0;
        Object x0;
        Object x1;
        Object x2;
        Object x3;
        Object x4;
        Object x5;
        Object x6;
        Object x7;
        Object x8;
        Object x9;
        x0 = m_array[i + 0][i + 0];
        x1 = m_array[i + 1][i + 1];
        x2 = m_array[i + 2][i + 2];
        x3 = m_array[i + 3][i + 3];
        x4 = m_array[i + 4][i + 4];
        x5 = m_array[i + 5][i + 5];
        x6 = m_array[i + 6][i + 6];
        x7 = m_array[i + 7][i + 7];
        x8 = m_array[i + 8][i + 8];
        x9 = m_array[i + 9][i + 9];
        Object y0;
        Object y1;
        Object y2;
        Object y3;
        Object y4;
        Object y5;
        Object y6;
        Object y7;
        Object y8;
        Object y9;
        y0 = m_array[i + 10][i + 10];
        y1 = m_array[i + 11][i + 11];
        y2 = m_array[i + 12][i + 12];
        y3 = m_array[i + 13][i + 13];
        y4 = m_array[i + 14][i + 14];
        y5 = m_array[i + 15][i + 15];
        y6 = m_array[i + 16][i + 16];
        y7 = m_array[i + 17][i + 17];
        y8 = m_array[i + 18][i + 18];
        y9 = m_array[i + 19][i + 19];
    }
}
