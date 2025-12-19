package com.hitorro.unittime.primitive.invoke;

public class MethodCall1NonEmpty extends InvokeTimers {

    static int x = 0;
    static MethodCall1NonEmpty o;
    static int y = 3;

    public MethodCall1NonEmpty() {
        super("o.f (int) (f = {if (x != 0) g();})");
        setIterations(40);
    }

    void f(int x1) {
        if (x != 0) {
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall1NonEmpty();
    }

    public void test() throws Exception {
        int x1 = y;
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
        o.f(x1);
    }
}
