package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.ProductController;
import Model.Product;

public class ProductMenu {
	private ProductController productController;
	
	public ProductMenu(ProductController productController) {
		this.productController = productController;
	}
	
	public ProductController getProductController() {
		return productController;
	}
	
	public void start() {
		productMenu();
	}
	
	private void productMenu() {
		boolean running = true;
		
		while(running) {
			int choice = writeProductMenu();
			switch(choice) {
            case 1:
            	createProduct();
                break;
            case 2:
            	findProduct();
             	break;
            case 3:
                updateProduct();
                break;
            case 4:
            	deleteProduct();
                break;
            case 5:
            	showProducts();
                break;
            case 0:
                running = false;
                break;
            default:
                System.out.println("Unknown error with choice = " + choice);
                break;
			}
		}
	}
	
	private int writeProductMenu()  {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("****** Product menu ******");
        System.out.println(" (1) Create product");
        System.out.println(" (2) Find product");
        System.out.println(" (3) Update product");
        System.out.println(" (4) Delete product");
        System.out.println(" (5) Show product");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
                
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
	
	public void createProduct() {
    	Product product = getDataToNewProduct();
    	
    	if (productController.createProduct(product)) {
        	System.out.println(" Name is already taken, try different one");
    	}
    	else {
    		productController.createProduct(product);
    		for (int i=0; i<product.getStock(); i++) {
		 		productController.addToStock(product.getName());
			}
    		System.out.println("\n Product created! \n");
    	}
    }
	
	public void findProduct() {
	    Scanner keyboard = new Scanner(System.in);
	    	
	    System.out.print(" Name: ");
	   	String name = getStringFromUser(keyboard);
	    	
	   	Product product = productController.findProduct(name);    
	    	
	   	if (productController.findProduct(name) != null) {
	   		System.out.println("----- Product -----");
    		System.out.println(" Name: " + name);
    		System.out.println(" Type: " + product.getType());
    		System.out.println(" Location: " + product.getLocation());
    		System.out.println(" Price: " + product.getPrice());
			System.out.println(" Stock: " + product.getStock() + "\n");
    	}
    	else {
    		System.out.println(" Product does not exist!\n");
    	}
    }
	 
	 private void updateProduct() {
	    	Scanner keyboard = new Scanner(System.in);

	    	System.out.print(" Name: ");
	    	String name = getStringFromUser(keyboard);
			Product product = productController.getProductContainer().findProduct(name);    	
	    	
	    	if (productController.findProduct(name) != null) {
	    		ArrayList<Integer> barcodes= productController.getProductContainer().findProduct(name).getBarcodeList();
	    		
	    		int oldStock = product.getStock();
	    		System.out.println("Current name " + "[" + product.getName() + "]");
	            System.out.print("New name: ");
	            name = getStringFromUser(keyboard);
	            System.out.println("Current type " + "[" + product.getType() + "]");
	            System.out.print("New type: ");
	            String type = getStringFromUser(keyboard);
	            System.out.println("Current price " + "[" + product.getPrice() + "]");
	            System.out.print("New price: ");
	            double price = getDoubleFromUser(keyboard);
	            System.out.println("Current location " + "[" + product.getLocation() + "]");
	            System.out.print("New location: ");
	            String location = getStringFromUser(keyboard);
				System.out.println("Current stock " + "[" + product.getStock() + "]");
				System.out.print("New stock: ");
				int stock = getIntegerFromUser(keyboard);
	    		product = new Product(name, type, location, price, stock);
	    		
	    		for(int i=0; i<oldStock;i++) {
	    			product.getBarcodeList().add(i, barcodes.get(i));
	    		}
	    			
	    		if (productController.getProductContainer().addProduct(product)) {
	        		System.out.println("\n Product with the same name already exists!\n");
	        	}
	        	else {
	        		productController.deleteProduct(product);
	        		productController.createProduct(product);
	        		if(stock-oldStock>0) {
		    			for(int i=0; i<(stock-oldStock); i++) {
		    				productController.addToStock(name);
		    			}	
		    		}
		    		else{
		    			for(int i=0; i<(oldStock-stock); i++) {
		    				productController.removeFromStock(name);
		    			}
		    		}
	        		System.out.println("\n Product updated! \n");
	        	}
	    	}
	    	else {
	    		System.out.println(" Product not found.\n");
	    	}
	    }
	 
	 private void deleteProduct() {	    	
	    	System.out.println(" Write name of the product that you want to delete:");
	    	Scanner keyboard = new Scanner(System.in);
	    	String name = getStringFromUser(keyboard);
	    	Product product = productController.findProduct(name);
			if (productController.deleteProduct(product)) {
	    		System.out.println(" Product deleted!\n");
	    	}
	    	
	    	else {
	    		System.out.println(" Product not found.\n");
	    	}	
	    }
	 
	 private void showProducts() {
		 ArrayList<Product> productList = productController.getProductContainer().getProductList();
	        
	     System.out.println("\n****** Registered products ******");
	     for(int i=0; i<productList.size(); i++) {
	    	 Product product = productList.get(i);
	            
	         System.out.println("––––– Product " + (i+1) + " –––––");
	         System.out.println("Name: " + product.getName());
	         System.out.println("Type: " + product.getType());
	         System.out.println("Location: " + product.getLocation());
	         System.out.println("Price: " + product.getPrice());
			 System.out.println("Stock: " + product.getStock());
			 System.out.print("Barcodes: ");
			 for(int barcode: product.getBarcodeList()) {
				 System.out.print(barcode + " ");
			 }
			 System.out.println();
	     } 
	     System.out.println("\n*************************\n");
	 }
	 
	 private Product getDataToNewProduct() {
	    	Scanner keyboard = new Scanner(System.in);
	        String name = null;
	        
	    	while(name == null){
	            
	    		System.out.print(" Name of the product: ");
	            
	            String nonCheckedName = getStringFromUser(keyboard);
	            ArrayList<Product> productList = productController.getProductContainer().getProductList();
	            
	            if (productList.isEmpty()) {
	                name = nonCheckedName;
	            }
	            for(Product _product: productList) {
	                if(_product.getName() == nonCheckedName){
	                    System.out.println(" Name is already taken, try different one");
	                }
	                
	                else {
	                    name = nonCheckedName;
	                }
	            }
	        }
	        System.out.print(" Type: ");
	        String type = getStringFromUser(keyboard);
	        System.out.print(" Location: ");
	        String location = getStringFromUser(keyboard);
	        System.out.print(" Price: ");
	        double price = getDoubleFromUser(keyboard);
		 	System.out.print(" Stock: ");
		 	int stock = getIntegerFromUser(keyboard);
		 	Product product = new Product(name, type, location, price, stock);
		 	
	        
			return product;
	    }
	 
	private Double getDoubleFromUser(Scanner keyboard) {
	    while (!keyboard.hasNextDouble()) {
	    	System.out.println("Input must be a number - try again");
	    	keyboard.nextLine();
	    }
	    return keyboard.nextDouble();
	}
		
	private Integer getIntegerFromUser(Scanner keyboard) {
	   	while (!keyboard.hasNextInt()) {
	   		System.out.println("Input must be a number - try again");
	   		keyboard.nextLine();
	   	}
	return keyboard.nextInt();
	}
	    
	private String getStringFromUser(Scanner keyboard) {
		String inputToString = null;
		while((inputToString = keyboard.nextLine()).isBlank()) {
			System.out.println("You need to type something.");
		}
		return inputToString;
	}
}