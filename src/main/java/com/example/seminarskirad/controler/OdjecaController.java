package com.example.seminarskirad.controler;

import com.example.seminarskirad.baza.Database;
import com.example.seminarskirad.model.Odjeca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OdjecaController implements Initializable {

    @FXML
    private TableView<Odjeca> dtProizvodi;

    @FXML
    private TableColumn<Odjeca, Long> id;

    @FXML
    private TableColumn<Odjeca, String> marka;

    @FXML
    private TableColumn<Odjeca, String> boja;

    @FXML
    private TableColumn<Odjeca, String> velicina;

    @FXML
    private TableColumn<Odjeca, String> materijal;

    @FXML
    private TableColumn<Odjeca, String> vrstaOdjece;

    @FXML
    private TableColumn<Odjeca, Double> cijena;

    @FXML
    private TableColumn<Odjeca, Integer> kolicina;

    @FXML
    private TableColumn<Odjeca, String> mjestoPorijekla;

    @FXML
    private TextField poljeZaFiltriranje;

    @FXML
    private Button closeButton;

    private ObservableList<Odjeca> filtriraniPodaci = FXCollections.observableArrayList();

    private Database database = new Database();

    @FXML
    private Label lbl_ime_poslovnice;


    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        boja.setCellValueFactory(new PropertyValueFactory<>("boja"));
        cijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        vrstaOdjece.setCellValueFactory(new PropertyValueFactory<>("vrstaOdjece"));
        kolicina.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        mjestoPorijekla.setCellValueFactory(new PropertyValueFactory<>("mjestoPorijekla"));
        velicina.setCellValueFactory(new PropertyValueFactory<>("velicina"));
        materijal.setCellValueFactory(new PropertyValueFactory<>("materijal"));
        dtProizvodi.setItems(unosPodatakaZaOdjecu);
        filtriraniPodaci.addAll(unosPodatakaZaOdjecu);
        lbl_ime_poslovnice.setText(RadnjaController.imeTrenutnoSelektovanogObjekta);
        dtProizvodi.setItems(filtriraniPodaci);
        poljeZaFiltriranje.textProperty().addListener((observable, oldValue, newValue) -> updateFilteredData());
    }


    private ObservableList<Odjeca> unosPodatakaZaOdjecu = FXCollections.observableArrayList(
            this.database.dohvatiSvuOdjecu(RadnjaController.trenutnoSelektovaniObjekat)
    );

    private void updateFilteredData() {
        filtriraniPodaci.clear();

        for (Odjeca n : unosPodatakaZaOdjecu) {
            if (matchesFilter(n)) {
                filtriraniPodaci.add(n);
            }
        }

        reapplyTableSortOrder();
    }

    private boolean matchesFilter(Odjeca odjeca) {
        String filterString = poljeZaFiltriranje.getText();
        if (filterString == null || filterString.isEmpty()) {
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        return odjeca.getMarka().toLowerCase().contains(lowerCaseFilterString) || odjeca.getId().toString().contains(lowerCaseFilterString);
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Odjeca, ?>> sortOrder = new ArrayList<>(dtProizvodi.getSortOrder());
        dtProizvodi.getSortOrder().clear();
        dtProizvodi.getSortOrder().addAll(sortOrder);
    }


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
