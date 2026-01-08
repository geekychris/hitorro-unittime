package com.hitorro.unittime.primitive.exception;

/**
 */
public class Throw extends ExceptionTimers {

    int m_n;

    public Throw() {
        super("throw exception 20 stack frames");
        this.m_n = 20;
    }

    public void f(int depth) throws TimeException {
        if (depth == 1) {
            throw new TimeException();
        } else {
            f(depth - 1);
        }
    }

    public void test() throws Exception {
        try {
            f(m_n);
        } catch (TimeException e) {
            // Do nothing
        }
    }

    private static class TimeException extends Exception {
        // Do nothing
    }
}
