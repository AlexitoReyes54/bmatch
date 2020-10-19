package com.example.bmatch.Services;

import com.example.bmatch.Interafaces.SingIn;
import com.example.bmatch.Models.AuthenticationResponse;
import com.example.bmatch.Models.UserAuth;
import com.example.bmatch.Repositories.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingInServiceImpl implements SingIn {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationResponse authenticationResponse;
    @Autowired
    private UserAuthRepository userAuthRepository;

    public AuthenticationResponse executeSingInProcess(String email,String password) {
        try {
           return singInProcess(email,password);
        }catch (Exception e){
            System.out.println("Log in error");
        }finally {
            return singInProcess(email,password);
        }
    }

    @Override
    public AuthenticationResponse singInProcess(String email,String password) {
            validateCredentials(email,password);
            return authenticationResponse;
    }

    private void updateResponseValues(boolean valid){
        authenticationResponse.setAuth(valid);
        authenticationResponse.setJwt("empty");
    }

    private void validateCredentials(String email,String password){
        if (checkEmail(email) && passwordIsCorrect(password,email) && accountIsActive(email)){
            updateResponseValues(true);
        }else {
            updateResponseValues(false);
        }
    }

    private boolean checkEmail(String email) {
        Optional<UserAuth> emailExist =  userAuthRepository.findByEmail(email);
        if (emailExist.isPresent()){
            return true;
        }else {
            return false;
        }
    }

    private boolean passwordIsCorrect(String password,String email) {
        Optional<UserAuth> userExist = userAuthRepository.findByEmail(email);
        if (userExist.isPresent()){
            return passwordEncoder.matches(password,userExist.get().getPassword());
        }else {
            return false;
        }

    }

    private boolean accountIsActive(String email) {
        Optional<UserAuth> userObj =  userAuthRepository.findByEmail(email);
        if (userObj.get().getActive() == 1){
            return true;
        }else {
            return false;
        }
    }

}
