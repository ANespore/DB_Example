package Products;

import Database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieRepository {

    DBHandler dbHandler = new DBHandler();

   static  public   void createTable () throws SQLException {
       DBHandler dbHandler = new DBHandler();
        String query = "Create table Movies (id int primary key not null auto_increment, title VARCHAR (255) not null, genre VARCHAR (255) not null,yearOfRelease int not null)";
        PreparedStatement preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
    }

   static public void deleteTable()  throws SQLException{
        String query = "Drop table Movies";
       DBHandler dbHandler = new DBHandler();
        PreparedStatement preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();

    }

}
