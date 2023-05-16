package com.coherantsolutions.store.helpers;
import com.coherantsolutions.domain.Category;
import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import java.sql.*;
import java.util.List;

public class DBHelper {

    Store store;

    public DBHelper(Store store) {
        this.store = store;
    }

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";

    Connection conn = null;
    Statement stmt = null;

    public void connectDB() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearDB() {

        String dropCategory = "DROP TABLE IF EXISTS CATEGORY";
        String dropProduct = "DROP TABLE IF EXISTS PRODUCT";
        try {
            stmt.executeUpdate(dropProduct);
            stmt.executeUpdate(dropCategory);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCategoryTable() {

        String createCategoryTable = "CREATE TABLE IF NOT EXISTS CATEGORY" +
                "(ID int PRIMARY KEY AUTO_INCREMENT, " +
                " NAME VARCHAR(255) NOT NULL)";
        try {
            stmt.executeUpdate(createCategoryTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProductTable() {

        String createProductTable = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                "(ID int PRIMARY KEY AUTO_INCREMENT, " +
                " CATEGORY_ID int NOT NULL, " +
                " NAME VARCHAR(255) NOT NULL, " +
                " PRICE DECIMAL NOT NULL, " +
                " RATE DECIMAL NOT NULL, " +
                " FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID))";
        try {
            stmt.executeUpdate(createProductTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void putDataToDB() throws SQLException {

        List<Category> categories = store.getCategoryList();
        List<Product> products = store.getAllProducts();

        PreparedStatement putCategoriesToDB = conn.prepareStatement("INSERT INTO CATEGORY (NAME) VALUES(?)");

        for (Category category : categories) {
            putCategoriesToDB.setString(1, category.getCategoryName());
            putCategoriesToDB.executeUpdate();

            PreparedStatement getCategoryID = conn.prepareStatement("SELECT ID FROM CATEGORY WHERE NAME = ?");
            getCategoryID.setString(1, category.getCategoryName());
            ResultSet CatIDResultSet = getCategoryID.executeQuery();

            int id = 0;
            while (CatIDResultSet.next()) {
                id = CatIDResultSet.getInt("ID");
            }

            PreparedStatement addProductToDB = conn.prepareStatement("INSERT INTO PRODUCT (CATEGORY_ID, NAME, PRICE, RATE) VALUES(?,?,?,?)");

            for (Product product : products) {

                addProductToDB.setInt(1, id);
                addProductToDB.setString(2, product.getCategoryName());
                addProductToDB.setDouble(3, product.getPrice());
                addProductToDB.setDouble(4, product.getRate());
                addProductToDB.executeUpdate();
            }
        }
    }

    public void printProductTable() throws SQLException {

        String sql = "SELECT C.NAME CATEGORY_NAME, P.NAME, PRICE, RATE FROM PRODUCT P JOIN CATEGORY C ON " +
                "C.ID = P.CATEGORY_ID";

        ResultSet resultSet = stmt.executeQuery(sql);

        System.out.println("Welcome to Online Store!");

        while (resultSet.next()) {

            String categoryName = resultSet.getString("CATEGORY_NAME");
            String name = resultSet.getString("NAME");
            Double price = resultSet.getDouble("PRICE");
            Double rate = resultSet.getDouble("RATE");

            System.out.print("Category name: " + categoryName);
            System.out.print(" ,Product name: " + name);
            System.out.print(", Product price: " + price);
            System.out.println(", Product rate: " + rate);
        }
        stmt.close();
        conn.close();
    }
}
