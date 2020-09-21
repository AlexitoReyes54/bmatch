package com.example.bmatch.Models;

import org.springframework.stereotype.Component;

@Component
public class UserSavedStatus {
public boolean validMail;
public boolean error;

    public boolean isValidMail() {
        return validMail;
    }

    public void setValidMail(boolean validMail) {
        this.validMail = validMail;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
