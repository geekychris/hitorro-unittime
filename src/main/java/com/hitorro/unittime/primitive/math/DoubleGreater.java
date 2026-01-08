package com.hitorro.unittime.primitive.math;

/**
 */
public class DoubleGreater extends MathTimers {

    private double m_m = 1.0;
    private double m_n = 0.5;

    public DoubleGreater() {
        super("x > y (member double)");
        setIterations(2);
    }


    public void test() throws Exception {
        if (m_m > m_n) {
            if (m_m < m_n) {
            }
        }
    }
}
