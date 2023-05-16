package com.coherantsolutions.store.Commands;
import com.coherantsolutions.store.Store;
import com.coherantsolutions.store.helpers.SortHelper;

public class TopFiveExpensive implements StoreCommand {

    private final SortHelper topFive;
    private final Store store = Store.getInstance();

    public TopFiveExpensive(SortHelper sortHelper )  {
        this.topFive = sortHelper;
    }

    @Override
    public void execute() {
        topFive.TopFiveExpensive(store);
    }
}