package com.example.spring2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.example.spring2.Teacher;
import com.example.spring2.TeacherRepository;
import com.example.spring2.Teacherservice;
import com.example.spring2.Teachercontroller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
class TeachercontrollerTest {

   // @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Teacherservice teacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    void testZapTeacher() throws Exception {
        // Przygotowanie danych testowych
        String imie = "John";
        String nazwisko = "Doe";
        String operator = "Obecny";
        int rok = 1990;
        double wynagrodzenie = 5000.0;

        // Symulacja działania serwisu
        when(Teacherservice.zapisz(imie, nazwisko, operator, rok, wynagrodzenie))
                .thenReturn(new Teacher(imie, nazwisko, TeacherCondition.Obecny, rok, wynagrodzenie));

        // Wywołanie kontrolera i sprawdzenie wyników
        mockMvc.perform(post("/api/teacher/addTeacher")
                        .param("imie", imie)
                        .param("nazwisko", nazwisko)
                        .param("operator", "TeacherCondition.Obecny")
                        .param("rok", String.valueOf(rok))
                        .param("wynagrodzenie", String.valueOf(wynagrodzenie)))
                .andExpect(status().isOk())
                .andExpect(content().string("nauczyciel zapisany do bazy"));

    }
    @Test
    void teacherlist() {
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void showTeacherForm() {
    }

    @Test
    void deleteTeacherForm() {
    }

    @Test
    void exportObjectsToCsv() {
    }
}