package com.example.bmatch.Interafaces;

import com.example.bmatch.Models.UserDetail;
import com.example.bmatch.Models.UserRegistration;
import com.example.bmatch.Models.UserSavedStatus;

public interface RegisterService {
    UserSavedStatus registrationProcess(UserRegistration user);
    int findDetailUserId(String name,String lastname);
    void saveUserAuth(UserRegistration user, Number id);
    void saveUserDetail(UserRegistration user);
    void sendActivationMail();

    private UserDetail buildUserDetialObj(UserRegistration registration) {
        return null;
    }

}
