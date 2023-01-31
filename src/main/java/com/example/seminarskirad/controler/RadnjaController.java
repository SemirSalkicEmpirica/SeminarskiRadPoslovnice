package com.example.seminarskirad.controler;

import com.example.seminarskirad.baza.Database;
import com.example.seminarskirad.model.Radnja;
import com.example.seminarskirad.model.RadnjaLokacija;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class RadnjaController implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    TableView<RadnjaLokacija> dt_poslovnice;

    @FXML
    private TableColumn<Radnja, Long> id;

    @FXML
    private TableColumn<RadnjaLokacija, String> radnje;

    @FXML
    private TableColumn<RadnjaLokacija, String> lokacija;

    @FXML
    private ComboBox<String> radnjaComboBox;

    public static Long trenutnoSelektovaniObjekat;
    public static String imeTrenutnoSelektovanogObjekta;
    private Database database = new Database();

    private ObservableList<String> pripremiPodatkeZaProizvode = FXCollections.observableArrayList(
        Arrays.asList("Odjeca", "Hrana", "Napitci")
    );

    private ObservableList<RadnjaLokacija> gradoviRadnje = FXCollections.observableArrayList(
        this.database.dohvatiImenaRadnji()
    );

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void openButtonAction() throws IOException { // Otvara odredjeni prozor u zavisnosti od dropDown liste
        prozor(radnjaComboBox.getSelectionModel().getSelectedItem());
    }

    private void prozor(String ime) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/seminarskirad/"+ime.trim().toLowerCase()+".fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Poslovnica");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // za tableview
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lokacija.setCellValueFactory(new PropertyValueFactory<>("grad"));
        radnje.setCellValueFactory(new PropertyValueFactory<>("imeObjekta"));

        radnjaComboBox.setItems(pripremiPodatkeZaProizvode);
        dt_poslovnice.setItems(gradoviRadnje);
        radnjaComboBox.getSelectionModel().selectFirst();

        dt_poslovnice.getSelectionModel().selectedItemProperty().addListener((observableValue, radnja, t1) -> {
            trenutnoSelektovaniObjekat = t1.getId();
            imeTrenutnoSelektovanogObjekta = t1.getImeObjekta();
        }); // Dodaje id i ime selektovanog objekta u ove varijable
        dt_poslovnice.getSelectionModel().selectFirst(); // selektuje prvu poslvnicu
    }
}
