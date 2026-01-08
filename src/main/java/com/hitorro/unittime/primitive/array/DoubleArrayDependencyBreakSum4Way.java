package com.hitorro.unittime.primitive.array;

/**
 */
public class DoubleArrayDependencyBreakSum4Way extends ArrayTimers {
    private double list[] = new double[1000];

    public DoubleArrayDependencyBreakSum4Way() {
        super("sum +=double[1000] (break dependency 4 way) ");
        setIterations(1);
    }


    public void test() throws Exception {
        double sum = 0.0;
        double sum1 = 0.0;
        double sum2 = 0.0;
        double sum3 = 0.0;
        for (int i = 0; i < 1000; i += 4) {
            sum += list[i];
            sum1 += list[i + 1];
            sum2 += list[i + 2];
            sum3 += list[i + 3];
        }
        sum += sum1;
        sum2 += sum3;
        sum += sum2;
    }
}
