package com.hitorro.unittime.primitive.cast;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:48:30 PM
 */

public abstract class CastTimers extends PrimitiveTimers {
    public CastTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "cast";
    }
}