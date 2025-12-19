package com.hitorro.unittime.primitive.array;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:49:12 PM
 */

public abstract class ArrayTimers extends PrimitiveTimers {
    public ArrayTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "array";
    }
}