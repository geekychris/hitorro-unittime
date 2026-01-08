package com.hitorro.unittime.primitive.object;

/**
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
