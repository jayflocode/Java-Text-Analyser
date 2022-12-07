module com.example.projectfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.projectfinal to javafx.fxml;
    exports com.example.projectfinal;
}