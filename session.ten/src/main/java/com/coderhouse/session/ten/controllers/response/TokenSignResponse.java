package com.coderhouse.session.ten.controllers.response;

public class TokenSignResponse {

    private String token;

    public TokenSignResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
