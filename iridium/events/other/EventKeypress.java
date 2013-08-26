/*
 * EventKeypress
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.other;

import com.gmail.mstojcevich.lib.event.Event;

/**
 * Event fired on keypress
 * @author marcusant
 * @version 1
 * @since 8/24/13 6:15 PM
 */
public class EventKeypress extends Event {

    /**
     * Key code that was pressed
     */
    private final int keyCode;

    /**
     * Creates a new keypress event
     * @param keyCode key code that was pressed
     */
    public EventKeypress(int keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * @return key code that was pressed
     */
    public int getKeyCode() {
        return this.keyCode;
    }



}
