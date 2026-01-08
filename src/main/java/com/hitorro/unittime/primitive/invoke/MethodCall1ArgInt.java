package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCall1ArgInt extends InvokeTimers {

    static MethodCall1ArgInt o;
    static int y = 3;

    public MethodCall1ArgInt() {
        super("o.f (int)");
        setIterations(40);
    }

    void f(int x1) {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall1ArgInt();
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
