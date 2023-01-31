package com.example.seminarskirad.controler;

import com.example.seminarskirad.baza.Database;
import com.example.seminarskirad.model.Hrana;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class HranaController implements Initializable {

    @FXML
    private TextField poljeZaFiltriranje;

    @FXML
    private TableView<Hrana> dtProizvodi;

    @FXML
    private TableColumn<Hrana, Long> id;

    @FXML
    private TableColumn<Hrana, String> ime;

    @FXML
    private TableColumn<Hrana, Date> datumIsteka;

    @FXML
    private TableColumn<Hrana, Date> datumProizvodnje;

    @FXML
    private TableColumn<Hrana, Double> cijena;

    @FXML
    private TableColumn<Hrana, Integer> kolicina;

    @FXML
    private TableColumn<Hrana, Boolean> domace;

    @FXML
    private TableColumn<Hrana, String> proizvodjac;

    @FXML
    private Button closeButton;

    @FXML
    private Label lbl_ime_poslovnice;

    private Database database = new Database(); // Poziva bazu

    private ObservableList<Hrana> filtriraniPodaci = FXCollections.observableArrayList(); // Inicializira listu

    private ObservableList<Hrana> unosPodatakaZaHranu = FXCollections.observableArrayList(
            this.database.dohvatiSveHrane(RadnjaController.trenutnoSelektovaniObjekat)
            // Popunjava listu sa podacima iz baze
    );

    private void updateFilteredData() {
        filtriraniPodaci.clear(); // Čisti se lista

        for (Hrana n : unosPodatakaZaHranu) {
            if (matchesFilter(n)) {
                filtriraniPodaci.add(n); // Za svaku hranu iz podataka ako zadovoljava matchesFilter dodaje u listu
            }
        }

        reapplyTableSortOrder();
    }

    private boolean matchesFilter(Hrana hrana) {
        String filterString = poljeZaFiltriranje.getText();
        if (filterString == null || filterString.isEmpty()) {
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        return hrana.getIme().toLowerCase().contains(lowerCaseFilterString) || hrana.getId().toString().contains(lowerCaseFilterString);
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Hrana, ?>> sortOrder = new ArrayList<>(dtProizvodi.getSortOrder());
        dtProizvodi.getSortOrder().clear(); // Brise stare podatke iz liste
        dtProizvodi.getSortOrder().addAll(sortOrder); // Dodaje nove sortirane podatke u listu za prikaz
    }


    public void initialize(URL location, ResourceBundle resources) {
        // Inicializira tabelu i imena celija
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        datumIsteka.setCellValueFactory(new PropertyValueFactory<>("datumIsteka"));
        datumProizvodnje.setCellValueFactory(new PropertyValueFactory<>("datumProizvodnje"));
        cijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        proizvodjac.setCellValueFactory(new PropertyValueFactory<>("proizvodjac"));
        domace.setCellValueFactory(new PropertyValueFactory<>("domace"));

        lbl_ime_poslovnice.setText(RadnjaController.imeTrenutnoSelektovanogObjekta); // Popunjava tabelu sa podacima
        dtProizvodi.setItems(unosPodatakaZaHranu);
        filtriraniPodaci.addAll(unosPodatakaZaHranu);

        dtProizvodi.setItems(filtriraniPodaci); // Omogucava filtriranje podataka
        poljeZaFiltriranje.textProperty().addListener((observable, oldValue, newValue) -> updateFilteredData());
    }


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
