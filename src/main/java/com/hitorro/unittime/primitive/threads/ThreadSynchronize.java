package com.hitorro.unittime.primitive.threads;

/**
 */
public class ThreadSynchronize extends ThreadTimers {
    private Object m_lock;

    public ThreadSynchronize() {
        super("synchronized (m_lock) {}");
        setIterations(10);
        m_lock = new Object();
    }

    public void test() throws Exception {
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }
        synchronized (m_lock) {
            // Do nothing
        }

    }
}
