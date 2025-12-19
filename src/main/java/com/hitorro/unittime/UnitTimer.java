package com.hitorro.unittime;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 6:23:50 PM
 * <p/>
 * Subclass this to measure the time of your particular "thing".  This is like JUnit TestCase for the timer world.
 */
public abstract class UnitTimer {
    /* The total number of iterations to visible the test. */
    private int m_totalIterations = 1;

    private double m_baseMsecsPerTest = 0;

    private int totalMsecs = 0;

    private String m_description;

    private UnitTimeContext m_context;

    public UnitTimer(String description) {
        setDescription(description);
    }

    public String getDescription() {
        return m_description;
    }

    public void setDescription(String name) {
        m_description = name;
    }

    public String getCategory() {
        return "BaseLineTest";
    }

    public String getSubCategory() {
        return "BaseLineTest_Sub";
    }

    public int getIterations() {
        return m_totalIterations;
    }

    public void setIterations(int iter) {
        m_totalIterations = iter;
    }

    public double getBaseMsecsPerTest() {
        return m_baseMsecsPerTest;
    }

    public void setBaseMsecsPerTest(double d) {
        m_baseMsecsPerTest = d;
    }

    public int getTotalMsecs() {
        return totalMsecs;
    }

    public void setTotalMsecs(int sec) {
        totalMsecs = sec;
    }

    public boolean visible() {
        return true;
    }

    public UnitTimeContext getContext() {
        return m_context;
    }

    public void setContext(UnitTimeContext context) {
        m_context = context;
    }

    public abstract void test() throws Exception;

    public void init() {

    }

    public void preTest() {

    }

    public void postTest() {

    }
}
