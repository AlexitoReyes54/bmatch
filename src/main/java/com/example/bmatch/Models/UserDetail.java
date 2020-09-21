package com.example.bmatch.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int user_id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_lastname")
    private String userLastname;

    @Column(name="description")
    private String description;

    @Column(name="address")
    private String address;

    @Column(name="hobbies")
    private String hobbies;

    @Column(name="profession")
    private String profession;

    @Column(name="user_age")
    private int userAge;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="institution")
    private String institution;

    @Column(name="gender")
    private String gender;

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public Number getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
