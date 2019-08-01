/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples;

import java.lang.Math;

/**
 *
 * @author mfazi
 */
public class Assert {
    public static void areEqual(Object left, Object right) {
        assert left.equals(right);
    }

    public static void areEqual(float left, float right, float epsilon) {
        assert Math.abs(left - right) < epsilon;
    }

    public static void areNotEqual(Object left, Object right) {
        assert !left.equals(right);
    }
    
    public static void assertTrue(boolean value) {
        assert value;
    }
}
