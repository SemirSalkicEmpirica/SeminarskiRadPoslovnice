package com.example.seminarskirad.model;

import java.util.Date;

public class Hrana extends PrehrambeniProizvodi {

    private String proizvodjac;
    private boolean domace;

    public Hrana(Long id, String ime, Date datumIsteka, Date datumProizvodnje, double cijena, int kolicina, String proizvodjac, boolean domace) {
        super(id, ime, datumIsteka, datumProizvodnje, cijena, kolicina); // Koristimo u OOP da bi proslijedili podatke u "Parent" klasu
        this.proizvodjac = proizvodjac;
        this.domace = domace;
    }

    public Hrana(String proizvodjac, boolean domace) { // Konstruktor sa dva parametra
        this.proizvodjac = proizvodjac;
        this.domace = domace;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public boolean isDomace() {
        return domace;
    }

    public void setDomace(boolean domace) {
        this.domace = domace;
    }
}
