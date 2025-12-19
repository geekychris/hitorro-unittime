package com.hitorro.unittime.primitive.cast;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */
public class CastInterfaceFromObject extends CastTimers {
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

    private intf i0;
    private intf i1;
    private intf i2;
    private intf i3;
    private intf i4;
    private intf i5;
    private intf i6;
    private intf i7;
    private intf i8;
    private intf i9;

    public CastInterfaceFromObject() {
        super("i = (intf) o (Object o instanceOf D, D <- C <- B <- A impl intf)");
        setIterations(10);
        o0 = o1 = o2 = o3 = o4 = o5 = o6 = o7 = o8 = o9 = new CastInterfaceFromObject.D();
    }

    public void test() throws Exception {
        i0 = (CastInterfaceFromObject.intf) o0;
        i1 = (CastInterfaceFromObject.intf) o1;
        i2 = (CastInterfaceFromObject.intf) o2;
        i3 = (CastInterfaceFromObject.intf) o3;
        i4 = (CastInterfaceFromObject.intf) o4;
        i5 = (CastInterfaceFromObject.intf) o5;
        i6 = (CastInterfaceFromObject.intf) o6;
        i7 = (CastInterfaceFromObject.intf) o7;
        i8 = (CastInterfaceFromObject.intf) o8;
        i9 = (CastInterfaceFromObject.intf) o9;
    }

    private interface intf {
        void f();
    }

    static class A implements CastInterfaceFromObject.intf {
        public void f() {
            // Do nothing
        }
    }

    static class B extends CastInterfaceFromObject.A {
        // Do nothing
    }

    static class C extends CastInterfaceFromObject.B {
        // Do nothing
    }

    static class D extends CastInterfaceFromObject.C {
        // Do nothing
    }
}
