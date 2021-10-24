package Products;

import java.sql.SQLException;
import java.util.ArrayList;


public class MovieDAO {

    MovieRepository movieRepository = new MovieRepository();


    public  String createTable() {

        try {
            movieRepository.createTable();
            return "Table created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating table!";

        }


    }


    public  String deleteTable() {

        try {
            movieRepository.deleteTable();
            return "Table deleted successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting table!";

        }


    }


    public String createMovie(final Movie movie) {

        try {
            movieRepository.createMovie(movie);
            return "Movie created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating movie!";

        }


    }


    public void   deleteMovie(int id) {
        try {

            movieRepository.deleteMovie(id);
            System.out.println("Movie deleted successfully");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public String   updateMoviesTitle(int id, String newTitle) {
        try {

            movieRepository.updateMoviesTitle(id,newTitle);
          return  "Movie title updated successfully";
        } catch (SQLException e) {
            System.out.println(e);
            return  "Can't update movie title";

        }
    }

    public Movie findMovieById(int id) {
        try {

            return movieRepository.findMovieById(id);
        } catch (SQLException e) {
            System.out.println("Cannot retrieve movie from database");
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<Movie> findAll() {
        try {
            return movieRepository.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}