package com.example.seminarskirad.model;

public class Odjeca{

    private Long id;
    private String marka;
    private String boja;
    private String velicina;
    private String materijal;
    private String vrstaOdjece;
    private double cijena;
    private int kolicina;
    private String mjestoPorijekla;

    public Odjeca() {
        super();
    }

    public Odjeca(Long id, String marka, String boja, String velicina, String materijal, String vrstaOdjece, double cijena, int kolicina, String mjestoPorijekla) {
        this.id = id;
        this.marka = marka;
        this.boja = boja;
        this.velicina = velicina;
        this.materijal = materijal;
        this.vrstaOdjece = vrstaOdjece;
        this.cijena = cijena;
        this.kolicina = kolicina;
        this.mjestoPorijekla = mjestoPorijekla;
    }

    public Odjeca(String marka) {
        this.marka = marka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getMaterijal() {
        return materijal;
    }

    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }

    public String getVrstaOdjece() {
        return vrstaOdjece;
    }

    public void setVrstaOdjece(String vrstaOdjece) {
        this.vrstaOdjece = vrstaOdjece;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getMjestoPorijekla() {
        return mjestoPorijekla;
    }

    public void setMjestoPorijekla(String mjestoPorijekla) {
        this.mjestoPorijekla = mjestoPorijekla;
    }
}
