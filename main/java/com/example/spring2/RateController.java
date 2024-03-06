package com.example.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RateController {
@Autowired
    RateService rateService;
   //@Autowired
    ClassTeacherService classTeacherService;

    @Autowired
    public RateController(RateService rateService, ClassTeacherService classTeacherService) {
        this.rateService = rateService;
        this.classTeacherService = classTeacherService;
    }
    @GetMapping("/addRateForm")
    public String showAddRateForm(Model model) {
        List<ClassTeacher> classTeachers = classTeacherService.getAllClassTeachers();
        model.addAttribute("classTeachers", classTeachers);
        return "addRateForm";
    }

    @PostMapping("/addRate")
    public String addRate(
            @RequestParam int ocena,
            @RequestParam String data, // Zakładam, że data jest przekazywana jako string (możesz dostosować)
            @RequestParam Long classaId,
            @RequestParam String komentarz) {

        // Przetwarzanie daty - poniżej tylko przykład, dostosuj do rzeczywistych potrzeb
        // Date date = Date.valueOf(data);

        // Pobieranie obiektu ClassTeacher na podstawie classaId (załóżmy, że masz odpowiednią metodę w serwisie)
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(classaId);

        // Tworzenie obiektu Rate
        Rate rate = new Rate();
        rate.setOcena(ocena);
        // rate.setData(date);
        rate.setClassa(classTeacher);
        rate.setKomentarz(komentarz);

        // Zapis oceny
        rateService.saveRate(rate);

        return "redirect:/addRateForm"; // Możesz przekierować użytkownika na stronę sukcesu lub inną stronę
    }
}