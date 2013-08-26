/*
 * IridiumCommandManager
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.command;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.chat.EventChatSend;
import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import com.gmail.mstojcevich.lib.file.FileHelper;
import com.gmail.mstojcevich.lib.module.Module;
import com.gmail.mstojcevich.lib.reflection.ReflectionHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages Iridium commands
 * @author marcusant
 * @version 1
 * @since 8/24/13 9:59 PM
 */
public class IridiumCommandManager implements EventListener {

    private final String COMMAND_CHAT_PREFIX = ".";

    protected List<IridiumCommand> commandList = new ArrayList<IridiumCommand>();

    public IridiumCommandManager() {
        Iridium.instance.eventHandler.registerListener(this);
        this.loadCommandsFromPackage(
                "com.gmail.mstojcevich.iridium.command.commands");
        this.loadCommandsFromPackage(
                "com.gmail.mstojcevich.iridium.mods.modules");
        this.addCommandsJars(new File(
                "." + File.separator + "iridiumExtMods"));

    }

    @HandleEvent
    public void sendChatMessage (EventChatSend event) {
        if (event.message.startsWith(this.COMMAND_CHAT_PREFIX)) {
            event.setCancelled(true);
            if (event.message.trim().length() > 1) {
                this.handleCommand(event.message.trim().
                        substring(this.COMMAND_CHAT_PREFIX.length()));
            }
        }
    }

    /**
     * Adds Iridium commands from jars in a given directory
     * @param jarDirectory Directory that contains jar files
     */
    private void addCommandsJars(File jarDirectory) {
        if(!jarDirectory.exists())jarDirectory.mkdir();

        File[] jars = FileHelper.getFilesOfTypeInDirectory(jarDirectory, "jar");
        for (File jarFile : jars) {
            this.addCommandsJars(jarFile);
        }
    }

    /**
     * Processes a command by sending it off to all registered Commands
     * @param command
     */
    public void handleCommand(String command) {
        for (IridiumCommand cmd : this.commandList) {
            if (command.toLowerCase().startsWith(cmd.getCommand()
                    .toLowerCase())) {
                String[] arguments = command.split("-");
                cmd.runCommand(command, arguments);
            }
        }
    }

    /**
     * Loads classes and creates command objects from an external jar
     * @param jarFile The target jar file to create modules from
     */
    public void loadCommandsFromJar(File jarFile) {
        Class[] jarClassList = ReflectionHelper
                .getClassesFromExternalJar(jarFile);

        if (jarClassList != null) {
            for(Class indexClass : jarClassList) {
                try {
                    IridiumCommand command = (IridiumCommand)indexClass.newInstance();
                    this.commandList.add(command);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassCastException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    /**
     * Loads classes and creates command objects from a package
     * @param packageLocation The target package to create modules from
     */
    public void loadCommandsFromPackage(String packageLocation) {
        Class[] classList = ReflectionHelper
                .getClassesInPackage(packageLocation);

        if (classList != null) {
            for(Class indexClass : classList) {
                try {
                    IridiumCommand command = (IridiumCommand)indexClass.newInstance();
                    this.commandList.add(command);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassCastException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

}
