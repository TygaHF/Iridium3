/*
 * IridiumCommand
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.command;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 9:28 PM
 */
public interface IridiumCommand {

    /**
     * Runs when a command is passed with the IridiumCommand's command
     * @param fullCommand Entire command string
     * @param args Arguments separated by "-"
     */
    public void runCommand(String fullCommand, String[] args);

    /**
     * Returns the syntax of the command
     * @return the syntax of the command
     */
    public String getCommandSyntax();

    /**
     * @return a description of the command
     */
    public String getCommandDescription();

    /**
     * Gets the command for the IridiumCommand
     * @return the command for the IridumCommand
     */
    public String getCommand();

}
