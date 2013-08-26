/*
 * Flight
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods.modules;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.player.EventPlayerUpdate;
import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.iridium.mods.ModCategory;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import com.gmail.mstojcevich.mclib.MinecraftWrapper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GameSettings;
import org.lwjgl.input.Keyboard;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 6:31 PM
 */
public class Flight extends IridiumModule implements EventListener {

    public Flight() {
        super(ModCategory.PLAYER);
        Iridium.instance.eventHandler.registerListener(this);
        this.setKeybind(Keyboard.KEY_V);
    }

    @HandleEvent
    public void updatePlayer (EventPlayerUpdate event) {
        if(!this.getToggled())return;

        EntityPlayer player = event.getPlayer();

        player.landMovementFactor = 0.5f;
        player.jumpMovementFactor = 0.5f;

        player.capabilities.isFlying = false;
        player.setSneaking(false);

        MinecraftWrapper.getPlayer().motionX = 0;
        MinecraftWrapper.getPlayer().motionY = 0;
        MinecraftWrapper.getPlayer().motionZ = 0;

        if (MinecraftWrapper.getMinecraft().currentScreen == null) {
            if (GameSettings.isKeyDown(MinecraftWrapper
                    .getGameSettings().keyBindJump)) {
                MinecraftWrapper.getPlayer().motionY = 1;
            }
            if (GameSettings.isKeyDown(MinecraftWrapper
                    .getGameSettings().keyBindSneak)) {
                MinecraftWrapper.getPlayer().motionY = -1;
            }
        }

        MinecraftWrapper.getPlayer().jumpMovementFactor *= 3;
    }

}
