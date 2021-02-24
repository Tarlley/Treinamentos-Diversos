module ProducerFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;
    opens Controller;
  //  opens DAO;
  //  opens Images;
  //  opens Model;
    opens Producer;
    opens View;
}