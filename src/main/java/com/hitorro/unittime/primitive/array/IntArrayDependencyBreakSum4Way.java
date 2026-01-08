package com.hitorro.unittime.primitive.array;

/**
 */
public class IntArrayDependencyBreakSum4Way extends ArrayTimers {
    private int list[] = new int[1000];

    public IntArrayDependencyBreakSum4Way() {
        super("sum +=int[1000] (break dependency 4 way) ");
        setIterations(1);
    }


    public void test() throws Exception {
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
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
