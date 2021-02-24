package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sample.model.Categoria;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private ComboBox<Categoria> comboBox;


    private List<Categoria> categorias = new ArrayList<>();
    private ObservableList<Categoria> obsCategorias;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarCategorias();
    }

    public void carregarCategorias(){
        Categoria categoria1 = new Categoria(1,"Bebidas");
        Categoria categoria2 = new Categoria(3,"comidas");

        categorias.add(categoria1);
        categorias.add(categoria2);

        obsCategorias = FXCollections.observableArrayList(categorias);


        comboBox.setItems(obsCategorias);
    }
}
