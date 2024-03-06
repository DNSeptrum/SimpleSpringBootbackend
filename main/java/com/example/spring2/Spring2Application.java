package com.example.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
/*
    ConfigurableApplicationContext context = SpringApplication.run(Spring2Application.class, args);
    Teacher teacher1 = new Teacher("Dawid", "Nieradka", TeacherCondition.Chory, 2002, 4000);
    TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
   // teacherRepository.save(teacher1);
     //   System.out.println("Zapisano w bazie");

   Optional<Teacher> teacher2 = teacherRepository.findById(2L);
        teacher2.ifPresentOrElse(
                obiekt -> {
                    System.out.println(teacher2.toString());
                },
                () -> {
                    System.out.println("Dany nauczyciel nie istnieje");
                }
        );*/
}
}
