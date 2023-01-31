package com.example.seminarskirad.controler;

import com.example.seminarskirad.baza.Database;
import com.example.seminarskirad.model.Napitci;
import com.example.seminarskirad.model.Tekucine;
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

public class NapitciController implements Initializable {

    @FXML
    private TableView<Napitci> dtProizvodi;

    @FXML
    private TableColumn<Napitci, Long> id;

    @FXML
    private TableColumn<Napitci, String> ime;

    @FXML
    private TableColumn<Napitci, Tekucine> tekucine;

    @FXML
    private TableColumn<Napitci, Date> datumIsteka;

    @FXML
    private TableColumn<Napitci, Date> datumProizvodnje;

    @FXML
    private TableColumn<Napitci, Double> cijena;

    @FXML
    private TableColumn<Napitci, Integer> kolicina;

    @FXML
    private TextField poljeZaFiltriranje;

    @FXML
    private Button closeButton;

    private ObservableList<Napitci> filtriraniPodaci = FXCollections.observableArrayList();

    private Database database = new Database();

    @FXML
    private Label lbl_ime_poslovnice;


    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tekucine.setCellValueFactory(new PropertyValueFactory<>("tekucine"));
        cijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        datumIsteka.setCellValueFactory(new PropertyValueFactory<>("datumIsteka"));
        datumProizvodnje.setCellValueFactory(new PropertyValueFactory<>("datumProizvodnje"));
        dtProizvodi.setItems(unosPodatakaZaNapitke);
        filtriraniPodaci.addAll(unosPodatakaZaNapitke);
        lbl_ime_poslovnice.setText(RadnjaController.imeTrenutnoSelektovanogObjekta);

        dtProizvodi.setItems(filtriraniPodaci);
        poljeZaFiltriranje.textProperty().addListener((observable, oldValue, newValue) -> updateFilteredData());
    }


    private ObservableList<Napitci> unosPodatakaZaNapitke = FXCollections.observableArrayList(
                this.database.dohvatiSveNapitke(RadnjaController.trenutnoSelektovaniObjekat)
            );

    private void updateFilteredData() {
        filtriraniPodaci.clear();

        for (Napitci n : unosPodatakaZaNapitke) {
            if (matchesFilter(n)) {
                filtriraniPodaci.add(n);
            }
        }

        reapplyTableSortOrder();
    }

    private boolean matchesFilter(Napitci napitci) {
        String filterString = poljeZaFiltriranje.getText();
        if (filterString == null || filterString.isEmpty()) {
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        return napitci.getIme().toLowerCase().contains(lowerCaseFilterString) || napitci.getId().toString().contains(lowerCaseFilterString);
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Napitci, ?>> sortOrder = new ArrayList<>(dtProizvodi.getSortOrder());
        dtProizvodi.getSortOrder().clear();
        dtProizvodi.getSortOrder().addAll(sortOrder);
    }


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
