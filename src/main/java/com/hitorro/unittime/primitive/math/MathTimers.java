package com.hitorro.unittime.primitive.math;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 1:28:31 PM
 */

public abstract class MathTimers extends PrimitiveTimers {
    public MathTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "Math";
    }
}