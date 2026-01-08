package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall2AbstractNonEmptyOveride2 extends MethodCall2AbstractNonEmptyOveride {
    public MethodCall2AbstractNonEmptyOveride2() {
        super("(overide method2)o.f (int, int) (f = { //Do Nothing })");
        setIterations(40);
    }

    public void f(int x1, int x2) {
        if (x != 1) {
            g();
        }
    }

    public void preTest() {
        o = new MethodCall2AbstractNonEmptyOveride2();
    }
}
