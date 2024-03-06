package com.example.spring2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String imie;

    String nazwisko;

    TeacherCondition teacherCondition;

    int rok_urodzenia;

    double wynagrodzenie;

    public Teacher(String imie, String nazwisko, TeacherCondition teacherCondition, int rok_urodzenia, double wynagrodzenie) {
       // this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.teacherCondition = teacherCondition;
        this.rok_urodzenia = rok_urodzenia;
        this.wynagrodzenie = wynagrodzenie;
    }

    public Teacher() {

    }
    @Override
    public String toString() {
        return "\n\nTeacher: \n"
                + "imie: " + this.imie + "\n"
                + "nazwisko: " + this.nazwisko + "\n" +
                "kondycja: " + this.teacherCondition + "\n" +
                "rok urodzenia: " + this.rok_urodzenia + "\n" +
                "wynagrodzenie: " + this.wynagrodzenie;
      //  System.out.println("imie: " + this.imie);
      //  System.out.println("nazwisko: " + this.nazwisko);
      //  System.out.println("kondycja: " + this.teacherCondition);
      //  System.out.println("rok urodzenia: " + this.rok_urodzenia);
      //  System.out.println("wynagrodzenie: " + this.wynagrodzenie);
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public TeacherCondition getTeacherCondition() {
        return teacherCondition;
    }

    public int getRok_urodzenia() {
        return rok_urodzenia;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }
}
