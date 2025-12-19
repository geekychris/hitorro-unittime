package com.hitorro.unittime.primitive.cast;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class Cast3FromObject extends CastTimers {
    private Object o0;
    private Object o1;
    private Object o2;
    private Object o3;
    private Object o4;
    private Object o5;
    private Object o6;
    private Object o7;
    private Object o8;
    private Object o9;

    private A a0;
    private A a1;
    private A a2;
    private A a3;
    private A a4;
    private A a5;
    private A a6;
    private A a7;
    private A a8;
    private A a9;

    public Cast3FromObject() {
        super("a = (A) o (Object o instanceOf D, D <- C <- B <- A)");
        setIterations(10);
        o0 = o1 = o2 = o3 = o4 = o5 = o6 = o7 = o8 = o9 = new Cast3FromObject.D();
    }

    public void test() throws Exception {
        a0 = (Cast3FromObject.A) o0;
        a1 = (Cast3FromObject.A) o1;
        a2 = (Cast3FromObject.A) o2;
        a3 = (Cast3FromObject.A) o3;
        a4 = (Cast3FromObject.A) o4;
        a5 = (Cast3FromObject.A) o5;
        a6 = (Cast3FromObject.A) o6;
        a7 = (Cast3FromObject.A) o7;
        a8 = (Cast3FromObject.A) o8;
        a9 = (Cast3FromObject.A) o9;
    }

    static class A {
        // Do nothing
    }

    static class B extends Cast3FromObject.A {
        // Do nothing
    }

    static class C extends Cast3FromObject.B {
        // Do nothing
    }

    static class D extends Cast3FromObject.C {
        // Do nothing
    }
}
