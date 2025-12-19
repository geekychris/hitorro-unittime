package com.hitorro.unittime.primitive.exception;

import com.hitorro.unittime.primitive.PrimitiveTimers;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 24, 2006 Time: 9:47:45 PM
 */

public abstract class ExceptionTimers extends PrimitiveTimers {
    public ExceptionTimers(String detail) {
        super(detail);
    }

    public String getSubCategory() {
        return "exception";
    }
}