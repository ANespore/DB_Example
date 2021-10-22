package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {


    String ConnectionUrl = "jdbc:mysql://127.0.0.1:3306/shop";

    String user = "root";
    String pass = "prasTuf8";


   private static  Connection connection;

    public DBHandler() {

        try {
            connection = DriverManager.getConnection(ConnectionUrl, user, pass);


            System.out.println("Connection to db successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to db");
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
