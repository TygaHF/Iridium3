/*
 * EventChat
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.chat;

import com.gmail.mstojcevich.lib.event.Event;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 9:29 PM
 */
public abstract class EventChat extends Event {

    public String message;

    public EventChat(String message) {
        this.message = message;
    }

}
