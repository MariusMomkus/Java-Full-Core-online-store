package com.coherantsolutions.store.Commands;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;

public interface StoreCommand {
    void execute() throws ParserConfigurationException, SQLException;
}