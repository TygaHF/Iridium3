/*
 * EventHandler
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes the firing of events to registered listeners
 * @author marcusant
 * @version 1
 * @since 8/23/13 3:00 PM
 */
public class EventHandler {

    /**
     * List of ListenerInstances used for firing events
     */
    private List<ListenerInstance> listeners =
            new ArrayList<ListenerInstance>();

    /**
     * Registers a listening class and all of its listening methods.
     * @param listener Listening class
     */
    public void registerListener(EventListener listener) {
        ListenerInstance listenerInstance = new ListenerInstance(listener);
        this.listeners.add(listenerInstance);
        this.registerMethods(listenerInstance);
    }

    /**
     * Registers a listening class and all of its listening methods.
     * @param listener ListenerInstance
     */
    private void registerMethods(ListenerInstance listener) {
        for (Method method : listener.listener.getClass()
                .getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof HandleEvent) {
                    listener.methods.add(method);
                }
            }
        }
    }

    /**
     * Sends an event to all listening methods with a given priority
     * @param event Target event
     * @param priority Target priority
     */
    private void sendEventsToPriority(Event event, EventPriority priority){
        for(ListenerInstance listenerInstance : this.listeners){
            for (Method method : listenerInstance.methods) {
                //Stop any cancelled events
                if(event instanceof Cancellable){
                    Cancellable cancellable = (Cancellable)event;
                    if(cancellable.getCancelled()){
                        return;
                    }
                }
                if(method.getAnnotation(HandleEvent.class).priority() != priority)continue;
                for (Class<?> c : method.getParameterTypes()) {
                    if (event.getClass().isAssignableFrom(c)) {
                        try {
                            method.invoke(listenerInstance.listener, event);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Sends an event to all of the listeners in order of priority
     * @param event Target event
     */
    public void fireEvent(Event event){
        for(EventPriority priority : EventPriority.values()){
            this.sendEventsToPriority(event, priority);
        }
    }

}