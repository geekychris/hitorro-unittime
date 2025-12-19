package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright HiTorro 2003-2007
 * <p/>
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Feb 11, 2008 Time: 5:51:33 PM
 */
public class MethodCallEnumOrdinal extends InvokeTimers {
    static MethodCallEmtpy o;

    public MethodCallEnumOrdinal() {
        super("enum.ordinal()");
        setIterations(40);
    }

    void f() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCallEmtpy();
    }

    public void test() throws Exception {
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
        Foo.foo.ordinal();
    }

    public enum Foo {
        foo,
        bla
    }
}
