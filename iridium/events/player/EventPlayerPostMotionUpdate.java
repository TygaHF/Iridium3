/*
 * EventPlayerPostMotionUpdate
 *
 * 8/25/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import net.minecraft.src.EntityPlayer;

/**
 * Event fired after motion updates are sent to the server
 * @author marcusant
 * @version 1
 * @since 8/25/13 12:40 AM
 */
public class EventPlayerPostMotionUpdate extends EventPlayerUpdate {
    public EventPlayerPostMotionUpdate(EntityPlayer player) {
        super(player);
    }
}
