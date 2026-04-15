package com.hitorro.unittime.primitive.array;

/**
 */
public class DoubleArrayFillClone extends ArrayTimers {
    public static double VAL = Double.POSITIVE_INFINITY;
    private double[] d;
    private double[] dFill;
    private int n;


    public DoubleArrayFillClone() {
        super("DoubleArrayFillClone[ 100 ] with clone");
        this.n = 100;
        d = new double[n];
        dFill = new double[n];

        for (int i = 0; i < n; i++) {
            dFill[i] = VAL;
        }
    }


    public void test() throws Exception {
        d = dFill.clone();
    }
}
