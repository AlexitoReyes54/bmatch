package com.example.bmatch.Interafaces;

import com.example.bmatch.Models.AuthenticationResponse;

public interface SingIn {

    public AuthenticationResponse singInProcess();

    private boolean findEmail() {
        return false;
    }

    private boolean passwordIsCorrect() {
        return false;
    }
}
