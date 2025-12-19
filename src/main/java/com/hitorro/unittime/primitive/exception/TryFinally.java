package com.hitorro.unittime.primitive.exception;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 23, 2006 Time: 12:10:24 AM
 */
public class TryFinally extends ExceptionTimers {

    static int x0, x1, x2, x3, x4, x5, x6, x7, x8, x9;
    static int y0, y1, y2, y3, y4, y5, y6, y7, y8, y9;

    public TryFinally() {
        super("try {...} finally {...}");

    }

    public void init() {
        setIterations(10);
    }

    public void test() throws Exception {
        try {
            x0 = 1;
        } finally {
            y0 = 2;
        }
        try {
            x1 = 1;
        } finally {
            y1 = 2;
        }
        try {
            x2 = 1;
        } finally {
            y2 = 2;
        }
        try {
            x3 = 1;
        } finally {
            y3 = 2;
        }
        try {
            x4 = 1;
        } finally {
            y4 = 2;
        }
        try {
            x5 = 1;
        } finally {
            y5 = 2;
        }
        try {
            x6 = 1;
        } finally {
            y6 = 2;
        }
        try {
            x7 = 1;
        } finally {
            y7 = 2;
        }
        try {
            x8 = 1;
        } finally {
            y8 = 2;
        }
        try {
            x9 = 1;
        } finally {
            y9 = 2;
        }
    }
}


