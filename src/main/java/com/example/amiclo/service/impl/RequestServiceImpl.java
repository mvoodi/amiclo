package com.example.amiclo.service.impl;

import com.example.amiclo.model.Request;
import com.example.amiclo.repository.RequestRepository;
import com.example.amiclo.service.RequestService;
import com.example.amiclo.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final EmailService emailService;

    public RequestServiceImpl(RequestRepository requestRepository, EmailService emailService) {
        this.requestRepository = requestRepository;
        this.emailService = emailService;
    }

    @Override
    public void saveRequest(Request request) {
        requestRepository.save(request);
        emailService.sendNewRequestNotification(request);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}
