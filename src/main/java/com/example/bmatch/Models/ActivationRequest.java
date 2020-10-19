package com.example.bmatch.Models;

import org.springframework.stereotype.Component;

@Component
public class ActivationRequest {
    public String email;
    public int pin;

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
