package com.coherantsolutions.store.HTTP.Handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;


public class MainHandler implements HttpHandler {

    final int PORT = 8088;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Welcome to our server, our server is running  at PORT:" + PORT + " Available options: /orders /products /categories /main";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}