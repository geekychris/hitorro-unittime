package com.hitorro.unittime.primitive.math;

/**
 */
public class DoubleEquals extends MathTimers {
    private double m_m = 1.0;
    private double m_n = 0.5;

    public DoubleEquals() {
        super("if (x = y) (member double)");
        setIterations(1);
    }


    public void test() throws Exception {
        if (m_m == m_n) {
        }
    }
}
