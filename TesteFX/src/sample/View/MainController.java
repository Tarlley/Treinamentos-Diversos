package sample.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import static sample.Main.changeScreen;



public class MainController {


    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuProducao;
    @FXML
    private MenuItem sair;
    @FXML
    private MenuItem cadastrarProducao;
    @FXML
    private MenuItem consultarProducao;
    @FXML
    private Menu menuDistribuicao;
    @FXML
    private MenuItem cadastrarDistribuicao;
    @FXML
    private MenuItem consultarDistribuicao;


    public void menuItemOnAction(ActionEvent event) {
        changeScreen("registerScreenProduction");

    }

    public void menuItemOnActionRegister(ActionEvent event) {
        changeScreen("consultScreen");
    }

    public void sair(ActionEvent event) {
        changeScreen("login");
    }
}
