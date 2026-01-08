package com.hitorro.unittime.primitive.invoke;

/**
 */
public class MethodCallEmtpy extends InvokeTimers {

    static MethodCallEmtpy o;

    public MethodCallEmtpy() {
        super("o.f ()");
        setIterations(40);
    }

    void f() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCallEmtpy();
    }

    public void test() throws Exception {
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
        o.f();
    }
}
