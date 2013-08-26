package com.gmail.mstojcevich.iridium.mods;

/**
 * @author marcusant
 * @version 1
 * @since 8/24/13 3:46 PM
 */
public enum ModCategory {

    PLAYER(0xFFCEFF52 /*Lime green*/), WORLD(0xFF00DB4D /*Green*/),
    DISPLAY(0xFF09B4ED /*Light blue*/), OPTIONS(0xFFB5B5B5 /*Gray*/),
    COMBAT(0xFFEB0000 /*Red*/), OTHER(0xFFB800EB /*Purple*/);

    /**
     * Hex color of the category
     */
    public final int color;

    /**
     * @param color Color code in hex
     */
    private ModCategory(int color) {
        this.color = color;
    }

}
