package Controller;

import DAO.ProductDao;
import Model.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class RegisterProductController implements Initializable {

    @FXML private TextField textfielProductName;
    @FXML private TextField textfieldProductAmount;
    @FXML private TextArea textareaProductNote;
    @FXML private Button btnRegisterProduct;

    private Connection connection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textfieldProductAmount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    textfieldProductAmount.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });
    }

    public void register(ActionEvent event){
        Product product = new Product();
        ProductDao productDao = new ProductDao();

        product.setProductName(textfielProductName.getText());
        product.setProductAmout(Double.parseDouble(textfieldProductAmount.getText()));
        product.setProductNote(textareaProductNote.getText());
    }



}
