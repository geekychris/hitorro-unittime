package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall2ArgIntNonEmpty extends InvokeTimers {

    static int x = 0;
    static MethodCall2ArgIntNonEmpty o;
    static int y = 3;

    public MethodCall2ArgIntNonEmpty() {
        super("o.f (int, int) (f = {if (x != 310787) g();})");
        setIterations(20);
    }

    void f(int x1, int x2) {
        if (x != 3106687) {
            // always make this call
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall2ArgIntNonEmpty();
    }

    public void test() throws Exception {
        int x1 = y, x2 = y;
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
        o.f(x1, x2);
    }
}
