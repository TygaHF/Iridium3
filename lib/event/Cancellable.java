package com.gmail.mstojcevich.lib.event;

/**
 * Interface for something that is cancellable.
 * @author marcusant
 * @version 1
 * @since 8/23/13 2:56 PM
 */
public interface Cancellable {

    /**
     * Whether or not the Cancellable is cancelled
     */
    boolean isCancelled = false;

    /**
     * Sets the state of the Cancellable
     * @param cancelled cancel state
     */
    public void setCancelled(boolean cancelled);

    /**
     * Returns if the Cancellable was cancelled
     */
    public boolean getCancelled();

}
