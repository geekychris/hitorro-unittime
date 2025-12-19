package com.hitorro.unittime.primitive.math;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class ByteArrayNew extends MathTimers {

    private int n;

    public ByteArrayNew() {
        super("new byte[ 10 ]");
        this.n = 10;
    }

    public void test() throws Exception {
        @SuppressWarnings("unused") byte[] b = new byte[n];
    }
}
