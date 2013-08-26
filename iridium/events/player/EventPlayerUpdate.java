/*
 * EventPlayerUpdate
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import net.minecraft.src.EntityPlayer;

/**
 * Event for a player update (tick)
 * @author marcusant
 * @version 1
 * @since 8/24/13 4:06 PM
 */
public class EventPlayerUpdate extends EventPlayer {

    public EventPlayerUpdate(EntityPlayer player) {
        super(player);
    }

}
