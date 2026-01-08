package com.hitorro.unittime.primitive.array;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */

public abstract class ArrayTimers extends PrimitiveTimers {
    public ArrayTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "array";
    }
}