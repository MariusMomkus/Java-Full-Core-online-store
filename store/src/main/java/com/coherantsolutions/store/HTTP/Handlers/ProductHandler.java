package com.coherantsolutions.store.HTTP.Handlers;

import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class ProductHandler implements HttpHandler {
    private static final Gson gson = new Gson();
    private static final StringBuilder sb = new StringBuilder();
    Store store = Store.getInstance();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        sb.append("Products: ");
        for (Product product : new ArrayList<>(store.getAllProducts())) {
            sb.append(" ").append(product.getCategoryName()).append(";");
        }
        byte[] response = gson.toJson(sb.toString()).getBytes();
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
        exchange.close();
    }
}