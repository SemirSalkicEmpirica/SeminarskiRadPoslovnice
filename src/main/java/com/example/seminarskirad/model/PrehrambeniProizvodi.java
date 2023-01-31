package com.example.seminarskirad.model;

import java.util.Date;

public class PrehrambeniProizvodi {

    private Long id;
    private String ime;
    private Date datumIsteka;
    private Date datumProizvodnje;
    private double cijena;
    private int kolicina;

    public PrehrambeniProizvodi(Long id, String ime, Date datumIsteka, Date datumProizvodnje, double cijena, int kolicina) {
        this.id = id;
        this.ime = ime;
        this.datumIsteka = datumIsteka;
        this.datumProizvodnje = datumProizvodnje;
        this.cijena = cijena;
        this.kolicina = kolicina;
    }

    public PrehrambeniProizvodi(String ime, Date datumIsteka, Date datumProizvodnje, double cijena, int kolicina) {
        this.ime = ime;
        this.datumIsteka = datumIsteka;
        this.datumProizvodnje = datumProizvodnje;
        this.cijena = cijena;
        this.kolicina = kolicina;
    }

    public PrehrambeniProizvodi(String ime) {
        this.ime = ime;
    }

    public PrehrambeniProizvodi(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(Date datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
