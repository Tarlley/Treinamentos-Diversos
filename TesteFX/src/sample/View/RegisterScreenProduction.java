package sample.View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.Production;
import sample.SQL.DatabaseConnection;

import javax.swing.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import sample.SQL.DatabaseConnection;
import static sample.Main.changeScreen;

public class RegisterScreenProduction extends JTextField implements Initializable {
    Production production = new Production();


    @FXML
    private TextField amountField;
    @FXML
    DatePicker datePicker;
    @FXML
    TextArea noteField;
    @FXML
    Button insertButton;
    @FXML
    Button cancelButton;
    @FXML
    Label resultLabel;
    @FXML
    ComboBox<String> productNameField;
    @FXML
    ObservableList<String> stringList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "select productName from production;";
    try {

        PreparedStatement preparedStatement = connectDB.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            stringList.add(resultSet.getString("productName"));
        }
        preparedStatement.close();
    }catch (Exception e){
        e.getCause();
        e.printStackTrace();
    }

        productNameField.setItems(stringList);

    amountField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
            if (!newValue.matches("\\d*")) {
                amountField.setText(newValue.replaceAll("[^\\d]",""));
            }
        }
    });


    }



    public void insertButtonOnAction(ActionEvent event){

       // while(productNameField.getValue().equals("") || amountField.getText().equals("")){

            if (productNameField.getValue().equals("") || amountField.getText().equals("")) {
                resultLabel.setText("Favor inserir dados nos campos obrigatórios!!");
            }else {
                Production production = new Production();
                production.setProductName(productNameField.getValue());
                production.setProductionAmount(Integer.parseInt(amountField.getText()));
                production.setProductionDate(datePicker.getValue());
                production.setProductNote(noteField.getText());

                production.setQuery();
            }
     //   }


    }

    public void  sair(ActionEvent event) {
        changeScreen("main_screen");
        productNameField.setSelectionModel(null);
        amountField.setText("");
        datePicker.getEditor().clear();
        noteField.setText("");
    }
}
