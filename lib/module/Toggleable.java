/*
 * Toggleable
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.module;

/**
 * Something that holds a state of enabled or disabled.
 * @author marcusant
 * @version 1
 * @since 8/23/13 6:17 PM
 */
public interface Toggleable {

    /**
     * Sets the toggle state of a toggleable object
     * @param toggle target toggle state
     */
    public void setToggled(boolean toggle);

    /**
     * @return The current toggle state
     */
    public boolean getToggled();

}
