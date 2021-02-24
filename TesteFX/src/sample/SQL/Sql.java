package sample.SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class Sql {


    public void executeInsertion(String productName, String productionNote, Date productionDate, int productionAmount){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String queryUpdate = "insert into production (productName,productionNote,productionDate,productionAmount) values ('"+ productName +"','" + productionNote +"','"+ productionDate + "','" + productionAmount +"')";

        try {

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(queryUpdate);

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();

        }
    }
}
