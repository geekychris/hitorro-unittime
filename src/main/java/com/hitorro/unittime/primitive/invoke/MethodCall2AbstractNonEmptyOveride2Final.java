package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall2AbstractNonEmptyOveride2Final extends MethodCall2AbstractNonEmptyOveride {
    public MethodCall2AbstractNonEmptyOveride2Final() {
        super("(overide method2 final)o.f (int, int) (f = { //Do Nothing })");
        setIterations(40);
    }

    public final void f(final int x1, final int x2) {
        if (x != 1) {
            g();
        }
    }

    public void preTest() {
        o = new MethodCall2AbstractNonEmptyOveride2Final();
    }
}
