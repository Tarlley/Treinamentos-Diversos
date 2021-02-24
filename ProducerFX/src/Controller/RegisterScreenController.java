package Controller;

import DAO.UserDao;
import JDBC.ConnectionFactory;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterScreenController {

    @FXML private TextField textName;
    @FXML private TextField textNickname;
    @FXML private TextField textEmail;
    @FXML private PasswordField textPassword;
    @FXML private PasswordField textPasswordConfirmation;
    @FXML private Label labelPasswordAlert;
    @FXML private Label labelUserAlert;

    private Connection connection;


    public void registerOnAction(ActionEvent event){

        User user = new User();
        UserDao userDao = new UserDao();

        user.setName(textName.getText());
        user.setNickName(textNickname.getText());
        user.setEmail(textEmail.getText());
        user.setPassword(textPassword.getText());



    }
    public void onKeyTyped() {
        validateNickname();
        if (!textPassword.getText().equals(textPasswordConfirmation.getText())) {
            labelPasswordAlert.setText("As senhas não são iguais");
        }else {
            labelPasswordAlert.setText("");
        }

    }

    public void validateNickname(){
        this.connection = new ConnectionFactory().getConnection();

        String verifyNickname = "SELECT count(1) from user " +
                " where user_nickName = '" + textNickname.getText() + "';";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(verifyNickname);

            while (rs.next()){
                 if (rs.getInt(1)==1){
                     labelUserAlert.setText("Usuário já existe");
                 }else{
                     labelUserAlert.setText("");

                 }
            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
