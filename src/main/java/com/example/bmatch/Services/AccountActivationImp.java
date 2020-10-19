package com.example.bmatch.Services;

import com.example.bmatch.Interafaces.AccountActivation;
import com.example.bmatch.Models.Preferences;
import com.example.bmatch.Models.UserAuth;
import com.example.bmatch.Models.UserDetail;
import com.example.bmatch.Repositories.PreferencesRepository;
import com.example.bmatch.Repositories.UserAuthRepository;
import com.example.bmatch.Repositories.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountActivationImp implements AccountActivation {
    @Autowired
    private UserAuthRepository userAuthRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private PreferencesRepository preferencesRepository;

    @Override
    public boolean activateAccuontProcess(String email,int pin) {
        if (validatePin(email, pin)) {
            activateUser(email);
            createPreferences(email);
            return true;
        }else{
            return false;
        }
    }

    private boolean validatePin(String email,int pin) {
        Optional<UserAuth> userObj =  userAuthRepository.findByEmail(email);
        if (userObj.get().getPin() == pin){
            return true;
        }else {
            return false;
        }

    }

    private void activateUser(String email) {
        Optional<UserAuth> userObj = userAuthRepository.findByEmail(email);
        userObj.get().setActive(1);
        userAuthRepository.save(userObj.get());
    }

    private void createPreferences(String email){
        Optional<UserAuth> userObj = userAuthRepository.findByEmail(email);
        Optional<UserDetail> userDetail = userDetailRepository.findById(userObj.get().getUserId());
        Preferences preferences = new Preferences();
        preferences.setUserId(userObj.get().getUserId());
        preferences.setGenderPreference(setSexPreference(userDetail.get().getGender()));
        preferencesRepository.save(preferences);
    }

    private String setSexPreference(String sex){
        if (sex == "M"){
            return "F";
        }else {
            return "M";
        }
    }
}
