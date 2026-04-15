package com.hitorro.unittime;

import com.hitorro.util.core.classes.ClassUtil;
import com.hitorro.util.core.string.Fmt;

/**
 * Result of a single unit time benchmark measurement.
 */
public class UnitTimeResult {
    public double milliSecondsPerUnit;
    public double nsPerUnit;
    public double units;
    public double instructionCycles;
    public String category;
    public String subCategory;
    public String description;
    public Class unitClass;

    public Exception error;

    public String toString() {
        return Fmt.S("millispu: %s, nspu: %s, units: %s, cycles: %s, cat: %s, subcat: %s, uclass:%s",
                milliSecondsPerUnit, nsPerUnit, units, instructionCycles, category, subCategory, ClassUtil.getBareName(unitClass));
    }
}
