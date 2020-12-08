package Model;

import java.util.ArrayList;

public class ProductContainer {

	private static ProductContainer instance;
	private ArrayList<Product> productList = new ArrayList<>();
	
	private ProductContainer() {
		productList = new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance= new ProductContainer();
		}
		return instance;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public boolean addProduct(Product newProduct) {
		boolean foundProduct = false;
		
		if (productList.isEmpty()) {
        	foundProduct = false;
        }
        for (Product _product: productList) {
            if (_product.getName().equals(newProduct.getName())) {
            	foundProduct = true;
            }
        }
        if (!foundProduct) {
        	productList.add(newProduct);
        }
		return foundProduct;
	}
	
	public Product findProduct(String name) {
		for (Product _product: productList) {
			if (_product.getName().equals(name)) {
				return _product;
	        }
		}
	    return null;
	}
	
	public boolean deleteProduct(Product product) {
    	boolean deletedProduct = false;
    	Product productToDelete = null;
    	for (Product _product: productList) {
            if (_product.getName().equals(product.getName())) {           
            	productToDelete = _product;
            	deletedProduct = true;
            }
        }
    	if (deletedProduct) {
    		productList.remove(productToDelete);
    	}
		return deletedProduct;
    }
	
}
