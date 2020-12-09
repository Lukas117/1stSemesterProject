package Controller;

import Model.Product;
import Model.ProductContainer;

public class ProductController {
	
	private ProductContainer productContainer;
	
	public  ProductController() {
		productContainer = ProductContainer.getInstance();
	}
	
	public ProductContainer getProductContainer() {
		return productContainer;
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

    public void addToStock(String productName) {productContainer.addBarcode(productName);}

    public boolean removeFromStock(String productName) {return productContainer.deleteBarcode(productName);}
}

