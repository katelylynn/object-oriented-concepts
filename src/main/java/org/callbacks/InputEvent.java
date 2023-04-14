package org.callbacks;

import java.util.Scanner;

public class InputEvent {

    private final EventListener eventListener;

    public InputEvent() {
        this.eventListener = new DownloadDataEventListener();
    }

    public Boolean TriggerInputEvent() {

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\"exit\" to exit, or enter to continue");
        String input = scan.nextLine();
        new Thread(() -> eventListener.onTrigger()).start();

        return !input.equals("exit");

    }

}
