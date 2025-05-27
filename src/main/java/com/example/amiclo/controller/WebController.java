package com.example.amiclo.controller;

import com.example.amiclo.model.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Главная — AmiClo");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "О нас — AmiClo");
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("pageTitle", "Услуги — AmiClo");
        return "services";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageTitle", "Контакты — AmiClo");
        return "contacts";
    }
    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("pageTitle", "Каталог — AmiClo");
        return "catalog";
    }

}
