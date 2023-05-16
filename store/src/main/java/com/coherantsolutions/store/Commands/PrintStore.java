package com.coherantsolutions.store.Commands;
import com.coherantsolutions.store.helpers.DBHelper;
import java.sql.SQLException;

public class PrintStore implements StoreCommand {

    DBHelper dbHelper;

    public PrintStore(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void execute() throws SQLException {
        dbHelper.printProductTable();
    }
}