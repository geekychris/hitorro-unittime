package com.hitorro.unittime.primitive.object;

/**
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
