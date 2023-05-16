package com.coherantsolutions.store.HTTP.Handlers;
import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class OrderHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        Store store = Store.getInstance();
        Product purchasedProduct = store.getAllProducts().get(new Random().nextInt(10));
        store.getPurchasedProductList().add(purchasedProduct);
        Gson gson = new Gson();
        gson.toJson(purchasedProduct);
        exchange.sendResponseHeaders(200, gson.toJson(purchasedProduct).length());
        OutputStream os = exchange.getResponseBody();
        os.write(gson.toJson(purchasedProduct).getBytes());
        System.out.println("Product " + purchasedProduct.getCategoryName() + " was added to cart");
        os.close();
    }
}
