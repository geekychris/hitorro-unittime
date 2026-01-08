package com.hitorro.unittime.primitive.exception;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 */

public abstract class ExceptionTimers extends PrimitiveTimers {
    public ExceptionTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "exception";
    }
}