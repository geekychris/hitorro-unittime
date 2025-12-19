package com.hitorro.unittime.primitive.threads;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 1:25:57 PM
 */
public abstract class ThreadTimers extends PrimitiveTimers {
    public ThreadTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "thread";
    }
}
