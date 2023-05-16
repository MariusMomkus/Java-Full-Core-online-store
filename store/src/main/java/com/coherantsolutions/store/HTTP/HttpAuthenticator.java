package com.coherantsolutions.store.HTTP;
import com.sun.net.httpserver.BasicAuthenticator;

public class HttpAuthenticator extends BasicAuthenticator {

    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public HttpAuthenticator(String realm) {
        super(realm);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return username.equals(USER) && password.equals(PASSWORD);
    }
}
