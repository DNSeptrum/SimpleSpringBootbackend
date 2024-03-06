package com.example.spring2;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.spring2.ClassTeacher;
import com.example.spring2.GroupRepository;
import com.example.spring2.ClassTeacherService;
import com.example.spring2.ClassTeachercontroller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
class ClassTeachercontrollerTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public ClassTeacherService classTeacherService() {
            return new ClassTeacherService();
        }
    }

    // @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassTeacherService classTeacherService;

    @MockBean
    private GroupRepository classTeacherRepository;
    @Test
    void testZapClassTeacher() throws Exception {
        // Przygotowanie danych testowych
        String nazwa = "Klasa A";
        double liczbaNauczycieli = 3.0;

        // Symulacja działania serwisu
        when(ClassTeacherService.zapisz(nazwa, liczbaNauczycieli))
                .thenReturn(new ClassTeacher(nazwa, liczbaNauczycieli));

        // Wywołanie kontrolera i sprawdzenie wyników
        mockMvc.perform(post("/api/classteacher/addclassTeacher")
                        .param("nazwa", nazwa)
                        .param("liczba_na", String.valueOf(liczbaNauczycieli)))
                .andExpect(status().isOk())
                .andExpect(content().string("klasa zapisany do bazy"));

        // Sprawdzenie, czy metoda repo.save() została wywołana
        // Możesz dostosować to sprawdzenie w zależności od tego, jak dokładnie działa Twoja metoda
        // (np. jeśli metoda zapisz() korzysta z repo.save(), to sprawdzenie repo.save() jest sensowne)
        // when(classTeacherRepository.save(any(ClassTeacher.class))).thenAnswer(invocation -> invocation.getArgument(0));
        // verify(classTeacherRepository, times(1)).save(any(ClassTeacher.class));
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void showTeacherForm() {
    }

    @Test
    void deleteclassTeacherForm() {
    }

    @Test
    void showClassTeacherForm() {
    }

    @Test
    void showClassTeacherFormser() {
    }

    @Test
    void addTeacherToClass() {
    }

    @Test
    void showAllClassTeachers() {
    }

    @Test
    void showForm() {
    }

    @Test
    void handleForm() {
    }

    @Test
    void getTeachersForClass() {
    }

    @Test
    void showFillPercentage() {
    }

    @Test
    void showfill() {
    }

    @Test
    void handleFormfill() {
    }
}