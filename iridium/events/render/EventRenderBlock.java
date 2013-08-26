/*
 * EventRenderBlock
 *
 * 8/25/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.render;

import net.minecraft.src.Block;

/**
 * Event fired whenever a block is rendered
 * @author marcusant
 * @version 1
 * @since 8/25/13 1:05 AM
 */
public class EventRenderBlock extends EventRender {

    private Block block;

    public EventRenderBlock(Block block) {
        this.block = block;
    }

    /**
     * @return the block that was rendered
     */
    public Block getBlock() {
        return this.block;
    }

}
