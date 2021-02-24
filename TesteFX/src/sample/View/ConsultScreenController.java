package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Production;
import sample.SQL.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConsultScreenController implements Initializable {

    @FXML
    private TableView<Production> table;

    @FXML
    private TableColumn<Production, String> columnName;

    @FXML
    private TableColumn<Production, Integer> columnAmount;

    @FXML
    private TableColumn<Production, Date> columnDate;

    @FXML
    private TableColumn<Production, String> columnNote;

    @FXML
    private Button btnConsultar;


    public void initTable() {
            TableColumn<Production,String> columnName1 = new TableColumn<Production,String>("Nome Produto");
            columnName1.setCellValueFactory(new PropertyValueFactory<Production,String>("productName"));
            columnName.setCellValueFactory(new PropertyValueFactory<Production,String>("productName"));

            /* columnName.setCellValueFactory(new PropertyValueFactory<Production,String>());
        columnAmount.setCellValueFactory(new PropertyValueFactory<>("productionAmount"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("productionDate"));
        columnNote.setCellValueFactory(new PropertyValueFactory<>("productNote"));
        */
        table.setItems(atualizaTabela());
    }

    public ObservableList atualizaTabela() {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ArrayList stringList = new ArrayList();

        String query = "select * from production;";
        try {

            PreparedStatement preparedStatement = connectDB.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                stringList.add(resultSet.getString(1));
            }
            preparedStatement.close();
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(stringList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }
}
