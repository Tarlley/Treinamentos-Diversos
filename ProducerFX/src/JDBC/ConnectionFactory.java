package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "producao";
        String databaseUser = "root";
        String databasePassword = "123456";
        String serverAddress = "localhost:3306/";
        String url = "jdbc:mysql://"+serverAddress+databaseName+ "?autoReconnect=true&useSSL=false";
try {
    Class.forName("com.mysql.jdbc.Driver");
    databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
}catch (Exception e){
    e.printStackTrace();
    e.getCause();
}

        return databaseLink;
    }
}
