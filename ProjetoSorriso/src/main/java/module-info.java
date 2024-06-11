module com.example.projetosorriso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens com.example.projetosorriso to javafx.fxml;
    opens com.example.projetosorriso.models to java.base;
    exports com.example.projetosorriso;
    exports com.example.projetosorriso.controllers;
    exports com.example.projetosorriso.models;
    opens com.example.projetosorriso.controllers to javafx.fxml;
    exports com.example.projetosorriso.dao;
    opens com.example.projetosorriso.dao to javafx.fxml;
}