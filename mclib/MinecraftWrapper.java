/*
 * MinecraftWrapper
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.mclib;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GameSettings;
import net.minecraft.src.Minecraft;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 5:33 PM
 */
public class MinecraftWrapper {

    public static Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public static GameSettings getGameSettings() {
        return getMinecraft().gameSettings;
    }

    public static FontRenderer getFontRenderer() {
        return getMinecraft().fontRenderer;
    }

    public static EntityPlayer getPlayer() {
        return getMinecraft().thePlayer;
    }

}
