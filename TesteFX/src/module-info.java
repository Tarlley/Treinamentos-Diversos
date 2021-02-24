module TesteFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;
    opens sample;
opens sample.SQL;
opens sample.View;
}