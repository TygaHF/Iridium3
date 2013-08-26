/*
 * EnabledModuleList
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods.modules;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.render.EventRenderInGame;
import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.iridium.mods.ModCategory;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import com.gmail.mstojcevich.mclib.MinecraftWrapper;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ScaledResolution;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 5:30 PM
 */
public class EnabledModuleList extends IridiumModule implements EventListener {

    private final FontRenderer fontRenderer = MinecraftWrapper.getFontRenderer();

    /**
     * Creates the enabled module list module
     */
    public EnabledModuleList() {
        super(ModCategory.DISPLAY);
        Iridium.instance.eventHandler.registerListener(this);
    }

    @HandleEvent
    public void renderInGame(EventRenderInGame event) {
        final ScaledResolution scaledRes = new ScaledResolution(MinecraftWrapper.getGameSettings(),
                MinecraftWrapper.getMinecraft().displayWidth,
                MinecraftWrapper.getMinecraft().displayHeight);
        final int width = scaledRes.getScaledWidth();
        final int padding = 2; //padding between list and screen edge
        final int spacing = 1; //vertical spacing between module names

        int yPosition = padding;
        for (IridiumModule module : Iridium.instance.moduleManager.enabledMods) {
            if (!module.getDisplayInEnabledList()) {
                continue;
            }
            final int moduleNameWidth = this.fontRenderer.getStringWidth(module.getTitle());
            final int xPosition = width - padding - moduleNameWidth;
            this.fontRenderer.drawStringWithShadow(module.getTitle(), xPosition, yPosition,
                    module.getCategory().color);
            yPosition += this.fontRenderer.FONT_HEIGHT + spacing;
        }
    }

    @HandleEvent
    public void startupMinecraft() {
        this.setToggled(true);
        this.setToggleable(false);
        this.setDisplayInEnabledList(false);
    }

}
