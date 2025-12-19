package com.hitorro.unittime.primitive.object;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class ObjectCast extends ObjectTimers {
    private Thread m_thread;
    private Object m_o;

    public ObjectCast() {
        super("object cast");
        setIterations(1);
        m_thread = new Thread();
        m_o = m_thread;
    }

    public void test() throws Exception {
        Thread x = (Thread) m_o;
        if (x == m_thread) {
        }
    }
}
