package com.hitorro.unittime.primitive.cast;

/**
 */
public class CastStringFromObject extends CastTimers {

    private Object o0;
    private Object o1;
    private Object o2;
    private Object o3;
    private Object o4;
    private Object o5;
    private Object o6;
    private Object o7;
    private Object o8;
    private Object o9;

    private String s0;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;
    private String s6;
    private String s7;
    private String s8;
    private String s9;

    public CastStringFromObject() {
        super("s = (String) object");
        setIterations(10);
        o0 = o1 = o2 = o3 = o4 = o5 = o6 = o7 = o8 = o9 = "310687";
    }


    public void test() throws Exception {
        s0 = (String) o0;
        s1 = (String) o1;
        s2 = (String) o2;
        s3 = (String) o3;
        s4 = (String) o4;
        s5 = (String) o5;
        s6 = (String) o6;
        s7 = (String) o7;
        s8 = (String) o8;
        s9 = (String) o9;
    }
}
