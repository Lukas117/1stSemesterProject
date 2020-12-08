package Controller;

import java.util.ArrayList;

import Model.Product;
import Model.ProductContainer;

public class ProductController {
	
	private ProductContainer productContainer;
	
	public  ProductController() {
		productContainer.getInstance();
	}
	
	public boolean createProduct(Product product) {
    	return productContainer.addProduct(product);
    }
    
    public Product findProduct(String name) {
    	return productContainer.findProduct(name);
    }
    
    public boolean deleteProduct(Product product) {
    	return productContainer.deleteProduct(product);
    }
}
