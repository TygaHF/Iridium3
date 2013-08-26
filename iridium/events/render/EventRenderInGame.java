/*
 * EventRenderInGame
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.render;

import net.minecraft.src.GuiIngame;

/**
 * Event fired when rendering the ingame GUI
 * @author marcusant
 * @version 1
 * @since 8/24/13 5:25 PM
 */
public class EventRenderInGame extends EventRender {

    private final GuiIngame ingameGUI;

    /**
     * Creates a new EventRenderInGame
     * @param ingameGUI source ingame GUI
     */
    public EventRenderInGame(GuiIngame ingameGUI) {
        this.ingameGUI = ingameGUI;
    }

    /**
     * Returns the source ingame GUI
     * @return ingame GUI
     */
    public GuiIngame getIngameGUI() {
        return this.ingameGUI;
    }

}
