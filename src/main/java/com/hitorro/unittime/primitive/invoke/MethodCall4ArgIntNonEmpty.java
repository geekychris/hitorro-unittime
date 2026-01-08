package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall4ArgIntNonEmpty extends InvokeTimers {

    static int x = 0;
    static MethodCall4ArgIntNonEmpty o;
    static int y = 3;

    public MethodCall4ArgIntNonEmpty() {
        super("o.f (int, int, int, int)");
        setIterations(40);
    }

    void f(int x1, int x2, int x3, int x4) {
        if (x != 0) {
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall4ArgIntNonEmpty();
    }

    public void test() throws Exception {
        int x1 = y, x2 = y, x3 = y, x4 = y;
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
        o.f(x1, x2, x3, x4);
    }
}
