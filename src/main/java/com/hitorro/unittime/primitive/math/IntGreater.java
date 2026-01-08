package com.hitorro.unittime.primitive.math;

/**
 */
public class IntGreater extends MathTimers {

    private int xx = 10, yy = 5;

    public IntGreater() {
        super("x > y , x < y (member int)");
        setIterations(2);
    }


    public void test() throws Exception {
        if (yy > xx) {
            if (yy < xx) {
            }
        }
    }
}
