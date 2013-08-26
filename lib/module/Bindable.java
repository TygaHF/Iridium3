package com.gmail.mstojcevich.lib.module;

/**
 * @author marcusant
 * @version 1
 * @since 8/23/13 11:30 PM
 */
public interface Bindable {

    /**
     * Gets the keycode of the bindable object. If no keybind is
     * set, returns -1 or 0.
     * @return keycode of the bind
     */
    public int getKeybind();

    /**
     * Sets the keybind for the bindable object. If no keybind is desired,
     * set 0 or -1.
     * @param keybind desired keycode
     */
    public void setKeybind(int keybind);

}
