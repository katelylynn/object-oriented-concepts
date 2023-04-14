package org.callbacks;

public class CallbackDriver {

    public static void main(String[] args) {
        InputEvent input = new InputEvent();
        input.TriggerInputEvent();
        Boolean run = true;
        while(run) {
            run = input.TriggerInputEvent();
        }
    }

}
