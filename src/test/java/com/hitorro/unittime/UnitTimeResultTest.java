package com.hitorro.unittime;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for UnitTimeResult.
 */
public class UnitTimeResultTest {

    @Test
    public void testDefaultFieldValues() {
        UnitTimeResult result = new UnitTimeResult();

        assertEquals(0.0, result.milliSecondsPerUnit, 0.0001);
        assertEquals(0.0, result.nsPerUnit, 0.0001);
        assertEquals(0.0, result.units, 0.0001);
        assertEquals(0.0, result.instructionCycles, 0.0001);
        assertNull(result.category);
        assertNull(result.subCategory);
        assertNull(result.description);
        assertNull(result.unitClass);
        assertNull(result.error);
    }

    @Test
    public void testFieldAssignment() {
        UnitTimeResult result = new UnitTimeResult();

        result.milliSecondsPerUnit = 0.005;
        result.nsPerUnit = 5000.0;
        result.units = 2.5;
        result.instructionCycles = 16000.0;
        result.category = "Datum";
        result.subCategory = "Math";
        result.description = "Integer addition";
        result.unitClass = Integer.class;

        assertEquals(0.005, result.milliSecondsPerUnit, 0.0001);
        assertEquals(5000.0, result.nsPerUnit, 0.0001);
        assertEquals(2.5, result.units, 0.0001);
        assertEquals(16000.0, result.instructionCycles, 0.0001);
        assertEquals("Datum", result.category);
        assertEquals("Math", result.subCategory);
        assertEquals("Integer addition", result.description);
        assertEquals(Integer.class, result.unitClass);
    }

    @Test
    public void testErrorField() {
        UnitTimeResult result = new UnitTimeResult();

        assertNull(result.error);

        Exception ex = new RuntimeException("benchmark failed");
        result.error = ex;

        assertNotNull(result.error);
        assertEquals("benchmark failed", result.error.getMessage());
    }

    @Test
    public void testToStringContainsFields() {
        UnitTimeResult result = new UnitTimeResult();
        result.milliSecondsPerUnit = 0.01;
        result.nsPerUnit = 10000.0;
        result.units = 5.0;
        result.instructionCycles = 32000.0;
        result.category = "Datum";
        result.subCategory = "array";
        result.unitClass = String.class;

        String str = result.toString();
        assertNotNull(str);
        assertTrue(str.contains("Datum"));
        assertTrue(str.contains("array"));
    }

    @Test
    public void testMultipleResults() {
        UnitTimeResult r1 = new UnitTimeResult();
        r1.milliSecondsPerUnit = 0.001;
        r1.category = "Datum";

        UnitTimeResult r2 = new UnitTimeResult();
        r2.milliSecondsPerUnit = 0.010;
        r2.category = "Datum";

        assertNotSame(r1, r2);
        assertTrue(r2.milliSecondsPerUnit > r1.milliSecondsPerUnit);
    }
}
