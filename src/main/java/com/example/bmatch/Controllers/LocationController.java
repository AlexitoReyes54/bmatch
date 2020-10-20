package com.example.bmatch.Controllers;

import com.example.bmatch.Models.UserLocation;
import com.example.bmatch.Services.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

     @Autowired
     private UserLocationService userLocationService;

    @PostMapping("/location")
    public void setLocation(@RequestBody UserLocation userLocation){

        userLocationService.saveOrUpdateLocatiob(userLocation.getLatitude(),
                userLocation.getLongitude(),
                userLocation.getUser_id());

    }
}
