package com.hitorro.unittime.primitive.array;

/**
 */
public class IntArrayFillNewForLoop extends ArrayTimers {

    public static final int NOT_AVAILABLE = Integer.MIN_VALUE;
    private int[] m_array;
    private int m_n;

    public IntArrayFillNewForLoop() {

        super("IntArrayFillNewForLoop[  5 ]");
        this.m_n = 5;
        m_array = new int[m_n];

    }


    public void test() throws Exception {
        for (int i = 0; i < m_n; i++) {
            m_array[i] = NOT_AVAILABLE;
        }
    }
}
