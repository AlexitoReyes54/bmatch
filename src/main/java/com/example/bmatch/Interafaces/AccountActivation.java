package com.example.bmatch.Interafaces;

public interface AccountActivation {

    public boolean activateAccuontProcess(String email,int pin);

    private boolean validatePin() {
        return false;
    }

    private void activateUser() {}
}
