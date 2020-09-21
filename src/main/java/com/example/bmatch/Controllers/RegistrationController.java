package com.example.bmatch.Controllers;

import com.example.bmatch.Models.UserAuth;
import com.example.bmatch.Models.UserDetail;
import com.example.bmatch.Models.UserRegistration;
import com.example.bmatch.Models.UserSavedStatus;
import com.example.bmatch.Services.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegisterServiceImpl registerServiceImpl;

    @GetMapping("/register1")
    public String register(){
        return "hello";
    }

    @PostMapping("/register")
    public UserSavedStatus registerUser(@RequestBody UserRegistration user){
            return registerServiceImpl.registrationProcess(user);
    }




}
