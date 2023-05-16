package com.coherantsolutions.store.Commands;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;

public class CommandImplementation {

    private final StoreCommand sortStore;
    private final StoreCommand getTopFive;
    private final StoreCommand populateStore;
    private final StoreCommand printStore;
    private final StoreCommand ProductOrder;

    private final StoreCommand exitApp;

    public CommandImplementation(StoreCommand populateStore, StoreCommand sortStore, StoreCommand getTopFive, StoreCommand ProductOrder, StoreCommand printStore, StoreCommand exitApp) {
        this.populateStore = populateStore;
        this.sortStore = sortStore;
        this.getTopFive = getTopFive;
        this.ProductOrder = ProductOrder;
        this.printStore = printStore;
        this.exitApp = exitApp;
    }

    public void populateStore() throws ParserConfigurationException, SQLException {
        populateStore.execute();
    }

    public void SortStore() throws ParserConfigurationException, SQLException {
        sortStore.execute();
    }

    public void TopFive() throws ParserConfigurationException, SQLException {
        getTopFive.execute();
    }

    public void CreateOrder() throws ParserConfigurationException, SQLException {
        ProductOrder.execute();
    }

    public void PrintStore() throws ParserConfigurationException, SQLException {
        printStore.execute();
    }

    public void ExitApp() throws ParserConfigurationException, SQLException {
        exitApp.execute();
    }
}