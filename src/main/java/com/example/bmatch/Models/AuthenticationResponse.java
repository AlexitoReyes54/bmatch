package com.example.bmatch.Models;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponse {
    public boolean auth;
    public String jwt;
}
