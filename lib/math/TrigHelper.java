/*
 * TrigHelper
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.math;

/**
 * Many functions to assist in trigonometry
 *
 * @version 1
 * @author Nathan Sweet
 * @since 8/23/13 1:57 PM
 */
//Credits to Nathan Sweet for a lot of this (I am terrible at trig)
public final class TrigHelper {

    /**
     * Pi to the first eight digits
     */
    public static final float PI = 3.14159265f;

    /**
     * Pi multiplied by two
     */
    public static final float PI2 = PI*2f;

    /**
     * Size in bits of the sine table
     */
    private static final int SINE_BITS = 14;
    /**
     * Mask of the sine bits
     */
    private static final int SINE_MASK = ~(-1 << SINE_BITS);
    /**
     * Size of the sine table
     */
    private static final int SINE_COUNT = SINE_MASK + 1;

    /**
     * One-time generated sine table
     */
    private static final float[] sineTable = new float[SINE_COUNT];


    static private final int ATAN2_BITS = 7;
    static private final int ATAN2_BITS2 = ATAN2_BITS << 1;
    static private final int ATAN2_MASK = ~(-1 << ATAN2_BITS2);
    static private final int ATAN2_COUNT = ATAN2_MASK + 1;
    static final int ATAN2_DIM = (int)Math.sqrt(ATAN2_COUNT);
    static private final float INV_ATAN2_DIM_MINUS_1 = 1.0f / (ATAN2_DIM - 1);

    /**
     * One-time generated atan2 table
     */
    private static final float[] atan2Table = new float[ATAN2_COUNT];

    static {
        setupSineTable();
        setupAtan2Table();
    }

    /**
     * Sets up the one-time-generated sine table
     */
    private static void setupSineTable(){
        for(int i = 0; i < SINE_COUNT; i ++) {
            sineTable[i] = (float)Math.sin((i + 0.5f) / SINE_COUNT * PI2);
        }
        for(int i = 0; i < 360; i+= 90) {
            sineTable[(i * (SINE_COUNT / 360)) & SINE_MASK] = (float)Math.sin(i * PI/180);
        }
    }

    /**
     * Sets up the one-time-generated atan2 table
     */
    private static void setupAtan2Table(){
        for (int i = 0; i < ATAN2_DIM; i++) {
            for (int j = 0; j < ATAN2_DIM; j++) {
                float x0 = (float)i / ATAN2_DIM;
                float y0 = (float)j / ATAN2_DIM;
                atan2Table[j * ATAN2_DIM + i] = (float)Math.atan2(y0, x0);
            }
        }
    }

    /**
     * @return the sine in radians.
     * @param radians
     */
    public static float sin(float radians) {
        return sineTable[(int)(radians * (SINE_COUNT / PI2)) & SINE_MASK];
    }

    /**
     * @return the cosine in radians.
     * @param radians
     */
    public static float cos(float radians) {
        return sineTable[(int)((radians + PI / 2) * (SINE_COUNT / PI2)) & SINE_MASK];
    }

    /**
     * @return the sine in radians.
     * @param degrees
     */
    public static float sinDeg(float degrees) {
        return sineTable[(int)(degrees * (SINE_COUNT / 360)) & SINE_MASK];
    }

    /**
     * @return the cosine in radians.
     * @param degrees
     */
    public static float cosDeg(float degrees) {
        return sineTable[(int)((degrees + 90) * (SINE_COUNT / 360)) & SINE_MASK];
    }

    /**
     * @param x
     * @param y
     * @return atan2 value from the atan2 table
     */
    public static float atan2 (float x, float y) {
        float add, mul;
        if (x < 0) {
            if (y < 0) {
                y = -y;
                mul = 1;
            } else
                mul = -1;
            x = -x;
            add = -PI;
        } else {
            if (y < 0) {
                y = -y;
                mul = -1;
            } else
                mul = 1;
            add = 0;
        }
        float invDiv = 1 / ((x < y ? y : x) * INV_ATAN2_DIM_MINUS_1);

        if (invDiv == Float.POSITIVE_INFINITY) return ((float)Math.atan2(y, x) + add) * mul;

        int xi = (int)(x * invDiv);
        int yi = (int)(y * invDiv);
        return (atan2Table[yi * ATAN2_DIM + xi] + add) * mul;
    }

}
