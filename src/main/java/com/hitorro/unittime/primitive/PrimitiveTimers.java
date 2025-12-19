package com.hitorro.unittime.primitive;

import com.hitorro.unittime.UnitTimer;


/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 6:49:35 PM
 */
public abstract class PrimitiveTimers extends UnitTimer {
    public PrimitiveTimers(String desc) {
        super(desc);
    }

    public String getCategory() {
        return "Datum";
    }

    public String getSubCategory() {
        return "Primitive_Sub";
    }
}
