package com.example.spring2;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id", nullable = false)
    private Long id;

    int ocena;

    Date data;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    // @JoinColumn(name = "classa_id")
    ClassTeacher classa;

    String komentarz;

    public Rate(Long id, int ocena, Date data, ClassTeacher classa, String komentarz) {
        this.id = id;
        this.ocena = ocena;
        this.data = data;
        this.classa = classa;
        this.komentarz = komentarz;
    }

    public Rate() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setClassa(ClassTeacher classa) {
        this.classa = classa;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }
}