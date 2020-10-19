package com.example.bmatch.Controllers;

import com.example.bmatch.Models.ActivationRequest;
import com.example.bmatch.Services.ImageServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileStore;

@RestController
public class ImageController {


    @Autowired
    private ImageServicesImpl imageServices;

    @GetMapping("/img")
    public boolean test(){
        return true;
    }

    @PostMapping(value = "/uploadImg",consumes = {"multipart/form-data"})
    public boolean up(@RequestParam("file") MultipartFile file){
        try{
            imageServices.storeFile(file);
            return true;
        }catch (Exception e){
            System.out.println("no manito");
            return false;
        }
    }
}
