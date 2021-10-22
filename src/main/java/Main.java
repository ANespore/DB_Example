import Products.MovieDAO;
import Products.Product;
import Products.ProductController;
import Products.ProductRepository;

import java.util.Scanner;

public class Main   {

    public static void main(String[] args) {

        ProductController productController = new ProductController();
       MovieDAO MovieDAO = new MovieDAO();
        //System.out.println(productController.createProduct(new Product("Milk",2.72f,30)));
        //System.out.println(productController.createProduct(new Product("Bread",1.54f,35)));
      // System.out.println(productController.findProduct("Rice"));
       // System.out.println(productController.findOneProduct(2));

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Select product id");
       // int id = scanner.nextInt();
       // Product product  = productController.findOneProduct(id);
       // product.name = "wine";
        //productController.updateProduct(product);

        // productController.deleteProduct(id);


      // MovieDAO.createTable();
        MovieDAO.deleteTable();
    }

    }

