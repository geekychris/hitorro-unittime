package com.hitorro.unittime.primitive.threads;

/**
 */
public class ThreadSynchronizeWait extends ThreadTimers {
    private ThreadSynchronizeWait.SignallingThread t;

    public ThreadSynchronizeWait() {
        super("synchronized (m_lock) {while (...) m_lock.wait (); m_lock.notify ();}");
    }

    public void preTest() {
        t = new ThreadSynchronizeWait.SignallingThread();
        t.start();
    }

    public void test() throws Exception {
        try {
            synchronized (t) {
                while (!t.flag) {
                    t.wait();
                }
                t.flag = false;
                t.notify();
            }
        } catch (InterruptedException e) {
            // Do nothing
        }
    }

    public void postTest() {
        synchronized (t) {
            t.exit = true;
            t.notify();
        }
    }

    class SignallingThread extends Thread {
        boolean flag, exit;

        SignallingThread() {
            // Do nothing
        }

        public void run() {
            try {
                while (true) {
                    synchronized (this) {
                        if (exit) {
                            return;
                        }
                        while (flag) {
                            wait();
                        }
                        flag = true;
                        notify();
                    }
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
}
