package com.gmail.mstojcevich.lib.module;

/**
 * @author marcusant
 * @version 1
 * @since 8/23/13 6:32 PM
 */
public interface Titled {

    /**
     * Sets the title of a titled object
     * @param title Desired title
     */
    public void setTitle(String title);

    /**
     * @return The title of the titled object.
     */
    public String getTitle();

}
