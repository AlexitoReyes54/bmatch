package com.example.bmatch.Controllers;

import com.example.bmatch.Models.ActivationRequest;
import com.example.bmatch.Models.AuthRequest;
import com.example.bmatch.Services.AccountActivationImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivationController {

    @Autowired
    private AccountActivationImp accountActivationImp;

    @PostMapping("/activate")
    public boolean activateUser(@RequestBody ActivationRequest credentials){
        return accountActivationImp.activateAccuontProcess(credentials.getEmail(),credentials.getPin());
    }
}
