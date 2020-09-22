package com.example.bmatch.Models;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponse {
    public boolean auth;
    public String jwt;

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

}
