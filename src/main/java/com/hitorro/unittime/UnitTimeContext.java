package com.hitorro.unittime;


import com.hitorro.util.core.Log;
import com.hitorro.util.core.classes.ClassPathDeepIterator;
import com.hitorro.util.core.classes.ClassUtil;
import com.hitorro.util.core.string.StringUtil;
import com.hitorro.unittime.primitive.BaseLineUnitTimer;

import java.util.*;
import java.util.stream.Collectors;

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
    public static double systemClockPrecisionInMsecs = 0.0;

    /* The requested maximum relative error. */
    public static double error = 0.01;

    /* The minimum duration of tests needed to achieve the maximum
    relative "error". */
    public static double minExecutionTimeMsecs = 0.0;

    /* The overhead of doing one iteration of a test. */
    public static double invokationOverheadMSecs = 0.0;

    /* The cost of doing a local assignment, used as the machine-independent
    "unit". */
    public static double baseLineUnitCostMSecs = 0.0;

    /* CPU clock speed in GHz for instruction cycle calculation */
    private double cpuGigahertz = 0.0;

    /* Package prefixes to scan for timer classes */
    private final List<String> packagePrefixes = new ArrayList<>(List.of("com.hitorro.unittime."));

    private static UnitTimeContext utc = new UnitTimeContext();
    private boolean isInitialized = false;

    public static UnitTimeContext getUnitTimeContext() {
        return utc;
    }

    /**
     * Add a package prefix to scan for timer classes.
     */
    public void addPackagePrefix(String prefix) {
        packagePrefixes.add(prefix);
    }

    /**
     * Run all benchmarks and return results.
     *
     * @param cpuGigahertz CPU clock speed in GHz for instruction cycle calculation
     * @return list of benchmark results
     */
    public List<UnitTimeResult> runAll(double cpuGigahertz) {
        return runTests(null, cpuGigahertz);
    }

    /**
     * Run benchmarks filtered by name and return results.
     *
     * @param filter name filter (matched against class name or category, case-insensitive)
     * @param cpuGigahertz CPU clock speed in GHz for instruction cycle calculation
     * @return list of benchmark results
     */
    public List<UnitTimeResult> runFiltered(String filter, double cpuGigahertz) {
        return runTests(filter, cpuGigahertz);
    }

    /**
     * Get list of available benchmark categories.
     */
    public List<String> getCategories() {
        Map<String, String> empty = new HashMap<>();
        List<UnitTimer> timers = getTests(empty);
        return timers.stream()
                .filter(UnitTimer::visible)
                .map(UnitTimer::getCategory)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Get count of available timers.
     */
    public int getTimerCount() {
        Map<String, String> empty = new HashMap<>();
        return (int) getTests(empty).stream().filter(UnitTimer::visible).count();
    }

    /**
     * During initialization we compute:
     * 1) Resolution of the system clock
     * 2) Baseline cost of making a call to a test function
     * 3) Baseline unit cost (local assignment ≈ 1 CPU instruction)
     */
    public void init(double error) {
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
        systemClockPrecisionInMsecs = (double) totalDelta / loopCount;
        minExecutionTimeMsecs = (1.0 / error) * systemClockPrecisionInMsecs;

        // compute the cost of calling a method
        invokationOverheadMSecs = executeTest(new BaseLineUnitTimer()).milliSecondsPerUnit;

        // compute the cost of doing a local assignment considered one unit
        baseLineUnitCostMSecs = executeTest(new com.hitorro.unittime.primitive.math.LocalAssignment()).milliSecondsPerUnit;
        if (baseLineUnitCostMSecs < 0) {
            Log.util.error("baseline unit cost is smaller than 0");
            baseLineUnitCostMSecs = executeTest(new com.hitorro.unittime.primitive.math.LocalAssignment()).milliSecondsPerUnit;
        }
    }

    /**
     * Run all the tests that meet our criteria.
     */
    public List<UnitTimeResult> runTests(String singleTest, double cpuGigahertz) {
        this.cpuGigahertz = cpuGigahertz;
        List<UnitTimeResult> results = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        List<UnitTimer> timers = getTests(map);
        Collections.sort(timers, new TimersSorter());
        init(0.005);
        if (StringUtil.nullOrEmptyOrBlankString(singleTest)) {
            for (UnitTimer timer : timers) {
                if (timer.visible()) {
                    timer.setContext(this);
                    UnitTimeResult utr = executeTest(timer);
                    results.add(utr);
                }
            }
        } else {
            String filter = singleTest.toLowerCase();
            for (UnitTimer timer : timers) {
                String name = timer.getClass().getCanonicalName().toLowerCase();
                String cat = timer.getCategory().toLowerCase();
                if (name.contains(filter) || cat.contains(filter)) {
                    timer.setContext(this);
                    UnitTimeResult utr = executeTest(timer);
                    results.add(utr);
                }
            }
        }
        return results;
    }

    /**
     * Find tests in the classpath.
     */
    public List<UnitTimer> getTests(Map<String, String> categoryConstraint) {
        List<UnitTimer> testCases = new ArrayList<>();
        ClassPathDeepIterator iter = new ClassPathDeepIterator();
        while (iter.hasNext()) {
            String orig = iter.next();
            String c = ClassUtil.translateClassFilenameToCanonical(orig);
            if (!StringUtil.nullOrEmptyOrBlankString(c)) {
                boolean inScope = false;
                for (String prefix : packagePrefixes) {
                    if (c.startsWith(prefix)) {
                        inScope = true;
                        break;
                    }
                }
                if (!inScope) {
                    continue;
                }
                try {
                    Class cl = Class.forName(c);
                    if (!ClassUtil.isAbstract(cl) && ClassUtil.isSubClass(cl, UnitTimer.class)) {
                        try {
                            UnitTimer test = (UnitTimer) cl.getDeclaredConstructor().newInstance();
                            if (categoryConstraint.size() == 0) {
                                testCases.add(test);
                            } else {
                                String cat = test.getCategory().toLowerCase();
                                if (categoryConstraint.get(cat) != null) {
                                    testCases.add(test);
                                }
                            }
                            Log.test.debug("Added %s test to the list of tests", c);
                        } catch (Exception e) {
                            Log.util.error("Unable to create instance of test %s %s", c, e);
                        }
                    }
                } catch (ClassNotFoundException | NoClassDefFoundError | ExceptionInInitializerError e) {
                    // Skip classes that can't be loaded (missing deps, failed static init, etc.)
                }
            }
        }
        return testCases;
    }

    public final UnitTimeResult executeTest(UnitTimer unit) {
        if (!isInitialized) {
            init(0.005);
        }
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
                        break;
                    } else {
                        if (runTimeInMillis < 10 * systemClockPrecisionInMsecs) {
                            n = 2 * n;
                        } else {
                            n = (long) Math.max(1.1 * n,
                                    requiredExecTimeInMSecs / (runTimeInMillis - systemClockPrecisionInMsecs) * n);
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
            double individualCallTime = (runTimeInMillis / n) - invokationOverheadMSecs;
            if (individualCallTime < 0) {
                Log.util.error("Reseting call time to baseline since it is negative (could be defeated by jit)");
                individualCallTime = baseLineUnitCostMSecs;
            }
            double milliSecondsPerUnit = (individualCallTime / unit.getIterations()) - unit.getBaseMsecsPerTest();
            double units = milliSecondsPerUnit / baseLineUnitCostMSecs;

            result.milliSecondsPerUnit = milliSecondsPerUnit;
            result.nsPerUnit = milliSecondsPerUnit * 1000000;
            result.units = units;

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
                Log.unitTime.info("Units < 0 %s, n=%s, systemClockPrecisionInMsecs=%s", Double.toString(units), n, systemClockPrecisionInMsecs);
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
