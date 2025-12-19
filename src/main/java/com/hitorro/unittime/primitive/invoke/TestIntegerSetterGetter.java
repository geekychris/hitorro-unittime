package com.hitorro.unittime.primitive.invoke;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 27, 2006 Time: 2:24:25 AM
 */
public class TestIntegerSetterGetter {
    private Integer m_value = new Integer(1111);

    public Integer get() {
        return m_value;
    }

    public void set(Integer val) {
        m_value = val;
    }
}
