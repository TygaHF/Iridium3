/*
 * IridiumModule
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.lib.module.Bindable;
import com.gmail.mstojcevich.lib.module.Module;

/**
 * Abstract module class used for Iridium mods.
 * @author marcusant
 * @version 1
 * @since 8/23/13 11:29 PM
 */
public abstract class IridiumModule extends Module implements Bindable {

    /**
     * Keycode to toggle the mod
     */
    private int keybind;
    /**
     * Current toggle state for the mod
     */
    private boolean toggle;
    /**
     * The title of the mod
     */
    private String title;

    /**
     * The category of the mod
     */
    private ModCategory category = ModCategory.OTHER;
    /**
     * Whether or not a module is toggleable
     */
    private boolean isToggleable = true;
    private boolean displayInEnabledList = true;

    //Disabled constructors
    private IridiumModule() {
        super();
    }
    private IridiumModule(String name) {
        super();
    }

    //Protected constructors

    /**
     * Creates an Iridium module with the specified name and category
     * @param name
     * @param category
     */
    protected IridiumModule(String name, ModCategory category) {
        super(name);
        this.category = category;
    }

    /**
     * Creates an Iridium module with the specified category
     * @param category
     */
    protected IridiumModule(ModCategory category) {
        super();
        this.category = category;
    }

    @Override
    public void setKeybind(int keycode) {
        this.keybind = keycode;
    }

    @Override
    public int getKeybind() {
        return this.keybind;
    }

    /**
     * Switches the toggle state of the mod
     */
    public void toggleMod() {
        this.setToggled(!this.getToggled());
    }

    @Override
    public void setToggled(boolean toggle) {
        if(this.getToggleable()) {
            super.setToggled(toggle);
            if (this.getToggled()) {
                this.onEnable();
            } else {
                this.onDisable();
            }
        }
    }

    /**
     * Runs on the enable of the mod
     */
    private void onEnable() {
        Iridium.instance.moduleManager.enabledMods.add(this);
    }

    /**
     * Runs on the disable of the mod
     */
    private void onDisable() {
        Iridium.instance.moduleManager.enabledMods.remove(this);
    }

    /**
     * Gets whether or not the mod can be toggled
     * @return whether or not the mod can be toggled
     */
    public boolean getToggleable() {
        return this.isToggleable;
    }

    /**
     * Sets whether or not the mod can be toggled
     * @param toggleable whether or not the mod can be toggled
     */
    public void setToggleable(boolean toggleable) {
        this.isToggleable = toggleable;
    }

    /**
     * Gets whether or not the mod should be displayed on the enabled mod list
     * @return Whether or not the mod should be displayed
     */
    public boolean getDisplayInEnabledList() {
        return this.displayInEnabledList;
    }

    /**
     * Sets whether or not the mod should be displayed on the enabled mod list
     * @param display Whether or not the mod should be displayed
     */
    public void setDisplayInEnabledList(boolean display) {
        this.displayInEnabledList = display;
    }

    /**
     * @return the ModCategory of the mod
     */
    public ModCategory getCategory() {
        return this.category;
    }

}
