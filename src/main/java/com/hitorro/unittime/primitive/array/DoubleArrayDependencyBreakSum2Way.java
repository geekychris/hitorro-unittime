package com.hitorro.unittime.primitive.array;

/**
 */
public class DoubleArrayDependencyBreakSum2Way extends ArrayTimers {
    private double list[] = new double[1000];

    public DoubleArrayDependencyBreakSum2Way() {
        super("sum +=double[1000] (break dependency) ");
        setIterations(1);
    }


    public void test() throws Exception {
        double sum = 0.0;
        double sum1 = 0.0;
        for (int i = 0; i < 1000; i += 2) {
            sum += list[i];
            sum1 += list[i + 1];
        }
        sum += sum1;
    }
}
