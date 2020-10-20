package com.example.bmatch.Services;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.bmatch.Interafaces.ImageServices;
import com.example.bmatch.Models.Image;
import com.example.bmatch.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ImageRepository imageRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public boolean uploadImage() {
        //uploadToCloud(file);
        return false;
    }


    public void storeFile(MultipartFile file,int id){
        String filename = StringUtils.cleanPath( System.currentTimeMillis()+file.getOriginalFilename());
        if (file.isEmpty()) {
            System.out.print("No file");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(uploadPath).resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);

            //allow to choose if is a profile photo or not
            uploadToCloud(String.valueOf(Paths.get(uploadPath).resolve(filename)),id);
        }catch (IOException e) {
            System.out.print(e);
        }
    }

    public boolean setProfilePhoto(int id,String url){
        try{
            imageRepository.save(buildImageObj(id,1,url));
            return true;
        }catch (Exception e ){
            System.out.println("not save");
            return false;
        }
    }

    public boolean saveNewPhoto(int id,String url){
        try{
            imageRepository.save(buildImageObj(id,0,url));
            return true;
        }catch (Exception e ){
            System.out.println("not save");
            return false;
        }
    }

    private Image buildImageObj(int id,int profile,String url){
        Image image = new Image();
        image.setUserId(id);
        image.setImageUrl(url);
        image.setProfile(profile);
        return image;
    }

    public void uploadToCloud(String file,int id){
       Cloudinary cloudinary = cloudinaryHandler();
       sendFile(cloudinary,file,id);
    }

    private Cloudinary cloudinaryHandler(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dvklp7oks",
                "api_key", "917555547179294",
                "api_secret", "yA3yJnvm4f0Y_D9LI2niF9lVxUA"));
        return cloudinary;
    }

    private boolean sendFile(Cloudinary cloudinary ,String file, int id){
        try {
            Map uploadResult = cloudinary.uploader().upload("/home/reyes/Pictures/img/1603150840866Bmatch.png", ObjectUtils.emptyMap());
            saveNewPhoto(id, (String) uploadResult.get("secure_url"));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file not found for sure");
            return false;
          }
        }
    }


