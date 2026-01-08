package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall2AbstractNonEmptyOveride extends MethodCall2AbstractNonEmptyBaseOveride {
    public MethodCall2AbstractNonEmptyOveride() {
        // Do nothing
    }

    public MethodCall2AbstractNonEmptyOveride(String message) {
        super(message);
    }

    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    public void preTest() {
        o = new MethodCall2AbstractNonEmptyOveride();
    }
}
