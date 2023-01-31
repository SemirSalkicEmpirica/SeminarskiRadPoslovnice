module seminarskirad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.seminarskirad to javafx.fxml;
    exports com.example.seminarskirad;
    exports com.example.seminarskirad.controler;
    opens com.example.seminarskirad.controler to javafx.fxml;
    opens com.example.seminarskirad.model to javafx.base;
}