package com.hitorro.unittime.primitive.invoke;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */
public abstract class InvokeTimers extends PrimitiveTimers {
    public InvokeTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "invoke";
    }
}