package com.hitorro.unittime.primitive.math;

/**
 */
public class IntCompareAssign extends MathTimers {

    private int x = 10;
    private int y = 5;
    private int a = 100;
    private int b = 200;
    private int z = 0;

    public IntCompareAssign() {
        super("if (x > y) z = a else z = b");
    }

    public void test() throws Exception {
        if (x > y) {
            z = a;
        } else {
            z = b;
        }
    }
}
