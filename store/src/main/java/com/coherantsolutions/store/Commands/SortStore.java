package com.coherantsolutions.store.Commands;
import com.coherantsolutions.store.Store;
import com.coherantsolutions.store.helpers.SortHelper;

import javax.xml.parsers.ParserConfigurationException;

public class SortStore implements StoreCommand{

    private final SortHelper sortHelper;
     private Store store;

    public SortStore (SortHelper sortHelper )  {
        this.sortHelper = sortHelper;
    }

    @Override
    public void execute() throws ParserConfigurationException {
        sortHelper.sortByXML(store);
    }
}