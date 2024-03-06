package com.example.spring2;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ClassTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nazwa_grupy;
    Double liczba_nauczycieli;
    //@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    Set<Teacher> nauczyciele = new HashSet<>();

    public ClassTeacher(String nazwa_grupy, Double liczba_nauczycieli) {
      //  this.id = id;
        this.nazwa_grupy = nazwa_grupy;
        this.liczba_nauczycieli = liczba_nauczycieli;
    }

    public ClassTeacher() {

    }

    public Long getId() {
        return id;
    }

    public String getNazwa_grupy() {
        return nazwa_grupy;
    }

    public Double getLiczba_nauczycieli() {
        return liczba_nauczycieli;
    }

    public Set<Teacher> getNauczyciele() {
        return nauczyciele;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazwa_grupy(String nazwa_grupy) {
        this.nazwa_grupy = nazwa_grupy;
    }

    public void setLiczba_nauczycieli(Double liczba_nauczycieli) {
        this.liczba_nauczycieli = liczba_nauczycieli;
    }

    public void setNauczyciele(Set<Teacher> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }
}
