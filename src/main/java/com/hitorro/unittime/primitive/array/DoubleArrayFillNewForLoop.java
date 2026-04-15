package com.hitorro.unittime.primitive.array;

/**
 */
public class DoubleArrayFillNewForLoop extends ArrayTimers {
    public static double VAL = Double.POSITIVE_INFINITY;
    private double[] d;
    private int n;


    public DoubleArrayFillNewForLoop() {
        super("DoubleArrayFillNewForLoop[ 100 ] with for");
        this.n = 100;
        d = new double[n];
    }


    public void test() throws Exception {
        for (int i = 0; i < n; i++) {
            d[i] = VAL;
        }
    }
}
