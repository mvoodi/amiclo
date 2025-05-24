package com.example.amiclo.service;

import com.example.amiclo.model.Request;

public interface EmailService {
    void sendNewRequestNotification(Request request);
}
