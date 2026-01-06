package com.hitorro.unittime;

import com.hitorro.util.commandandcontrol.InfoLevel;
import com.hitorro.util.commandandcontrol.Response;
import com.hitorro.util.core.classes.ClassUtil;
import com.hitorro.util.core.string.Fmt;

/**
 * .
 */
public class UnitTimeResult {
    public double milliSecondsPerUnit;
	public double nsPerUnit;
    public double units;
    public String category;
    public String subCategory;
    public String description;
    public Class unitClass;

    public Exception error;


    public String toString() {
        return Fmt.S("millispu: %s, nspu: %s, units: %s, cat: %s, subcat: %s, uclass:%s",
                milliSecondsPerUnit, nsPerUnit, units, category, subCategory, ClassUtil.getBareName(unitClass));
    }

    public void addToRow(Response row) {
        if (error != null) {
            row.addInfo(InfoLevel.Error, Fmt.S("Unhandled exception in %s %s %e", description, error, error));
        } else {
            row.addRow(Double.toString(milliSecondsPerUnit),
					Double.toString(nsPerUnit),
                    Double.toString(units),
                    category,
                    subCategory,
                    description,
                    ClassUtil.getBareName(unitClass));
        }
    }
}
