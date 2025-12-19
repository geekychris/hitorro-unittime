package com.hitorro.unittime.primitive.cast;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:31 PM
 */
public class CastByteToDouble extends CastTimers {

    private byte xxB = (byte) 110;
    private double xxD;
    public CastByteToDouble() {
        super("xx = (double)xxByte (cast byte to double)");
        setIterations(1);
    }

    public void test() throws Exception {
        xxD = (double) xxB;
    }
}
