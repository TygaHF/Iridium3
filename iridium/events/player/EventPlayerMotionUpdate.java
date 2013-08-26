/*
 * EventPlayerPreMotionUpdate
 *
 * 8/25/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import com.gmail.mstojcevich.lib.event.Cancellable;
import net.minecraft.src.EntityPlayer;

/**
 * Event fired before motion updates are calculated and sent to the server
 * @author marcusant
 * @version 1
 * @since 8/25/13 12:12 AM
 */
public class EventPlayerMotionUpdate extends EventPlayer implements Cancellable {
    private boolean cancelled;

    public EventPlayerMotionUpdate(EntityPlayer player) {
        super(player);
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
