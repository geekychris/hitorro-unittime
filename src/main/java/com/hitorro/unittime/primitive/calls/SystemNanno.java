package com.hitorro.unittime.primitive.calls;

/**
 * Copyright HiTorro 2003-2007
 * <p/>
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Feb 7, 2008 Time: 5:12:03 PM
 */
public class SystemNanno extends SystemCalls {

    private long m_m;
    private long m_n;

    public SystemNanno() {
        super("x = System.nanoTime()");
        setIterations(100);
    }


    public void preTest() {
        m_m = m_n = 1;
    }

    public void test() throws Exception {
        long x;
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();

        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
        x = System.nanoTime();
    }
}

