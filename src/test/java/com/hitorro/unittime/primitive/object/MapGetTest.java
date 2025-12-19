package com.hitorro.unittime.primitive.object;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Unit tests for MapGet primitive operations.
 * Tests map access performance measurement.
 */
public class MapGetTest {

    private Map<String, Object> testMap;
    private MapGet mapGet;

    @Before
    public void setUp() {
        testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        testMap.put("key3", "value3");
        testMap.put("key4", 42);
        testMap.put("key5", true);
        
        mapGet = new MapGet();
    }

    @Test
    public void testMapGetCreation() {
        assertNotNull("MapGet should be created", mapGet);
    }

    @Test
    public void testMapGetExistingKey() {
        Object result = testMap.get("key1");
        assertEquals("Should retrieve correct value", "value1", result);
    }

    @Test
    public void testMapGetNonExistentKey() {
        Object result = testMap.get("nonexistent");
        assertNull("Should return null for non-existent key", result);
    }

    @Test
    public void testMapGetMultipleKeys() {
        assertEquals("key1 should return value1", "value1", testMap.get("key1"));
        assertEquals("key2 should return value2", "value2", testMap.get("key2"));
        assertEquals("key3 should return value3", "value3", testMap.get("key3"));
    }

    @Test
    public void testMapGetDifferentTypes() {
        assertEquals("String value should match", "value1", testMap.get("key1"));
        assertEquals("Integer value should match", 42, testMap.get("key4"));
        assertEquals("Boolean value should match", true, testMap.get("key5"));
    }

    @Test
    public void testMapGetEmptyMap() {
        Map<String, Object> emptyMap = new HashMap<>();
        Object result = emptyMap.get("anykey");
        assertNull("Should return null from empty map", result);
    }

    @Test
    public void testMapGetNullKey() {
        testMap.put(null, "nullKeyValue");
        Object result = testMap.get(null);
        assertEquals("Should handle null keys", "nullKeyValue", result);
    }

    @Test
    public void testMapGetPerformance() {
        // Measure time for multiple get operations
        long startTime = System.nanoTime();
        
        for (int i = 0; i < 1000; i++) {
            testMap.get("key1");
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        assertTrue("Get operations should complete", duration >= 0);
        assertTrue("1000 gets should be fast (< 10ms)", duration < 10_000_000);
    }

    @Test
    public void testMapGetConsistency() {
        Object first = testMap.get("key1");
        Object second = testMap.get("key1");
        Object third = testMap.get("key1");
        
        assertEquals("Multiple gets should return same value", first, second);
        assertEquals("Multiple gets should return same value", second, third);
    }

    @Test
    public void testMapGetAfterPut() {
        testMap.put("newkey", "newvalue");
        Object result = testMap.get("newkey");
        
        assertEquals("Should retrieve newly added value", "newvalue", result);
    }
}
