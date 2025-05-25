package com.example.amiclo.service;

import com.example.amiclo.model.Request;
import java.util.List;

public interface RequestService {
    void saveRequest(Request request);
    List<Request> getAllRequests();

    Request getById(Long id);
    void deleteById(Long id);

}
