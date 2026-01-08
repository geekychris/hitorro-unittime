package com.hitorro.unittime.primitive.exception;

/**
 */
public class TryCatch extends ExceptionTimers {

    static int x0;
    static TryCatch.StubObject o;

    public TryCatch() {
        super("try {...} catch (StubException e) {...}");

    }

    public void init() {
        setBaseMsecsPerTest(getContext().executeTest(new TryCatchBase()).milliSecondsPerUnit);
        o = new TryCatch.StubObject();
    }

    public void test() throws Exception {
        try {
            o.f();
        } catch (TryCatch.StubException e) {
            x0 = 1;
        }

    }

    @SuppressWarnings("serial")
    static class StubException extends Exception {
        // Do nothing
    }

    static class StubObject {
        void f() throws TryCatch.StubException {
            if (x0 != 0) {
                g();
            }
        }

        void g() {
            // Do nothing
        }
    }
}
