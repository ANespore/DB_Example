package Products;

import Database.DBHandler;
import Products.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    DBHandler dbHandler = new DBHandler();

    public void create  ( Product product) throws SQLException {
        String query = "Insert into products(name, price, quantity) VALUES(?,?,?)";
        PreparedStatement  preparedStatement  = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, product.name);
        preparedStatement.setFloat(2,product.price);
        preparedStatement.setInt(3,product.quantity);


        preparedStatement.execute();
        preparedStatement.close();
    }


    public ArrayList<Product> getAll() throws SQLException {
        String query = "Select * from products";
        Statement statement = dbHandler.getConnection().prepareStatement(query);
        ResultSet  results = statement.executeQuery(query);

        ArrayList<Product> products = new ArrayList<>();
        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            Float price = results.getFloat("price");
            int quantity = results.getInt("quantity");


            Product product = new Product(name,price,quantity);

            products.add(product);

        }

        return products;

    }


    public ArrayList<Product> getProductByName  (String name) throws SQLException{
        String query = "Select * from products where  name = ?" ;
        PreparedStatement preparedStatement =dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.execute();

        ResultSet results  = preparedStatement.getResultSet();

        ArrayList<Product> products = new ArrayList<>();
        while (results.next()) {
            int id = results.getInt("id");
            String name1 = results.getString("name");
            Float price = results.getFloat("price");
            int quantity = results.getInt("quantity");
            Product product = new Product(name, price, quantity);
            products.add(product);
        }
        preparedStatement.close();
        return products;

        }


        public Product findProduct(int id)throws SQLException {
            String query = "Select * from products where  id =  " +id ;
            Statement statement =dbHandler.getConnection().createStatement();
            ResultSet result  = statement.executeQuery(query);

            if (result.next()) {
                int productId= result.getInt("id");
                String product_name = result.getString("name");
                Float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                Product product = new Product(product_name, price, quantity);
                product.id = productId;
                statement.close();
                return product;
            }
            else {
                return null;

            }

        }


        public void delete (int id) throws SQLException {
            String query = "delete from products where id=?";
            PreparedStatement preparedStatement =dbHandler.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            preparedStatement.close();
        }

         public void update (Product product) throws SQLException {
             String query = "Update products SET name = ? ,price = ? , quantity = ?  where id = ?" ;
             PreparedStatement preparedStatement =dbHandler.getConnection().prepareStatement(query);
             preparedStatement.setString(1,product.name);
             preparedStatement.setFloat(2,product.price);
             preparedStatement.setInt(3,product.quantity);
             preparedStatement.setInt(4,product.id);

             preparedStatement.execute();
             preparedStatement.close();


         }

}
