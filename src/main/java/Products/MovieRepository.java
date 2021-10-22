package Products;

import Database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieRepository {

    DBHandler dbHandler = new DBHandler();

     public   void createTable () throws SQLException {

        String query = "Create table Movies (id int primary key not null auto_increment, title VARCHAR (255) not null, genre VARCHAR (255) not null,yearOfRelease int not null)";
        PreparedStatement preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void deleteTable()  throws SQLException{
        String query = "Drop table Movies";

        PreparedStatement preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();

    }

}
