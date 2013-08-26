package com.gmail.mstojcevich.lib.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to flag methods for event handling
 * @author marcusant
 * @version 1
 * @since 8/23/13 3:09 PM
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandleEvent {

    /**
     * Determines at what point the event is called.
     * FIRST is for methods that need to cancel the event
     * or change things prior to normal methods running,
     * NORMAL is used by default and is for normal methods,
     * LAST is usually used to monitor the outcome of an event.
     * @return
     */
    public EventPriority priority() default EventPriority.NORMAL;

}
