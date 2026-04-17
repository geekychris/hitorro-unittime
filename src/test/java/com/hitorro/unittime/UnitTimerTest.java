package com.hitorro.unittime;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for UnitTimer abstract base class.
 * Uses a concrete subclass for testing.
 */
public class UnitTimerTest {

    private UnitTimer timer;
    private int testCallCount;

    @Before
    public void setUp() {
        testCallCount = 0;
        timer = new UnitTimer("Test Timer") {
            @Override
            public void test() {
                testCallCount++;
            }
        };
    }

    @Test
    public void testConstructor() {
        assertNotNull(timer);
        assertEquals("Test Timer", timer.getDescription());
    }

    @Test
    public void testDescriptionSetAndGet() {
        timer.setDescription("New Description");
        assertEquals("New Description", timer.getDescription());
    }

    @Test
    public void testDefaultCategory() {
        assertEquals("BaseLineTest", timer.getCategory());
    }

    @Test
    public void testDefaultSubCategory() {
        assertEquals("BaseLineTest_Sub", timer.getSubCategory());
    }

    @Test
    public void testDefaultIterations() {
        assertEquals(1, timer.getIterations());
    }

    @Test
    public void testSetIterations() {
        timer.setIterations(100);
        assertEquals(100, timer.getIterations());
    }

    @Test
    public void testDefaultBaseMsecsPerTest() {
        assertEquals(0.0, timer.getBaseMsecsPerTest(), 0.0001);
    }

    @Test
    public void testSetBaseMsecsPerTest() {
        timer.setBaseMsecsPerTest(1.5);
        assertEquals(1.5, timer.getBaseMsecsPerTest(), 0.0001);
    }

    @Test
    public void testDefaultTotalMsecs() {
        assertEquals(0, timer.getTotalMsecs());
    }

    @Test
    public void testSetTotalMsecs() {
        timer.setTotalMsecs(5000);
        assertEquals(5000, timer.getTotalMsecs());
    }

    @Test
    public void testDefaultVisible() {
        assertTrue(timer.visible());
    }

    @Test
    public void testHiddenTimer() {
        UnitTimer hidden = new UnitTimer("Hidden") {
            @Override
            public void test() {}

            @Override
            public boolean visible() { return false; }
        };
        assertFalse(hidden.visible());
    }

    @Test
    public void testContextSetAndGet() {
        assertNull(timer.getContext());

        UnitTimeContext context = UnitTimeContext.getUnitTimeContext();
        timer.setContext(context);

        assertSame(context, timer.getContext());
    }

    @Test
    public void testTestMethodCanBeCalled() throws Exception {
        timer.test();
        assertEquals(1, testCallCount);

        timer.test();
        assertEquals(2, testCallCount);
    }

    @Test
    public void testInitIsNoOp() {
        // Should not throw
        timer.init();
    }

    @Test
    public void testPreTestIsNoOp() {
        // Should not throw
        timer.preTest();
    }

    @Test
    public void testPostTestIsNoOp() {
        // Should not throw
        timer.postTest();
    }

    @Test
    public void testLifecycleSequence() throws Exception {
        StringBuilder sequence = new StringBuilder();

        UnitTimer lifecycleTimer = new UnitTimer("Lifecycle") {
            @Override
            public void init() { sequence.append("init,"); }

            @Override
            public void preTest() { sequence.append("pre,"); }

            @Override
            public void test() { sequence.append("test,"); }

            @Override
            public void postTest() { sequence.append("post,"); }
        };

        lifecycleTimer.init();
        lifecycleTimer.preTest();
        lifecycleTimer.test();
        lifecycleTimer.postTest();

        assertEquals("init,pre,test,post,", sequence.toString());
    }

    @Test
    public void testCustomCategoryAndSubCategory() {
        UnitTimer custom = new UnitTimer("Custom") {
            @Override
            public String getCategory() { return "MyCategory"; }

            @Override
            public String getSubCategory() { return "MySub"; }

            @Override
            public void test() {}
        };

        assertEquals("MyCategory", custom.getCategory());
        assertEquals("MySub", custom.getSubCategory());
    }
}
