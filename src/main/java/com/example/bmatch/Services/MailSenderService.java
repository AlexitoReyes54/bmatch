package com.example.bmatch.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    private void sendActivationEmail(String adress,int pin) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(adress);
        mail.setFrom("alejareal54@gmail.com");
        mail.setSubject("Subject");
        mail.setText("This is your secret pin: "+pin);

        javaMailSender.send(mail);
    }

    public void executeActivationMailSending(String email, int pin){
        try{
            sendActivationEmail(email,pin);
        }catch (MailException e){
            System.out.println("err mail"+e.getMessage());
        }

    }


}


