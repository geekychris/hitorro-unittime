package com.hitorro.unittime.primitive.cast;

/**
 */
public class CastDoubleToInt extends CastTimers {
    private int xx;
    private double xxD = 1344234.00;

    public CastDoubleToInt() {
        super("double xx = (int)xxD");
        setIterations(1);
    }

    public void test() throws Exception {
        xx = (int) xxD;
    }
}
