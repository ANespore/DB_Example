package Products;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductRepository productRepository = new ProductRepository();


    public String createProduct(Product product) {

        try {
            productRepository.create(product);
            return "Product created successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating product!";

        }


    }



    public ArrayList<Product> getAllProducts() {
        try {
            return productRepository.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Product> findProduct(String name) {
        try {

            return productRepository.getProductByName(name);
        } catch (SQLException e) {
            System.out.println("Cannot retrieve product from database");
            e.printStackTrace();
            return null;

        }
    }


    public Product findOneProduct(int id) {
        try {

            return productRepository.findProduct(id);
        } catch (SQLException e) {
            System.out.println("Cannot retrieve product from database");
            e.printStackTrace();
            return null;
        }
    }



    public void   updateProduct(Product product) {
        try {

            productRepository.update(product);
            System.out.println("Product updated successfully");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public void   deleteProduct(int id) {
        try {

            productRepository.delete(id);
            System.out.println("Product deleted successfully");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }
}

