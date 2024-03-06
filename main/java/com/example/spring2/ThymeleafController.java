package com.example.spring2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String thymeleafView(Model model) {
        // Przykładowe dane do wyświetlenia w widoku Thymeleaf
        model.addAttribute("message", "Widok Thymeleaf");

        // Zwróć nazwę widoku Thymeleaf
        return "thymeleafView.html";
    }
}