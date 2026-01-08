package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall3ArgInt extends InvokeTimers {

    static MethodCall3ArgInt o;
    static int y = 3;

    public MethodCall3ArgInt() {
        super("o.f(int, int, int)");
        setIterations(40);
    }

    void f(int x1, int x2, int x3) {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall3ArgInt();
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
