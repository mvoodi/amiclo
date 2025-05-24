package com.example.amiclo.service.impl;

import com.example.amiclo.model.Request;
import com.example.amiclo.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${mail.to}")
    private String adminEmail;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendNewRequestNotification(Request request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminEmail);
        message.setSubject("Новая заявка от " + request.getName());
        message.setText(
                "Имя: " + request.getName() + "\n" +
                        "Телефон: " + request.getPhone() + "\n" +
                        "Сообщение: " + request.getMessage()
        );
        mailSender.send(message);
    }
}
