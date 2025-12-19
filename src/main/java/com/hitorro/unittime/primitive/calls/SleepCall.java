package com.hitorro.unittime.primitive.calls;

/**
 *
 */
public class SleepCall extends SystemCalls {
    public SleepCall() {
        super("Thread.sleep(1 second)");
        setIterations(1);
    }


    public void preTest() {
    }

    public void test() throws Exception {
        Thread.sleep(1000);
    }
}
