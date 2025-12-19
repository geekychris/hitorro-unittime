package com.hitorro.unittime.primitive.object;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class NewObject extends ObjectTimers {

    static NewObject.TenFieldClass c;


    public NewObject() {
        super("new class with 10 fields>, for  5 seconds");
        setIterations(10);
        setTotalMsecs(5 * 1000);
    }

    public void test() throws Exception {
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
        c = new TenFieldClass();
    }

    class TenFieldClass {
        int x0;
        int x1;
        int x2;
        int x3;
        int x4;
        int x5;
        int x6;
        int x7;
        int x8;
        int x9;
    }
}
