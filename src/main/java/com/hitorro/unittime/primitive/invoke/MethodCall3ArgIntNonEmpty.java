package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall3ArgIntNonEmpty extends InvokeTimers {

    static int x = 0;
    static MethodCall3ArgIntNonEmpty o;
    static int y = 3;

    public MethodCall3ArgIntNonEmpty() {
        super("o.f (int, int, int) (f = {if (x != 0) g();})");
        setIterations(40);
    }

    void f(int x1, int x2, int x3) {
        if (x != 0) {
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall3ArgIntNonEmpty();
    }

    public void test() throws Exception {
        int x1 = y, x2 = y, x3 = y;
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
        o.f(x1, x2, x3);
    }
}
