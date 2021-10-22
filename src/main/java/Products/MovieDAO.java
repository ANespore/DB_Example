package Products;

import java.sql.SQLException;


public class MovieDAO {

    MovieRepository movieRepository = new MovieRepository();


    public  String createTable() {

        try {
            MovieRepository.createTable();
            return "Table created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating table!";

        }


    }


    public  String deleteTable() {

        try {
            MovieRepository.deleteTable();
            return "Table deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting table!";

        }


    }
}