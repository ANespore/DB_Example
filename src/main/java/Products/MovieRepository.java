package Products;

import Database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public void create (Movie movie) throws SQLException{
    String query = "INSERT INTO movies (title, genre, year_of_release) VALUES (?,?,?)";


        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3, movie.yearOfRelease);

        preparedStatement.execute();
        preparedStatement.close();

    }

    public void update(Movie movie) throws SQLException{

        String query = "UPDATE movies SET title=?, genre=?, year_of_release=? WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3, movie.yearOfRelease);
        preparedStatement.setInt(4, movie.id);

        preparedStatement.execute();
        preparedStatement.close();

    }

    public Movie findMovie(int id) throws SQLException{
    String query = "SELECT * FROM movies WHERE id= " + id;

    Statement statement =dbHandler.getConnection().createStatement();
    ResultSet result = statement.executeQuery(query);

    if(result.next()){
        int movie_id = result.getInt("id");
        String movie_title = result.getString("title");
        String genre = result.getString("genre");
        int year_of_release = result.getInt("year_of_release");

        Movie movie = new Movie(movie_title, genre, year_of_release);

        movie.id =movie_id;
        statement.close();
        return movie;

    }else{
        return null;
    }
    }

    public void delete(int id) throws SQLException{

        String query = "DELETE FROM movies WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        preparedStatement.close();
    }

     public ArrayList<Movie> getAll() throws SQLException{
        String query = "SELECT * FROM movies";

        Statement statement = dbHandler.getConnection().createStatement();
        ResultSet results = statement.executeQuery(query);

        ArrayList<Movie> movies = new ArrayList<>();

        while(results.next()){
            int id = results.getInt("id");
            String title = results.getString("title");
            String genre = results.getString("genre");
            int year_of_release = results.getInt("year_of_release");

            Movie movie = new Movie (title, genre, year_of_release);
            movies.add(movie);

        }
        return movies;
    }

    public void createMovie  (final  Movie movie) throws SQLException {
        String query = "Insert into Movies(title, genre, yearOfRelease) VALUES(?,?,?)";
        PreparedStatement  preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2,movie.genre);
        preparedStatement.setInt(3,movie.yearOfRelease);


        preparedStatement.execute();
        preparedStatement.close();
    }


    public void deleteMovie (int id) throws SQLException {
        String query = "delete from Movies where id=?";
        PreparedStatement preparedStatement =dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void updateMoviesTitle (int id, String newTitle) throws SQLException {
        String query = "Update Movies SET title = ?  where id = ?" ;
        PreparedStatement preparedStatement =dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1,newTitle);
        preparedStatement.setInt(2,id);

        preparedStatement.execute();
        preparedStatement.close();


    }

    public Movie findMovieById(int id)throws SQLException {
        String query = "Select * from Movies where  id =  " +id ;
        Statement statement =dbHandler.getConnection().createStatement();
        ResultSet result  = statement.executeQuery(query);

        if (result.next()) {
            int movieId= result.getInt("id");
            String movie_name = result.getString("title");
            String genre = result.getString("genre");
            int yearOfRelease = result.getInt("yearOfRelease");
            Movie movie = new Movie(movie_name, genre, yearOfRelease);
            movie.id = movieId;
            statement.close();
            return movie;
        }
        else {
            return null;

        }

    }

    public ArrayList<Movie> findAll() throws SQLException {
        String query = "Select * from Movies";
        Statement statement = dbHandler.getConnection().prepareStatement(query);
        ResultSet  results = statement.executeQuery(query);

        ArrayList<Movie> movies = new ArrayList<>();
        while (results.next()) {
            int id = results.getInt("id");
            String title = results.getString("title");
            String genre = results.getString("genre");
            int yearOfRelease = results.getInt("yearOfRelease");


            Movie movie = new Movie(title,genre,yearOfRelease);

            movies.add(movie);

        }

        return movies;

    }


}
