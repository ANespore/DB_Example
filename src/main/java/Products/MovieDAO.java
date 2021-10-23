package Products;

import java.sql.SQLException;


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
    
    public String createMovie(Movie movie){
        try{
            movieRepository.create(movie);
            return "Movie created successfully.";
        }catch (SQLException e){
            e.printStackTrace();
            return "Error creating movie!";
        }

    }

    public void updateMovie(Movie movie){
        try{
            movieRepository.update(movie);
            System.out.println("Movie updated successfully");

        }catch (SQLException e){
            System.out.println(e);
        }

    }


    public Movie findMovie(int id){

        try{
            return movieRepository.findMovie(id);

        }catch (SQLException e){
            System.out.println("Cannot find movie with id:" + id);
            e.printStackTrace();
            return null;
        }

    }

        public void deleteMovie(int id){
        try{
            movieRepository.delete(id);
            System.out.println("Movie deleted successfully.");

        }catch (SQLException e){
            System.out.println(e);
        }
    }

        public ArrayList<Movie> getAllMovies(){
        try{
            return movieRepository.getAll();
        }catch(SQLException e){
        e.printStackTrace();
        return null;
        }
    }

}
