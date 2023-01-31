package com.example.seminarskirad.model;

import java.util.Date;

public class Napitci extends PrehrambeniProizvodi {

    private Tekucine tekucine;

    public Napitci(Long id, String ime, Date datumIsteka, Date datumProizvodnje, double cijena, int kolicina, Tekucine tekucine) {
        super(id, ime, datumIsteka, datumProizvodnje, cijena, kolicina);
        this.tekucine = tekucine;
    }

    public Napitci(String ime, Date datumIsteka, Date datumProizvodnje, double cijena, int kolicina, Tekucine tekucine) {
        super(ime, datumIsteka, datumProizvodnje, cijena, kolicina);
        this.tekucine = tekucine;
    }

    public Napitci(String ime, Tekucine tekucine) {
        super(ime);
        this.tekucine = tekucine;
    }

    public Napitci(String ime) {
        super(ime);
    }

    public Napitci(){}

    public Tekucine getTekucine() {
        return tekucine;
    }

    public void setTekucine(Tekucine tekucine) {
        this.tekucine = tekucine;
    }
}
