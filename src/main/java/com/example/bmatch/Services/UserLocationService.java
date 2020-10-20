package com.example.bmatch.Services;

import com.example.bmatch.Models.UserLocation;
import com.example.bmatch.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {

    @Autowired
    private LocationRepository locationRepository;

    public void saveOrUpdateLocatiob(int latitude,int longitude,int id){
        try{
            locationRepository.save(buildLocation(latitude,longitude,id));
        }catch (Exception e){

        }
    }

    private UserLocation buildLocation(int latitude,int longitude,int id) {
        UserLocation userLocation = new UserLocation();
        userLocation.setUser_id(id);
        userLocation.setLatitude(latitude);
        userLocation.setLongitude(longitude);
        return userLocation;
    }

}
