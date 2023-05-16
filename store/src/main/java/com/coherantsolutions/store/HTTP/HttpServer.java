package com.coherantsolutions.store.HTTP;
import com.coherantsolutions.store.HTTP.Handlers.OrderHandler;
import com.coherantsolutions.store.HTTP.Handlers.CategoryHandler;
import com.coherantsolutions.store.HTTP.Handlers.MainHandler;
import com.coherantsolutions.store.HTTP.Handlers.ProductHandler;
import com.sun.net.httpserver.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServer {

    private com.sun.net.httpserver.HttpServer httpServer;
    public static final String REALM = "store_realm";

    public void createHttpServer() {
        try {

            httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8088), 0);

            HttpContext categoryHandler = httpServer.createContext("/categories", new CategoryHandler());
            HttpContext orderHandler = httpServer.createContext("/order", new OrderHandler());
            HttpContext productHandler = httpServer.createContext("/products", new ProductHandler());
            HttpContext mainHandler = httpServer.createContext("/main", new MainHandler());
            categoryHandler.setAuthenticator(new HttpAuthenticator(REALM));
            orderHandler.setAuthenticator(new HttpAuthenticator(REALM));
            mainHandler.setAuthenticator(new HttpAuthenticator(REALM));
            productHandler.setAuthenticator(new HttpAuthenticator(REALM));
            //Create a default executor
            httpServer.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        this.httpServer.start();
    }
}
