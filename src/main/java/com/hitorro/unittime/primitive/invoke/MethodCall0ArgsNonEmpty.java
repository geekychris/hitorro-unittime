package com.hitorro.unittime.primitive.invoke;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */
public class MethodCall0ArgsNonEmpty extends PrimitiveTimers {

    static int x = 0;
    static MethodCall0ArgsNonEmpty o;

    public MethodCall0ArgsNonEmpty() {
        super("o.f () (f = {if (x != 310687) c();})");
        setIterations(20);
    }

    void f() {
        if (x != 310687) {
            c();
        }
    }

    void c() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall0ArgsNonEmpty();
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
