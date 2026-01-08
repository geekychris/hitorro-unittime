package com.hitorro.unittime.primitive.cast;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */

public abstract class CastTimers extends PrimitiveTimers {
    public CastTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "cast";
    }
}