/*
 * EventChatSend
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.chat;

import com.gmail.mstojcevich.lib.event.Cancellable;

/**
 * Event fired when a chat message is sent
 * @author marcusant
 * @version 1
 * @since 8/24/13 9:31 PM
 */
public class EventChatSend extends EventChat implements Cancellable {

    private boolean cancelled;

    public EventChatSend(String message) {
        super(message);
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean getCancelled() {
        return this.cancelled;
    }

}
