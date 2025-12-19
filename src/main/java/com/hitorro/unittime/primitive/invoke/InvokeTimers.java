package com.hitorro.unittime.primitive.invoke;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 1:30:26 PM
 */
public abstract class InvokeTimers extends PrimitiveTimers {
    public InvokeTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "invoke";
    }
}