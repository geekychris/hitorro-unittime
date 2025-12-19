package com.hitorro.unittime.primitive.cast;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class DoubleTableByteIndex extends CastTimers {
    private double m_table[] = getTable();
    private byte xxB = 110;
    private double xxD;


    public DoubleTableByteIndex() {
        super("xx = (double)xxByte ");

        setIterations(1);
    }

    private static final double[] getTable() {
        double temptable[] = new double[256];
        for (int i = 0; i < 256; i++) {
            temptable[i] = i;
        }
        return temptable;
    }

    public void test() throws Exception {
        xxD = m_table[xxB];
    }
}
