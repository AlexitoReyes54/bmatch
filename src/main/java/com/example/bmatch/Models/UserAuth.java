package com.example.bmatch.Models;

import javax.persistence.*;

@Entity
@Table(name = "User_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int auth_id;

    @Column(name="user_id")
    private int userId;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="pin")
    private int pin;

    @Column(name="active")
    private int active;

    public UserAuth() {
    }


    public int getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(int auth_id) {
        this.auth_id = auth_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
