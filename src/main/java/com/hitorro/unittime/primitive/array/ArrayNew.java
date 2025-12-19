package com.hitorro.unittime.primitive.array;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class ArrayNew extends ArrayTimers {

    private int n;

    public ArrayNew() {
        super("new char[ 100 ]");
        this.n = 100;
    }

    public void test() throws Exception {
        char[] a = new char[n];
    }
}
