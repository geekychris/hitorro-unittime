package com.hitorro.unittime.primitive.invoke;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MethodCall2ArgIntReflectiveTestNonEmpty extends InvokeTimers {

    static MethodCall2ArgIntReflectiveTestNonEmpty o;
    static int x = 0;
    static int y = 3;
    Method method;

    public MethodCall2ArgIntReflectiveTestNonEmpty() {
        super("(relective) o.f(int, int) (f = {if (x != 0) g();})");
        setIterations(40);
        try {
            method = MethodCall0ArgsReflective.getMethod(this.getClass(), "f",
                    new Class[]{Integer.TYPE, Integer.TYPE});
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void f(int x1, int x2) {
        if (x != 0) {
            g();
        }
    }

    void g() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall2ArgIntReflectiveTestNonEmpty();
    }

    public void test() throws Exception {
        int x1 = y, x2 = y;
        Object foo[] = new Object[]{x1, x2};

        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
        method.invoke(o, foo);
    }
}
