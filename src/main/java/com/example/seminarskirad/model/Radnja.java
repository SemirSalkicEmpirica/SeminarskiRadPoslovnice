package com.example.seminarskirad.model;

import java.util.ArrayList;
import java.util.List;

public class Radnja {

    private Long id;
    private List<Napitci> napitci;
    private List<Hrana> hrane;
    private List<Odjeca> odjecas;
    private RadnjaLokacija radnjeLokacije;


    public Radnja(Long id, List<Napitci> napitci, List<Hrana> hrane, List<Odjeca> odjecas, RadnjaLokacija radnjeLokacije) {
        this.id = id;
        this.napitci = napitci;
        this.hrane = hrane;
        this.odjecas = odjecas;
        this.radnjeLokacije = radnjeLokacije;
    }

    public Radnja(){
        this.napitci = new ArrayList<>();
        this.hrane = new ArrayList<>();
        this.odjecas = new ArrayList<>();
    }

    public Radnja(Long id, RadnjaLokacija radnjeLokacije) {
        this.id = id;
        this.radnjeLokacije = radnjeLokacije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Napitci> getNapitci() {
        return napitci;
    }

    public void setNapitci(List<Napitci> napitci) {
        this.napitci = napitci;
    }

    public List<Hrana> getHrane() {
        return hrane;
    }

    public void setHrane(List<Hrana> hrane) {
        this.hrane = hrane;
    }

    public List<Odjeca> getOdjecas() {
        return odjecas;
    }

    public void setOdjecas(List<Odjeca> odjecas) {
        this.odjecas = odjecas;
    }

    public RadnjaLokacija getRadnjeLokacije() {
        return radnjeLokacije;
    }

    public void setRadnjeLokacije(RadnjaLokacija radnjeLokacije) {
        this.radnjeLokacije = radnjeLokacije;
    }
}
