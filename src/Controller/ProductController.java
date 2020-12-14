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
    
    public Product updateProduct(String name) {
		return productContainer.updateProduct(name);
	}

    public void addToStock(String productName) {
    	productContainer.addBarcode(productName);
    }

    public boolean removeFromStock(String productName, int numberOfStock) {
    	return productContainer.deleteBarcode(productName, numberOfStock);
    }
    
    public boolean stockCheck(int numberOfProducts, Product product) {
    	return productContainer.stockCheck(numberOfProducts, product);
    }
    
//    public void updateStock(Product product, int oldStock, int newStock) {
//		String name = product.getName();
//		if(newStock-oldStock>0) {
//			for(int i=0; i<(newStock-oldStock); i++) {
//				addToStock(name);
//			}
//		}
//		else{
//			for(int i=0; i<((oldStock-newStock)); i++) {
//				removeFromStock(name);
//			}
//		}
	//}
}

