package com.coherantsolutions.store.Commands;
import com.coherantsolutions.store.Store;
import com.coherantsolutions.store.helpers.RandomStorePopulator;

public class PopulateStore implements StoreCommand{
    private final Store store = Store.getInstance();
    private final RandomStorePopulator populateStore = new RandomStorePopulator(store);
    @Override
    public void execute() {
        populateStore.fillStoreRandomly();
    }
}