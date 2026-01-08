package com.hitorro.unittime.primitive.object;

/**
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
