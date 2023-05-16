package com.coherantsolutions.store.Commands;

public class ExitApp implements StoreCommand {
    @Override
    public void execute() {
        System.out.println("See you soon");
        System.exit(0);
    }
}
