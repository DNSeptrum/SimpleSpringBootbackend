package com.example.spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Teacherservice {

    static Teacher teacher;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }
       static Teacher zapisz(String imie, String nazwisko, String operator, int rok,double wynagrodzenie) {
            return switch (operator) {
                case "Obecny" -> teacher = new Teacher(imie,nazwisko,TeacherCondition.Obecny,rok,wynagrodzenie) ;
                case "Delegacja" -> teacher = new Teacher(imie,nazwisko,TeacherCondition.Delegacja,rok,wynagrodzenie);
                case "Chory" -> teacher = new Teacher(imie,nazwisko,TeacherCondition.Chory,rok,wynagrodzenie);
                case "Nieobecny" -> teacher = new Teacher(imie,nazwisko,TeacherCondition.Nieobecny,rok,wynagrodzenie);
                default -> throw new IllegalArgumentException("bląd");
            };
        }

}
