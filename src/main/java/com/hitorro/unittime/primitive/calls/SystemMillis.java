package com.hitorro.unittime.primitive.calls;

/**
 * Copyright HiTorro 2003-2007
 * <p/>
 */

public class SystemMillis extends SystemCalls {

    private long m_m;
    private long m_n;

    public SystemMillis() {
        super("x = System.currentTimeMillis()");
        setIterations(100);
    }


    public void preTest() {
        m_m = m_n = 1;
    }

    public void test() throws Exception {
        long x;
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();

        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
        x = System.currentTimeMillis();
    }
}
