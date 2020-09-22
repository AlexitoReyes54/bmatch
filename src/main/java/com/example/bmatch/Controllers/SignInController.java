package com.example.bmatch.Controllers;

import com.example.bmatch.Models.AuthRequest;
import com.example.bmatch.Models.AuthenticationResponse;
import com.example.bmatch.Services.SingInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {

    @Autowired
    private SingInServiceImpl singInService;

    @PostMapping("/auth")
    public AuthenticationResponse auth(@RequestBody AuthRequest user){
        return singInService.singInProcess(user.getEmail(),user.getPassword());
    }


}
