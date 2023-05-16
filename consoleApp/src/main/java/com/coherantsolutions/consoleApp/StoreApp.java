package com.coherantsolutions.consoleApp;
import com.coherantsolutions.store.Commands.*;
import com.coherantsolutions.store.HTTP.HttpServer;
import com.coherantsolutions.store.Store;
import com.coherantsolutions.store.Orders.ClearOrder;
import com.coherantsolutions.store.helpers.DBHelper;
import com.coherantsolutions.store.helpers.SortHelper;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;

public class StoreApp {

    public static void main(String[] args) throws ParserConfigurationException, SQLException {
        Store onlineStore = Store.getInstance();

        SortHelper sortHelper = new SortHelper(onlineStore);
        DBHelper dbHelper = new DBHelper(onlineStore);

        StoreCommand populateStore = new PopulateStore();
        StoreCommand sort = new SortStore(sortHelper);
        StoreCommand topFive = new TopFiveExpensive(sortHelper);
        StoreCommand ProductOrder = new ProductOrder();
        StoreCommand printStore = new PrintStore(dbHelper);
        StoreCommand exitApp = new ExitApp();

        CommandImplementation commandImplementation = new CommandImplementation(populateStore, sort, topFive, ProductOrder, printStore, exitApp);

        commandImplementation.populateStore();

        dbHelper.connectDB();
        dbHelper.clearDB();
        dbHelper.createCategoryTable();
        dbHelper.createProductTable();
        dbHelper.putDataToDB();

        Timer timer = new Timer();
        timer.schedule(new ClearOrder(),0,120_000);

        commandImplementation.PrintStore();

        final int PORT = 8088;
        HttpServer h = new HttpServer();
        h.createHttpServer();
        h.start();
        System.out.println("Server is started at port "+ PORT);
        
        System.out.println();
        System.out.println("Please enter your command :  1)sort , 2)top , 3) order , 4) quit ");
        Scanner sc = new Scanner(System.in);
        String command;
        while(sc.hasNext() ){
            command = sc.nextLine();
            switch (command) {
                case "sort":
                    commandImplementation.SortStore();
                    System.out.println();
                    System.out.println("Please enter your command :  1)sort , 2)top , 3) order , 4) quit ");
                    break;
                case "top":
                    commandImplementation.TopFive();
                    break;
                case  "order":
                    commandImplementation.CreateOrder();
                    System.out.println();
                    System.out.println("Please enter your command :  1)sort , 2)top , 3) order , 4) quit ");
                    break;
                case "quit":
                    commandImplementation.ExitApp();
                    System.out.println();
                    System.out.println("Please enter your command :  1)sort , 2)top , 3) order , 4) quit ");
                    break;
                default:
                    System.out.println("Invalid Command");
                }
            }
        }
    }
