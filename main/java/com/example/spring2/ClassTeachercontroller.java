package com.example.spring2;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.HTML;
import java.util.*;

@Controller
@RequestMapping("/api/classteacher")
public class ClassTeachercontroller {
    @Autowired
    GroupRepository repo;
    @Autowired
    TeacherRepository teacherRepository;
   // @Autowired
    private ClassTeacherService classTeacherService;

    @Autowired
    private Teacherservice teacherService;

    @PostMapping("/addclassTeacher")
    @ResponseBody
    String zapclassteacher(@RequestParam String nazwa, @RequestParam double liczba_na) {
        try {
            ClassTeacher result = ClassTeacherService.zapisz(nazwa, liczba_na);
            repo.save(result);

            return "klasa zapisany do bazy";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        try {
            // Long id = Long.valueOf(request.getParameter("id"));
            repo.deleteById(id);
            return "deleteclassteacher.html";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    @RequestMapping(path = "/add")
    public String showTeacherForm() {
        return "addclassTeacher.html";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteclassTeacherForm() {
        return "deleteclassteacher.html";
    }


    @GetMapping("/{id}")
    public String showClassTeacherForm(@PathVariable Long id, Model model) {
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);
        model.addAttribute("classTeacher", classTeacher);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "addTeacherForm";
    }
    @GetMapping("/")
    public String showClassTeacherFormser(Model model) {
        ClassTeacher classTeacher = new ClassTeacher("grupa",10.0);
        model.addAttribute("classTeacher", classTeacher);
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "addTeacherForm";
    }

    @PostMapping("/{id}")
    public String addTeacherToClass(
           // @PathVariable("id") Long id,
            @RequestParam("nauczycieleid") Long nauczycieleid,
            @RequestParam("classid") Long id

    ) {
        try {
            ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);

            // Pobierz nauczyciela po teacherId
            Optional<Teacher> optionalTeacher = teacherRepository.findById(nauczycieleid);

            if (optionalTeacher.isPresent()) {
                Teacher teacher = optionalTeacher.get();

                classTeacher.getNauczyciele().add(teacher);


                repo.save(classTeacher);
            }
            return "redirect:/api/classteacher/" + id;
        } catch (NumberFormatException e) {
         //   System.out.println(Long.valueOf(id));
            return "redirect:/api/classteacher/" + id;
        }


    }

    @GetMapping("/wys")
    public String showAllClassTeachers(Model model) {
        List<ClassTeacher> allClassTeachers = classTeacherService.getAllClassTeachers();
        model.addAttribute("classTeachers", allClassTeachers);
        return "showAllClassTeachers";
    }

@GetMapping("/teacher")
public String showForm(@RequestParam(required = false) String error, Model model) {
    model.addAttribute("error", error);
    return "teacherForm";
}

    @PostMapping("/teacher")
    public String handleForm(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        // Sprawdzanie, czy obiekt ClassTeacher o podanym ID istnieje
        if (classTeacherService.getClassTeacherById(id) != null) {
            return "redirect:/api/classteacher/teacher/" + id;
        } else {
            redirectAttributes.addAttribute("error", "InvalidClassTeacherId");
            return "redirect:/api/group/teacher";

        }
    }

    @GetMapping("/teacher/{id}")
    public String getTeachersForClass(@PathVariable Long id, Model model) {
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);

        if (classTeacher != null) {
            model.addAttribute("classTeacher", classTeacher);
            return "teachersForClass";
        } else {
            // Obsłuż sytuację, gdy obiekt ClassTeacher o danym ID nie istnieje
            return "redirect:/api/classteacher/teacher";
        }
    }
    @GetMapping("/fill/{id}")
    public String showFillPercentage(@PathVariable Long id, Model model) {
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);

        if (classTeacher != null) {
            double fillPercentage = classTeacherService.calculateFillPercentage(classTeacher);
            model.addAttribute("classTeacher", classTeacher);
            model.addAttribute("fillPercentage", fillPercentage);
            return "fillPercentage";
        } else {
            return "redirect:/error-page";
        }
    }
    @GetMapping("/fill")
    public String showfill(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "teacherfill";
    }

    @PostMapping("/fill")
    public String handleFormfill(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        // Sprawdzanie, czy obiekt ClassTeacher o podanym ID istnieje
        if (classTeacherService.getClassTeacherById(id) != null) {
            return "redirect:/api/classteacher/fill/" + id;
        } else {
            redirectAttributes.addAttribute("error", "InvalidClassTeacherId");
            return "redirect:/api/group/fill";

        }
    }


}