package com.hitorro.unittime.primitive.cast;

/**
 */
public class DoubleTableOffsetWithByteIndex extends CastTimers {
    double m_table[];
    private byte xxB = 110;
    private double xxD;
    public DoubleTableOffsetWithByteIndex() {
        super("xx = (double)xxByte (cast byte to double using m_table using 0+ offset)");
        m_table = new double[256];
        for (int i = 0; i < 256; i++) {
            m_table[i] = i;
        }
        setIterations(1);
    }

    public void test() throws Exception {
        xxD = m_table[0 + xxB];
    }
}
