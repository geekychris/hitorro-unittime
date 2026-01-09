package com.hitorro.unittime.primitive.array;

/**
 */
public class IntArrayFillSystemArrayCopy extends ArrayTimers {

    public static final int NOT_AVAILABLE = Integer.MIN_VALUE;
    private int[] m_array;
    private int[] arrayTarget;
    private int m_n;

    public IntArrayFillSystemArrayCopy() {
        super("IntArrayFillSystemArrayCopy[ 5 ]");
        this.m_n = 5;
        m_array = new int[m_n];
        arrayTarget = new int[m_n];

        for (int i = 0; i < m_n; i++) {
            arrayTarget[i] = NOT_AVAILABLE;
        }
    }


    public void test() throws Exception {
        System.arraycopy(arrayTarget, 0, m_array, 0, m_n);
    }
}
