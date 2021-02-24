package sample.View;
import sample.SQL.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

import static sample.Main.changeScreen;

public class LoginController implements Initializable {
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File brandingFile = new File("Imagem/austin-228x400.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("Imagem/baixados.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);



    }

    public void loginButtonOnAction(ActionEvent event) {
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            loginMessageLabel.setText("You try to login");
            validateLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password!");
        }
        
    }

    private void mainScreen(){
    }

    private void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) from user_account" +
                " where username = '" + usernameTextField.getText() +
                "' and password = '"
                + enterPasswordField.getText() +"';";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1 ){
                    loginMessageLabel.setText("Parabens!");
                    changeScreen("main_screen");
                    enterPasswordField.setText("");
                    usernameTextField.setText("");
                }else {
                    loginMessageLabel.setText("Login inválido. Tente novamente!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage =(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



}
