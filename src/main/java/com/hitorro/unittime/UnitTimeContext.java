package com.hitorro.unittime;


import com.hitorro.util.commandandcontrol.Response;
import com.hitorro.util.commandandcontrol.ResponseShape;
import com.hitorro.util.core.Log;
import com.hitorro.util.core.classes.ClassPathDeepIterator;
import com.hitorro.util.core.classes.ClassUtil;
import com.hitorro.util.core.string.StringUtil;
import com.hitorro.util.testframework.TestServerService;
import com.hitorro.unittime.primitive.BaseLineUnitTimer;

import java.util.*;

/**
 * <p/>
 * Find all timer tests that meet a criteria and then measure the amount of time taken to execute.
 * <p/>
 * We compute a number of things: 1) resolution of system clock. 2) cost of making a method call 3) cost of doing a
 * simple piece of work such as assignment that is assumed to be about 1 instruction
 * <p/>
 * From this we can compute what other things cost in both ms and machine instructions.
 */

public class UnitTimeContext {
    /* The precision, in milliseconds, of System.currentTimeMillis (). */
    public static double m_systemClockPrecisionInMsecs = 0.0;

    /* The requested maximum relative error. */
    public static double error = 0.01;

    /* The minimum duration of tests needed to achieve the maximum
    relative "error". */
    public static double minExecutionTimeMsecs = 0.0;

    /* The overhead of doing one iteration of a test. */
    public static double m_invokationOverheadMSecs = 0.0;

    /* The cost of doing a local assignment, used as the machine-independent
    "unit". */
    public static double m_baseLineUnitCostMSecs = 0.0;
    
    /* CPU clock speed in GHz for instruction cycle calculation */
    private double cpuGigahertz = 0.0;
    
    private static UnitTimeContext utc = new UnitTimeContext();
    private boolean isInitialized = false;

    public static UnitTimeContext getUnitTimeContext() {
        return utc;
    }

    /**
     * During initialization we need to compute a few things:
     * <p/>
     * 1) Resolution of the system clock, this determines how much error there is in measuring runtime of a test. 2)
     * Baseline cost of making a call to a test function (so it can be subtracted out of tests). 3) Baseline unit cost.
     * Take an instruction that we know to be 1 cycle typically on a processor and use that as our "Unit".  All other
     * tests are compared in terms of a baseline unit which should approximate a machine cycle.
     *
     * @param response
     * @param error
     */
    public void init(Response response, double error) {
        if (isInitialized) {
            return;
        }
        isInitialized = true;
        UnitTimeContext.error = error;

        // compute clock precision
        long totalDelta = 0;
        int loopCount = 100;
        for (int i = 0; i < loopCount; i++) {
            long t1 = System.currentTimeMillis();
            long t2 = t1;
            while (t1 >= t2) {
                t2 = System.currentTimeMillis();
            }
            totalDelta += t2 - t1;
        }
        // we took loopCount samples, so we are going to take the median
        m_systemClockPrecisionInMsecs = (double) totalDelta / loopCount;

        minExecutionTimeMsecs = (1.0 / error) * m_systemClockPrecisionInMsecs;
        if (response != null && response.getShape() == null) {
            ResponseShape shape = new ResponseShape("UnitTime", "row");
            shape.addHeader("execution time", "instructions", "category", "subcategory", "description", "class");
            shape.addHeaderShortNames("execution time", "instructions", "category", "subcategory", "description", "class");
            shape.addRowTypes(Double.class, Double.class, String.class, String.class, String.class, String.class);
            response.setResponseShape(shape);
        }
        // compute the cost of calling a method
        // ensure jitted
        //executeTest(null, new BaseLineUnitTimer());
        //executeTest(null, new BaseLineUnitTimer());

        m_invokationOverheadMSecs = executeTest(new BaseLineUnitTimer()).milliSecondsPerUnit;
        // compute the cost of doing a local assignment considered one unit

        m_baseLineUnitCostMSecs = executeTest(new com.hitorro.unittime.primitive.math.LocalAssignment()).milliSecondsPerUnit;
        if (m_baseLineUnitCostMSecs < 0) {
            Log.util.error("baseline unit cost is smaller than 0");
            m_baseLineUnitCostMSecs = executeTest(new com.hitorro.unittime.primitive.math.LocalAssignment()).milliSecondsPerUnit;
        }

    }


    /**
     * Run all the tests that test our criteria.  We find the tests from scanning the classpath.
     *
     * @param response
     * @param singleTest
     * @param cpuGigahertz CPU clock speed in GHz for instruction cycle calculation
     */
    public List<UnitTimeResult> runTests(Response response, String singleTest, double cpuGigahertz) {
        this.cpuGigahertz = cpuGigahertz;
        List<UnitTimeResult> results = new ArrayList();
        HashMap<String, String> map = new HashMap<String, String>();
        List<UnitTimer> timers = getTests(map);
        Collections.sort(timers, new TimersSorter());
        init(response, 0.005);
        if (StringUtil.nullOrEmptyOrBlankString(singleTest)) {
            for (UnitTimer timer : timers) {
                if (timer.visible()) {
                    timer.setContext(this);
                    UnitTimeResult utr = executeTest(timer);
                    results.add(utr);
                    if (response != null) {
                        utr.addToRow(response);
                    }
                }
            }
        } else {
            singleTest = singleTest.toLowerCase();
            for (UnitTimer timer : timers) {
                if (timer.getClass().getCanonicalName().toLowerCase().endsWith(singleTest)) {
                    timer.setContext(this);
                    UnitTimeResult utr = executeTest(timer);
                    results.add(utr);
                    if (response != null) {
                        utr.addToRow(response);
                    }
                }
            }
        }
        response.end();
        return results;
    }


    /**
     * Find tests in the classpath.
     *
     * @param categoryConstraint
     * @return
     */
    public List<UnitTimer> getTests(Map<String, String> categoryConstraint) {
        List<UnitTimer> testCases = new ArrayList<UnitTimer>();
        ClassPathDeepIterator iter = new ClassPathDeepIterator();
        while (iter.hasNext()) {

            String orig = iter.next();
            String c = ClassUtil.translateClassFilenameToCanonical(orig);
            if (!StringUtil.nullOrEmptyOrBlankString(c)) {
                if (!TestServerService.getInstance().isPathWithinTestPaths(c)) {
                    continue;
                }
                try {
                    Class cl = Class.forName(c);

                    if (!ClassUtil.isAbstract(cl) && ClassUtil.isSubClass(cl, UnitTimer.class)) {
                        try {
                            UnitTimer test = (UnitTimer) cl.newInstance();
                            if (categoryConstraint.size() == 0) {
                                testCases.add(test);
                            } else {
                                String cat = test.getCategory().toLowerCase();
                                if (categoryConstraint.get(cat) != null) {
                                    testCases.add(test);
                                }
                            }

                            Log.test.debug("Added %s test to the listFiles of tests to visible", c);
                        } catch (InstantiationException e) {
                            Log.util.error("Unable to create instance of test %s %s", c, e, e);
                        } catch (IllegalAccessException e) {
                            Log.util.error("Unable to create instance of test %s %s", c, e, e);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    Log.util.error("Unable to get class for %s %e", e, e);
                }
            }
        }
        return testCases;
    }

    public final UnitTimeResult executeTest(UnitTimer unit) {
        if (isInitialized == false) {
            init(null, 0.005);
        }
        // attempt to jit.
        UnitTimeResult result = new UnitTimeResult();

        try {
            unit.init();

            unit.preTest();
            try {
                unit.test();
            } finally {
                unit.postTest();
            }

            long n = 1;
            double runTimeInMillis = 0;
            double startTimeInMillis = 0;
            double requiredExecTimeInMSecs = minExecutionTimeMsecs;


            if (unit.getTotalMsecs() > 0) {
                requiredExecTimeInMSecs = unit.getTotalMsecs();
            }

            try {
                unit.preTest();
                while (true) {
                    System.gc();

                    startTimeInMillis = System.currentTimeMillis();
                    for (long i = 0; i < n; i++) {
                        unit.test();
                    }
                    runTimeInMillis = System.currentTimeMillis() - startTimeInMillis;


                    if (runTimeInMillis >= requiredExecTimeInMSecs) {
                        // we have hit our target time
                        break;
                    } else {
                        if (runTimeInMillis < 10 * m_systemClockPrecisionInMsecs) {
                            n = 2 * n;
                        } else {
                            n = (long) Math.max(1.1 * n,
                                    requiredExecTimeInMSecs / (runTimeInMillis - m_systemClockPrecisionInMsecs) * n);
                        }
                        if (n < 0) {

                            Log.util.error("Unit test loop overflow");
                            break;
                        }
                    }
                }
            } finally {
                unit.postTest();
            }
            // what does it cost to make 1 call
            double individualCallTime = (runTimeInMillis / n) - m_invokationOverheadMSecs;
            if (individualCallTime < 0) {
                // we are not that precise.  This call looks like it runs approx same as a invokation call
                // jit could of defeated us.  I dont like negative values so lets make it a baseline unit cost
                // we should perhaps consider running the tests again
                Log.util.error("Reseting call time to baseline since it is negative (could be defeated by jit)");
                individualCallTime = m_baseLineUnitCostMSecs;
            }
            // take account that 1 call my run whatever we are testing n times, then take account of the call cost
            double milliSecondsPerUnit = (individualCallTime / unit.getIterations()) - unit.getBaseMsecsPerTest();

            // we have an approx baseline for what a unit costs to execute (proxy for instruction cycle)
            double units = milliSecondsPerUnit / m_baseLineUnitCostMSecs;

            result.milliSecondsPerUnit = milliSecondsPerUnit;
			result.nsPerUnit = milliSecondsPerUnit * 1000000;
            result.units = units;
            
            // Calculate instruction cycles: nanoseconds × GHz = cycles
            // nsPerUnit is in nanoseconds, cpuGigahertz is in GHz
            // At N GHz, there are N cycles per nanosecond
            // Therefore: cycles = nanoseconds × GHz
            if (cpuGigahertz > 0) {
                result.instructionCycles = result.nsPerUnit * cpuGigahertz;
            } else {
                result.instructionCycles = 0.0;
            }
            
            result.category = unit.getCategory();
            result.subCategory = unit.getSubCategory();
            result.description = unit.getDescription();
            result.unitClass = unit.getClass();

            Log.unitTime.debug("%s, %s, %s, %s, %s, %s, %s",
                    Double.toString(milliSecondsPerUnit),
					Double.toString(result.nsPerUnit),
                    Double.toString(units),
                    unit.getCategory(),
                    unit.getSubCategory(),
                    unit.getDescription(),
                    ClassUtil.getBareName(unit.getClass()));
            if (units < 0) {
                Log.unitTime.info("Units < 0 %s, n=%s, m_systemClockPrecisionInMsecs=%s", Double.toString(units), n, m_systemClockPrecisionInMsecs);
            }


        } catch (Exception e) {
            result.error = e;
            result.milliSecondsPerUnit = 0.0;
        }
        return result;
    }
}


class TimersSorter implements Comparator<UnitTimer> {

    public int compare(UnitTimer o1, UnitTimer o2) {
        int cat = o1.getCategory().compareTo(o2.getCategory());
        if (cat == 0) {
            return o1.getSubCategory().compareTo(o2.getSubCategory());
        }

        return cat;
    }
}







