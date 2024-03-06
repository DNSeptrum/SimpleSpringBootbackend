package com.example.spring2;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.swing.text.html.HTML;
import java.util.List;

@Controller
@RequestMapping("/api/teacher")
public class Teachercontroller {
    @Autowired
    TeacherRepository repo;

        @PostMapping("/addTeacher")
        @ResponseBody
        String zapteacher(@RequestParam String imie, @RequestParam String nazwisko, @RequestParam String operator, @RequestParam int rok, @RequestParam double wynagrodzenie) {
            try {
                Teacher result = Teacherservice.zapisz(imie,nazwisko,operator,rok,wynagrodzenie);
                repo.save(result);

                return "nauczyciel zapisany do bazy";
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    String teacherlist() {

        return repo.findAll().toString();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        try {
           // Long id = Long.valueOf(request.getParameter("id"));
            repo.deleteById(id);
            return "deleteteacher.html";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    @RequestMapping(path = "/add")
    public String showTeacherForm() {
        return "addteacher.html";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteTeacherForm() {
        return "deleteteacher.html";
    }

    @GetMapping("/csv")
    public String exportObjectsToCsv(Model model) {
        List<Teacher> objects = (List<Teacher>) repo.findAll();
        model.addAttribute("csvData", CSVGenerator.generateCsv(objects));
        return "csvView.html";
     //   return CSVGenerator.generateCsv(objects);
    }
/*
    @GetMapping("/objects")
    public String exportObjectsToJson() {
        List<Teacher> objects = (List<Teacher>) repo.findAll();

        // Konwersja listy obiektów do formatu JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(objects);
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Obsługa błędu
        }
    }*/

    @GetMapping("/objects")
    public String exportObjectsToJson(Model model) {
        List<Teacher> objects = (List<Teacher>) repo.findAll();

        // Dodaj obiekt do modelu jako atrybut
        model.addAttribute("jsonData", objects);

        // Zwróć nazwę widoku Thymeleaf
        return "jsonView.html";
    }


}
