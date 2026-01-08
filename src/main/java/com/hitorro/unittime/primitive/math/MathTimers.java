package com.hitorro.unittime.primitive.math;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */

public abstract class MathTimers extends PrimitiveTimers {
    public MathTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "Math";
    }
}