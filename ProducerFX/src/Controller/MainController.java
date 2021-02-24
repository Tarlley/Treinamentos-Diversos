package Controller;

import Producer.Main;
import Producer.RegisterProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML private Button btnRegisterProduction;
    @FXML private Button btnConsultProduction;
    @FXML private Button btnRegisterDistribution;
    @FXML private Button btnConsultDistribution;
    @FXML private Button btnReport;
    @FXML private Button btnExit;
    @FXML private Button btnRegisterProduct;
    @FXML private Button btnConsultProduct;



    public void onAction (ActionEvent event){
        RegisterProduct registerProduct = new RegisterProduct();
        try {
            registerProduct.start(new Stage());
            fecha();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    private void fecha() {
        Main.getPrimaryStage().close();
    }

}
