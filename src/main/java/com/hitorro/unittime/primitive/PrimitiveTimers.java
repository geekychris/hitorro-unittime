package com.hitorro.unittime.primitive;

import com.hitorro.unittime.UnitTimer;


/**
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
