/*
 * ListenerInstance
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains a listener and a list of its listening methods
 * @author marcusant
 * @version 1
 * @since 8/23/13 4:24 PM
 */
public class ListenerInstance {

    /**
     * Class listening for events
     */
    public EventListener listener;

    /**
     * Methods within listener class listening for events
     */
    public List<Method> methods = new ArrayList<Method>();

    /**
     * @param listener listening class
     */
    public ListenerInstance(EventListener listener){
        this.listener = listener;
    }

}
