/*
 * Module
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.module;

/**
 * @author marcusant
 * @version 1
 * @since 8/23/13 6:19 PM
 */
public abstract class Module implements Toggleable, Titled {

    /**
     * Enabled state of the module
     */
    private boolean toggle;
    /**
     * Title of the module
     */
    private String title;

    /**
     * Creates a module with the specified title
     * @param title Module title
     */
    public Module(String title) {
        this.setTitle(title);
    }

    /**
     * Creates a module using the class name as the title
     */
    public Module() {
        this.setTitle(this.getClass().getSimpleName());
    }

    @Override
    /**
     * Sets the toggle state of a module
     * @param toggle target toggle state
     */
    public boolean getToggled() {
        return this.toggle;
    }

   @Override
   /**
    * @return The current toggle state of a module
    */
    public void setToggled(boolean toggle) {
       this.toggle = toggle;
    }

    @Override
    /**
     * Sets the title of the module
     * @param title Target title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    /**
     * @returns The title of the module
     */
    public String getTitle() {
        return this.title;
    }


}
