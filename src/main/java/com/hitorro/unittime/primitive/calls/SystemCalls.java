package com.hitorro.unittime.primitive.calls;



/**
 * Copyright HiTorro 2003-2007
 * <p/>
 */
public abstract class SystemCalls extends com.hitorro.unittime.primitive.PrimitiveTimers {
    public SystemCalls(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "SystemCalls";
    }
}