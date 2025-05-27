package com.example.amiclo.controller;

import com.example.amiclo.model.Request;
import com.example.amiclo.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/requests")
public class RequestController {

    private final RequestService service;
    public RequestController(RequestService service) { this.service = service; }

    /* СПИСОК ЗАЯВОК */
    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("requests", service.getAllRequests());
        return "admin/requests";
    }

    /* ФОРМА РЕДАКТИРОВАНИЯ */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("request", service.getById(id));
        return "admin/edit-request";
    }

    /* ОБНОВЛЕНИЕ */
    @PostMapping("/edit")
    public String update(@ModelAttribute Request request) {
        service.saveRequest(request);
        return "redirect:/admin/requests";
    }

    /* УДАЛЕНИЕ */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/admin/requests";
    }
}
