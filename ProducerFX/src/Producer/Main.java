package Producer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/main.fxml")); //Carrega o arquivo fxml para o Parent root
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle("Tela Principal"); //Define o Nome da Cena
        primaryStage.setScene(scene);
        primaryStage.show();
        setPrimaryStage(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);

    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }
}
