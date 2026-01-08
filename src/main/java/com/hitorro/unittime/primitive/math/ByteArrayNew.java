package com.hitorro.unittime.primitive.math;

/**
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
