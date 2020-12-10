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
        @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
        
        System.out.println("****** Product menu ******");
        System.out.println(" (1) Create product");
        System.out.println(" (2) Find product");
        System.out.println(" (3) Update product");
        System.out.println(" (4) Delete product");
        System.out.println(" (5) Show product");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        while (!keyboard.hasNextInt()) {
            System.out.println(" Input must be a number - try again");
            keyboard.nextLine();
        }
        
        int choice = keyboard.nextInt();
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
	
	 @SuppressWarnings("resource")
	private Product getDataToNewProduct() {
		 	Product p;
	    	Scanner keyboard = new Scanner(System.in);
	        String name = null;
	        
	    	while(name == null){
	            
	    		System.out.print(" Name of the product: ");
	            
	            while (!keyboard.hasNextLine()) {
	                System.out.println(" Input must be a name - try again");
	                keyboard.nextLine();
	            }
	            String nonCheckedName = keyboard.nextLine();
	            ArrayList<Product> productList = productController.getProductContainer().getProductList();
	            
	            if (productList.isEmpty()) {
	                name = nonCheckedName;
	            }
	            for(Product product: productList) {
	                if(product.getName() == nonCheckedName){
	                    System.out.println(" Name is already taken, try different one");
	                }
	                
	                else {
	                    name = nonCheckedName;
	                }
	            }
	        }
	        System.out.print(" type: ");
	        String type = keyboard.nextLine();
	        System.out.print(" Price: ");
	        double price = getDoubleFromUser(keyboard);
	        System.out.print(" Location: ");
	        String location = keyboard.nextLine();
		 	System.out.print(" Stock: ");
		 	int stock = getIntegerFromUser(keyboard);
		 	p = new Product(name, type, location, price, stock);
		 	
	        
			return p;
	    }
	 
	 @SuppressWarnings("resource")
		public void findProduct() {
	    	Scanner keyboard = new Scanner(System.in);
	    	
	    	System.out.print(" Name: ");
	    	String name = keyboard.nextLine();
	    	
	    	Product product = productController.findProduct(name);    
	    	
	    	if (productController.findProduct(name) != null) {
	    		System.out.println("----- Product -----");
	    		System.out.println(" Name: " + name);
	    		System.out.println(" Type: " + product.getType() + "\n");
	    		System.out.println(" Price: " + product.getPrice() + "\n");
	    		System.out.println(" Location: " + product.getLocation() + "\n");
				System.out.println(" Stock: " + product.getStock() + "\n");
	    	}
	    	else {
	    		System.out.println(" Product does not exist!\n");
	    	}
	    }
	 
	 @SuppressWarnings("resource")
		private void updateProduct() {
	    	Scanner keyboard = new Scanner(System.in);;

	    	System.out.print(" Name: ");
	    	String name = keyboard.nextLine();
			Product product = productController.getProductContainer().findProduct(name);    	
	    	
	    	if (productController.findProduct(name) != null) {
	    		ArrayList<Integer> barcodes= productController.getProductContainer().findProduct(name).getBarcodeList();
	    		productController.deleteProduct(product);
	    		int oldStock = product.getStock();
	    		System.out.println("Current name " + "[" + product.getName() + "]");
	            System.out.print("New name: ");
	            name = keyboard.next();
	            System.out.println("Current type " + "[" + product.getType() + "]");
	            System.out.print("New type: ");
	            String type = keyboard.next();
	            System.out.println("Current price " + "[" + product.getPrice() + "]");
	            System.out.print("New price: ");
	            double price = keyboard.nextDouble();
	            System.out.println("Current location " + "[" + product.getLocation() + "]");
	            System.out.print("New location: ");
	            String location = keyboard.next();
				System.out.println("Current stock " + "[" + product.getStock() + "]");
				System.out.print("New stock: ");
				int stock = keyboard.nextInt();
	    		product = new Product(name, type, location, price, stock);
	    		for(int i=0; i<oldStock;i++) {
	    			product.getBarcodeList().add(i, barcodes.get(i));
	    		}
	    			
	    		if (productController.getProductContainer().addProduct(product)) {
	        		System.out.println("\n Product already exists!!!\n");
	        	}
	        	else {
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
	 
	 @SuppressWarnings("resource")
		private void deleteProduct() {
	    	Scanner keyboard;
	    	String name;
	    	
	    	System.out.println(" Write name of the product that you want to delete:");
	    	keyboard = new Scanner(System.in);
	    	name = keyboard.nextLine();
	    	Product product = productController.findProduct(name);
			if (productController.deleteProduct(product)) {
	    		System.out.println(" Product deleted!\n");
	    	}
	    	
	    	else {
	    		System.out.println("Err: System didn't find product by name, therefore the produxt cannot be deleted.");
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
	            System.out.println("Price: " + product.getPrice());
	            System.out.println("Location: " + product.getLocation());
				System.out.println("Stock: " + product.getStock());
				for(int barcode: product.getBarcodeList()) {
					System.out.println(barcode+"\n");
				}
				
	        }
	        
	        System.out.println("*************************\n");
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
}


