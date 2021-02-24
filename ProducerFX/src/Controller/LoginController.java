package Controller;

import JDBC.ConnectionFactory;
import Producer.Login;
import Producer.Main;
import Producer.RegisterScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField textFieldUser;
    @FXML private PasswordField textFieldPassword;
    @FXML private Button btnLogin;
    @FXML private Hyperlink hyperlinkRegisterUser;
    @FXML private Label loginMessageLabel;

    private Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginOnAction ( ActionEvent event){


        if(!textFieldUser.getText().isBlank() && !textFieldPassword.getText().isBlank()){
                validateLogin();
        }else {
            loginMessageLabel.setText("Favor inserir um usuário e senha!");
        }
    }
    public void registerOnAction (ActionEvent event){
        RegisterScreen registerScreen = new RegisterScreen();
        try {
            registerScreen.start(new Stage());
            fecha();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fecha() {
        Login.getPrimaryStage().close();

    }

    public void validateLogin() {
        this.connection = new ConnectionFactory().getConnection();
        Main main = new Main();

        String verifyLogin = "SELECT count(1) from user " +
                " where user_nickName = '" + textFieldUser.getText() +
                "'and user_password ='" + textFieldPassword.getText() +"';";


        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(verifyLogin);

            while (rs.next()){
                if (rs.getInt(1) ==1){
                    textFieldUser.setText("");
                    textFieldPassword.setText("");

                        fecha();
                        main.start(new Stage());

                }else {
                    loginMessageLabel.setText("Login inválido. Tente Novamente!");
                }
            }
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }

    }
}
