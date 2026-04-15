package com.hitorro.unittime.primitive.array;

/**
 */
public class DoubleArrayFillSystemArrayCopy extends ArrayTimers {
    public static double VAL = Double.POSITIVE_INFINITY;
    double[] d;
    double[] dFill;
    int n;

    public DoubleArrayFillSystemArrayCopy() {
        super("DoubleArrayFillSystemArrayCopy[ 100 ] with System.arrayCopy");
        this.n = 100;
        d = new double[n];
        dFill = new double[n];

        for (int i = 0; i < n; i++) {
            dFill[i] = VAL;
        }
    }


    public void test() throws Exception {
        System.arraycopy(dFill, 0, d, 0, n);
    }
}
