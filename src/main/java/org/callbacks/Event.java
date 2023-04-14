package org.callbacks;

public class Event {

    EventListener eventListener;

    public Event(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void trigger() {
        eventListener.onTrigger();
    }

}
