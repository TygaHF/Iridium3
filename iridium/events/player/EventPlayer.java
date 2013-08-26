/*
 * PlayerEvent
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import com.gmail.mstojcevich.lib.event.Event;
import net.minecraft.src.EntityPlayer;

/**
 * A player-related event
 * @author marcusant
 * @version 1
 * @since 8/24/13 4:04 PM
 */
public abstract class EventPlayer extends Event {

    private EntityPlayer player;

    public EventPlayer(EntityPlayer player) {
        this.player = player;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

}
