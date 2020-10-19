package com.example.bmatch.Services;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.bmatch.Interafaces.ImageServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Map;

@Service
public class ImageServicesImpl implements ImageServices {

    @Value("${upload.path}")
    private String uploadPath;

    public void path(MultipartFile file) throws IOException {
        //System.out.print( Paths.get(uploadPath+ file.getOriginalFilename()));

        //Path x = Paths.get(uploadPath+ file.getOriginalFilename());

        //System.out.print(Files.write(x,file.getBytes()).toAbsolutePath());
    }

    public void storeFile(MultipartFile file){
        String filename = StringUtils.cleanPath( System.currentTimeMillis()+file.getOriginalFilename());
        if (file.isEmpty()) {
            System.out.print("No file");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(uploadPath).resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            //System.out.println(Paths.get(uploadPath).resolve(filename));
            uploadToCloud(String.valueOf(Paths.get(uploadPath).resolve(filename)));
        }catch (IOException e) {
            System.out.print(e);
        }
    }

    public boolean setProfilePhoto(){
        return false;
    }

    public boolean saveNewPhoto(){
        return false;
    }


    @Override
    public boolean uploadImage() {
        //uploadToCloud(file);
        return false;
    }

    public void uploadToCloud(String file){
       Cloudinary cloudinary = cloudinaryHandler();
       sendFile(cloudinary,file);
    }

    private Cloudinary cloudinaryHandler(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvklp7oks",
                "api_key", "917555547179294",
                "api_secret", "yA3yJnvm4f0Y_D9LI2niF9lVxUA"));
        return cloudinary;
    }

    private boolean sendFile(Cloudinary cloudinary ,String file){
        try {
            Map uploadResult = cloudinary.uploader().upload("/home/reyes/Pictures/img/1603150840866Bmatch.png", ObjectUtils.emptyMap());
            manegeUploadResult(uploadResult);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file not found for sure");
            return false;
        }
    }

    private void manegeUploadResult(Map uploadResult){
        System.out.println(uploadResult.get("secure_url"));
    }
}

