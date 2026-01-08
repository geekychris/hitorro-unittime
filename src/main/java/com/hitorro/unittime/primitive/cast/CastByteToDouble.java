package com.hitorro.unittime.primitive.cast;

/**
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
