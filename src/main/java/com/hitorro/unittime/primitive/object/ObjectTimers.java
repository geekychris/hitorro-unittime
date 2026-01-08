package com.hitorro.unittime.primitive.object;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */
public abstract class ObjectTimers extends PrimitiveTimers {
    public ObjectTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "Object";
    }
}