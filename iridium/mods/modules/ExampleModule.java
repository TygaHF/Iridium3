/*
 * ExampleModule
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods.modules;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.other.EventStartup;
import com.gmail.mstojcevich.iridium.events.player.EventPlayerUpdate;
import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.iridium.mods.ModCategory;
import com.gmail.mstojcevich.lib.event.EventHandler;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.EventPriority;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import net.minecraft.src.EntityPlayer;

/**
 * An example module class
 * @author marcusant
 * @version 1
 * @since 8/24/13 12:21 AM
 */
public class ExampleModule extends IridiumModule implements EventListener {

    public ExampleModule() {
        super(ModCategory.OTHER);
        System.out.println(Iridium.instance == null);
        Iridium.instance.eventHandler.registerListener(this);
    }

    @HandleEvent
    //Example player update event
    public void onPlayerUpdate(EventPlayerUpdate event) {
        //Here is where to put events to happen on EventPlayerUpdate
    }

    @HandleEvent(priority = EventPriority.LAST)
    /* Runs on startup in the last phase of events. Usually used to monitor
     * what has been done by other modules
     */
    public void onStartup(EventStartup event) {
        System.out.println("Startup event example");
    }


}
