package com.hitorro.unittime.primitive.calls;



/**
 * Copyright HiTorro 2003-2007
 * <p/>
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Feb 7, 2008 Time: 5:07:12 PM
 */
public abstract class SystemCalls extends com.hitorro.unittime.primitive.PrimitiveTimers {
    public SystemCalls(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "SystemCalls";
    }
}