package com.example.amiclo.controller;

import com.example.amiclo.model.Request;
import com.example.amiclo.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/send-request")
    public String submitRequest(@ModelAttribute Request request) {
        requestService.saveRequest(request);
        return "redirect:/contacts?success=true";
    }

    @GetMapping("/admin/requests")
    public String viewRequests(Model model) {
        model.addAttribute("requests", requestService.getAllRequests());
        return "admin/requests"; // будет страница с таблицей заявок
    }

    @ModelAttribute("request")
    public Request request() {
        return new Request();
    }

    @GetMapping("/admin/requests/edit/{id}")
    public String editRequestForm(@PathVariable Long id, Model model) {
        Request request = requestService.getById(id);
        model.addAttribute("request", request);
        return "admin/edit-request";
    }

    @PostMapping("/admin/requests/edit")
    public String updateRequest(@ModelAttribute("request") Request request) {
        requestService.saveRequest(request);
        return "redirect:/admin/requests";
    }

    @PostMapping("/admin/requests/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteById(id);
        return "redirect:/admin/requests";
    }


}
