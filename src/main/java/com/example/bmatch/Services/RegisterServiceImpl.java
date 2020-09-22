package com.example.bmatch.Services;

import com.example.bmatch.Interafaces.RegisterService;
import com.example.bmatch.Models.*;
import com.example.bmatch.Repositories.PreferencesRepository;
import com.example.bmatch.Repositories.UserAuthRepository;
import com.example.bmatch.Repositories.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {
    private int activationPin;
    private String email;
    private int detailId;

    @Autowired
    private PreferencesRepository preferencesRepository;
    @Autowired
    private UserSavedStatus userSavedStatus;
    @Autowired
    private MailSenderService mailSenderService;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserSavedStatus registrationProcess(UserRegistration user) {
        updateValues(user);

        if (validateMail(user.getGmail())){
            userSavedStatus.setValidMail(true);
            boolean detailSaved =  executeDetailRegistration(user);
            boolean authsaved = executeAuthRegistration(user);
            return processComplete(detailSaved,authsaved,user);
        }else{
            userSavedStatus.setValidMail(false);
            userSavedStatus.setError(false);
            return userSavedStatus;
        }
    }

    private void executePreferencesSave(UserRegistration user){
        try{
         savePreferences(user);
        }catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    private void updateValues(UserRegistration user){
        this.email = user.getGmail();
        this.activationPin = pinGenerator();
    }

    private UserSavedStatus processComplete(boolean detail,boolean auth,UserRegistration user){
        if (detail == true && auth == true){
            userSavedStatus.setError(false);
            //sendActivationMail();
            return userSavedStatus;
        }else {
            userSavedStatus.setError(true);
            return userSavedStatus;
        }

    }

    public boolean executeAuthRegistration(UserRegistration user){
        try{
            executeAuthSave(user);
            return true;
        }catch (Exception e){
            System.out.println("error "+e);
            return false;
        }

    }

    public void executeAuthSave(UserRegistration user){
        int detailId = findDetailUserId(user.getUserName(),user.getUserLastname());
        if (detailId > 0){
            saveUserAuth(user,detailId);
        }
    }

    public boolean executeDetailRegistration(UserRegistration user){
        try{
            saveUserDetail(user);
            return true;
        }catch (Exception e){
            System.out.println("error "+e);
            return false;
        }
    }

    @Override
    public int findDetailUserId(String name,String lastname) {
        Optional<UserDetail> user;
        user = userDetailRepository.findByUserNameAndUserLastname(name,lastname);
        if (user.isPresent()){
            return (int) user.get().getUser_id();
        }else{
            return -1;
        }
    }

    @Override
    public void saveUserAuth(UserRegistration user,Number detailId) {
    UserAuth userAuth = buildUserAuthObj(user,detailId);
    userAuthRepository.save(userAuth);
    }

    @Override
    public void saveUserDetail(UserRegistration user) {
        UserDetail DetailUser = buildUserDetialObj(user);
        userDetailRepository.save(DetailUser);
    }

    private UserDetail buildUserDetialObj(UserRegistration registration){
        UserDetail DetailUser = new UserDetail();

        DetailUser.setUserName(registration.getUserName());
        DetailUser.setUserLastname(registration.getUserLastname());
        DetailUser.setDescription(registration.getDescription());
        DetailUser.setAddress(registration.getAddress());
        DetailUser.setHobbies(registration.getHobbies());
        DetailUser.setProfession(registration.getProfession());
        DetailUser.setUserAge(registration.getUserAge());
        DetailUser.setBirthDate(registration.getBirthDate());
        DetailUser.setInstitution(registration.getInstitution());
        DetailUser.setGender(registration.getGender());

        return DetailUser;
    }

    private UserAuth buildUserAuthObj(UserRegistration registration,Number detailId){
        UserAuth auth = new UserAuth();
        auth.setUserId((Integer) detailId);
        auth.setPassword(passwordEncoder.encode(registration.getPassword()));
        auth.setPin(activationPin);
        auth.setActive(0);
        auth.setEmail(registration.getGmail());

        System.out.println(auth.getPassword());
        System.out.println(auth.getPassword().length());
        return auth;
    }

    private Preferences buildPreferences(UserRegistration user){
        //int detailId = findDetailUserId(user.getUserName(),user.getUserLastname());
        Preferences pref = new Preferences();
        pref.setMinAge(0);
        pref.setMaxAge(0);
        pref.setUserId(detailId);
        pref.setGenderPreference(selectGenderPref(user.getGender()));
        return pref;
    }

    private String selectGenderPref(String gender){
        if (gender == "M"){
            return "F";
        }else{
            return "M";
        }
    }

    private void savePreferences(UserRegistration user){
        preferencesRepository.save(buildPreferences(user));
    }

    private int pinGenerator(){
        String pinContainer = "";
        for (int i = 0; i < 4;i++){
            int randomValue = (int) Math.floor(Math.random()*9);
            pinContainer += randomValue;
        }
        return Integer.parseInt(pinContainer);
    }

    private boolean validateMail(String mail){
        Optional<UserAuth> mailExist = userAuthRepository.findByEmail(mail);
        if (mailExist.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void sendActivationMail() {
        mailSenderService.executeActivationMailSending(this.email,this.activationPin);
    }
}
