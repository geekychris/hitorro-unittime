package com.hitorro.unittime.primitive.invoke;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 11:50:32 PM
 */
public class MethodCall0ArgsReflective extends InvokeTimers {

    static MethodCall0ArgsReflective o;
    private Method method;

    public MethodCall0ArgsReflective() {
        super("(reflective) o.f()");
        setIterations(40);
        try {
            method = getMethod(this.getClass(), "f", null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the first method that matches the specified name and parameter types. The overriding methods have
     * priority. The method is chosen from all the methods of the specified class and all its superclasses and
     * superinterfaces.
     *
     * @return the matching method or null if no mathching method has been found.
     */
    static Method getMethod(Class target, String methodName, Class[] types) {

        if (types == null) {
            types = new Class[0];
        }

        Method[] methods = getAllMethods(target);
        methods:
        for (int i = 0; i < methods.length; i++) {
            Method m = methods[i];
            if (!methodName.equals(m.getName())) {
                continue;
            }
            Class[] parameters = m.getParameterTypes();
            if (types.length != parameters.length) {
                continue;
            }
            for (int j = 0; j < types.length; j++) {
                if (!types[j].equals(parameters[j])) {
                    continue methods;
                }
            }
            return m;
        }
        return null;
    }

    /**
     * The method walks up the class hierarchy and returns <i>all</i> methods of this class and those inherited from
     * superclasses and superinterfaces.
     */
    static Method[] getAllMethods(Class target) {

        Class superclass = target;
        ArrayList<Method> methods = new ArrayList<Method>();

        while (superclass != null) {
            Method[] m = superclass.getDeclaredMethods();
            methods.addAll(Arrays.asList(m));
            superclass = superclass.getSuperclass();
        }

        Method[] result = new Method[methods.size()];
        System.arraycopy(methods.toArray(), 0, result, 0, methods.size());
        return result;
    }

    void f() {
        //Do Nothing
    }

    public void preTest() {
        o = new MethodCall0ArgsReflective();
    }

    public void test() throws Exception {
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
        method.invoke(o);
    }
}
