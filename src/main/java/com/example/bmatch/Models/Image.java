package com.example.bmatch.Models;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int image_id;

    @Column(name="user_id")
    public int userId;

    @Column(name="url")
    public String imageUrl;

    @Column(name="profile")
    public int profile;

    public int getImageId() {
        return image_id;
    }

    public void setImageId(int imageId) {
        this.image_id = imageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
