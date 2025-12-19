package com.hitorro.unittime.primitive.object;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 1:27:30 PM
 */
public abstract class ObjectTimers extends PrimitiveTimers {
    public ObjectTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "Object";
    }
}