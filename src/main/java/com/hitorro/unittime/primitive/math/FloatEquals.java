package com.hitorro.unittime.primitive.math;

/**
 */
public class FloatEquals extends MathTimers {

    private float m_m = 1.0f;
    private float m_n = 0.5f;
    public FloatEquals() {
        super("if (x = y) (member float)");
        setIterations(1);
    }

    public void test() throws Exception {
        if (m_m == m_n) {
        }
    }
}
