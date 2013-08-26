/*
 * NumberHelper
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.math;

import java.util.Random;

/**
 * Provides helpful number-related functions
 * @author marcusant
 * @version 1
 * @since 8/23/13 2:37 PM
 */
public final class NumberHelper {

    /**
     * Instance of random used in NumberHelper
     */
    public static final Random random = new Random();

    /**
     * Gets a random number between 0 and a specified cap
     * @returns A random number between 0 and the cap
     * @param cap at which the number will be limited to
     */
    public static int getRandom(int cap){
        return random.nextInt(cap);
    }

    /**
     * Gets a random number between a specified floor and cap
     * @param floor
     * @param cap
     * @return
     */
    public static int getRandom(int floor, int cap){
        return floor +  random.nextInt(cap - floor + 1);
    }

    /**
     * Clamps a value between a range. If a number is less than the range,
     * the minimum is given, if it is over the range then the max is given,
     * otherwise the number is returned.
     * @param value number to be clamped
     * @param floor minimum value
     * @param cap maximum value
     * @return
     */
    public static float clampValue(float value, float floor, float cap){
        if(value < floor)return floor;
        if(value > cap)return cap;
        return value;
    }

}
