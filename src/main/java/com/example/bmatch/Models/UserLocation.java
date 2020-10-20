package com.example.bmatch.Models;

import javax.persistence.*;

@Entity
@Table(name = "user_location")
public class UserLocation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int user_id;

    @Column(name="actual_longitude")
    private int longitude;

    @Column(name="actual_latitude")
    private int latitude;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int auth_id) {
        this.user_id = auth_id;
    }


    public int getLatitude() {
        return latitude;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }


    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
