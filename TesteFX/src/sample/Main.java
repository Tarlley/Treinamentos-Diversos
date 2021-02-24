package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    private static Stage stage;

    private static Scene loginScene;
    private static Scene mainScene;
    private static Scene registerScreenProduction;
    private static Scene consultScreen;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("View/login.fxml"));
        loginScene = new Scene(fxmlLogin,520,400);


        Parent fxmlMainScreen = FXMLLoader.load(getClass().getResource("View/main_screen.fxml"));
        mainScene = new Scene(fxmlMainScreen,520,400);

        Parent fxmlRegisterScreenProduction = FXMLLoader.load(getClass().getResource("View/registerScreenProduction.fxml"));
        registerScreenProduction = new Scene(fxmlRegisterScreenProduction,520,400);

        Parent fxmlConsultScreen = FXMLLoader.load(getClass().getResource("View/consultScreen.fxml"));
        consultScreen = new Scene(fxmlConsultScreen,520,400);
        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "login":
                stage.setScene(loginScene);
                break;
            case "main_screen":
                stage.setScene(mainScene);
                break;
            case "registerScreenProduction":
                stage.setScene(registerScreenProduction);
                break;
            case "consultScreen":
                stage.setScene(consultScreen);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
