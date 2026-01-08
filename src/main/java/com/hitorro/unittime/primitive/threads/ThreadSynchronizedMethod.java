package com.hitorro.unittime.primitive.threads;

/**
 */
public class ThreadSynchronizedMethod extends ThreadTimers {

    ThreadSynchronizedMethod.Stub o;

    public ThreadSynchronizedMethod() {
        super("object. synchronized f () ");
        setIterations(20);
        o = new ThreadSynchronizedMethod.Stub();
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
    }

    class Stub {
        Stub() {
            // Do nothing
        }

        synchronized void f() {
            // Do nothing
        }
    }
}
