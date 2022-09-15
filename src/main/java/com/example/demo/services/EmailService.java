package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String email,String title, String text){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(email);
        smm.setFrom("patrickanthony979@gmail.com");
        smm.setReplyTo("patrickanthony979@gmail.com");
        smm.setSubject(title);
        smm.setText(text);
        mailSender.send(smm);
    }
}
