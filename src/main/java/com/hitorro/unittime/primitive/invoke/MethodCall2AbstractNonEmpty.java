package com.hitorro.unittime.primitive.invoke;


/**
 */
public class MethodCall2AbstractNonEmpty extends MethodCall2AbstractNonEmptyBase {
    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    public void preTest() {
        MethodCall2AbstractNonEmptyBase.o = new MethodCall2AbstractNonEmpty();
    }
}
