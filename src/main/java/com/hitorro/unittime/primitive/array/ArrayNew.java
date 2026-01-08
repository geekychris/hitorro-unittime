package com.hitorro.unittime.primitive.array;

/**
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
