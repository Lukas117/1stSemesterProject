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
	
	public Product updateProduct(String name) {
		return findProduct(name);
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

	public boolean addBarcode(String productName) {
		boolean foundProduct = false;
		int barcode;
		if (productList.isEmpty()) {
			foundProduct = false;
		}
		for (Product _product: productList) {
			if(_product.getName().equals(productName)) {
				do {
					barcode= _product.getBarcode();
				}
				while(_product.checkBarcode(_product.getBarcodeList(),barcode));
				_product.addBarcodeToList(barcode);
				foundProduct = true;
			}
		}
		if (!foundProduct) {
			System.out.println("The product does not exist.");
		}
		return foundProduct;
	}

	public boolean deleteBarcode(String productName, int numberOfStock) {
		boolean deletedBarcode = false;
		for (Product _product: productList) {
			if (_product.getName().equals(productName)) {
				for (int i=0; i<numberOfStock; i++) {
					_product.getBarcodeList().remove(0);
				}
				_product.setStock(_product.getStock()-numberOfStock);
				deletedBarcode = true;
			}
		}
		return deletedBarcode;
	}

	public void printOutBarcodes(String productName) {
		for(Product _product: productList) {
			if (_product.getName().equals(productName)) {
				for (int barcode: _product.getBarcodeList()) {
					System.out.println(barcode);
				}
			}
		}
	}
	
	public boolean stockCheck(int numberOfProducts, Product product) {
		boolean enoughStock = false; 
			if (numberOfProducts <= product.getBarcodeList().size()) {
				enoughStock = true;
			}
			else {
				enoughStock = false;
			}
		return enoughStock;
	}
}