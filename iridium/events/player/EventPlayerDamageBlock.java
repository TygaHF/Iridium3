/*
 * EventPlayerDamageBlock
 *
 * 8/25/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;

/**
 * Event fired when the player damages a block
 * @author marcusant
 * @version 1
 * @since 8/25/13 12:52 AM
 */
public class EventPlayerDamageBlock extends EventPlayer {

    private Block block;
    private float blockDamage;

    public EventPlayerDamageBlock(EntityPlayer player, Block block, float blockDamage) {
        super(player);
        this.block = block;
        this.blockDamage = blockDamage;
    }

    /**
     * @return Block that was damaged
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * @return Current block damage on damaged block
     */
    public Float getBlockDamage() {
        return this.blockDamage;
    }

}
