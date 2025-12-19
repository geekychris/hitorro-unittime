package com.hitorro.unittime.primitive.object;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class InstanceOf extends ObjectTimers {
    private Thread m_thread;
    private Object m_o;

    public InstanceOf() {
        super("instanceof");
        setIterations(1);
        m_thread = new Thread();
        m_o = m_thread;
    }

    public void test() throws Exception {
        if (m_o instanceof Thread) {
        }
    }
}
