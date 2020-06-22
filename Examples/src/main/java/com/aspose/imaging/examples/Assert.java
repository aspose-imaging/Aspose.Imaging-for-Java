/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples;

/**
 *
 * @author mfazi
 */
public final class Assert {
    public static void areEqual(Object left, Object right) {
        if (!left.equals(right))
            throw new AssertionError(left + " != " + right);
    }

    public static void areEqual(Object left, Object right, String msg) {
        if (!left.equals(right))
            throw new AssertionError(msg);
    }

    public static void areEqual(long left, long right, String msg) {
        if (left != right)
            throw new AssertionError(left + " != " + right);
    }

    public static void areEqual(float left, float right, float epsilon) {
        assert Math.abs(left - right) < epsilon;
    }

    public static void areNotEqual(Object left, Object right) {
        assert !left.equals(right);
    }
    
    public static void assertTrue(boolean value) {
        if (!value)
            throw new AssertionError("value is false");

    }

    public static void assertTrue(boolean value, String msg) {
        assert value : msg;
    }
}
