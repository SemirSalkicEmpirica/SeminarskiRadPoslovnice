package com.example.seminarskirad.baza;

import com.example.seminarskirad.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Konekcija sa bazom i pristup podacnima
public class Database {
    private String url = "jdbc:mysql://localhost:3306/poslovnice?verifyServerCertificate=false&useSSL=true";
    private String root = "root";
    private String password = "newSQLTestPassword12!";
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

// Konstruktor koji pokrece konekciju kad se inicializira klasa
    public Database() {
        try  {
            connection = DriverManager.getConnection(url, root, password);
        }catch (SQLException e) {
            System.out.println(e.getMessage()); // Ispis greske
        }
    }

    public List<Napitci> dohvatiSveNapitke(Long id) {
        // Selektuj podatke iz tabele Radnja, inner join sa tabelom Napitci
        // gdje je id od napitka iz tabele Radnja jednak id napitku iz Tabele Napitci i gdje je lokacija jednaka 'varijabli'
        String query = " SELECT n.id, n.ime, n.datum_isteka, n.datum_proizvodnje, n.cijena, n.kolicina, n.vrsta_tekucine FROM " +
                " radnja inner join napitci as n on radnja.fk_napitci = n.id where fk_radnja_lokacija = ?";
        List<Napitci> napitci = new ArrayList<>();
        try {
            ps = connection.prepareCall(query); // Priprema query
            ps.setLong(1, id); // Mijenja upitnik sa parametrom id
            rs = ps.executeQuery(); // Pokrece query

            while (rs.next()) {
                napitci.add(new Napitci(rs.getLong(1), rs.getString(2), rs.getDate(3),
                        rs.getDate(4), rs.getInt(5), rs.getInt(6),
                        Tekucine.valueOf(rs.getString(7))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return napitci;
    }

    public List<Hrana> dohvatiSveHrane(Long id) {
        String query = "SELECT h.id, h.ime,  h.datum_isteka, h.datum_proizvodnje,h.cijena, h.kolicina,  h.proizvodjac, h.domace " +
                " FROM radnja as r inner join hrana as h on r.fk_hrana = h.id WHERE r.fk_radnja_lokacija = ?";
        List<Hrana> hrana = new ArrayList<>();

        try {
            ps = connection.prepareCall(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                hrana.add(
                        new Hrana(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
                        rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hrana;
    }

    public List<Odjeca> dohvatiSvuOdjecu(Long id) {
        String query = "SELECT o.id, o.marka, o.boja, o.velicina, o.materijal, o.vrsta_odjece, o.cijena, o.kolicina, o.mjesto_porijekla FROM " +
                " radnja as r inner join odjeca as o on r.fk_odjeca = o.id where fk_radnja_lokacija = ?";
        List<Odjeca> odjeca = new ArrayList<>();

        try {
            ps = connection.prepareCall(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                odjeca.add(
                        new Odjeca(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9) )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return odjeca;
    }

    public List<RadnjaLokacija> dohvatiImenaRadnji() {
        String query = "SELECT * FROM radnja_lokacija";
        List<RadnjaLokacija> radnjaSet = new ArrayList<>();

        try {

            ps = connection.prepareCall(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                radnjaSet.add(new RadnjaLokacija(rs.getLong(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return radnjaSet;
    }


}
