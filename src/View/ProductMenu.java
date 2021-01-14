package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.ProductController;
import Model.Product;
import Controller.LocationController;
import Controller.DepartmentController;
import Model.Location;
import Model.Department;

public class ProductMenu {
	private ProductController productController;
	private LocationController locationController;
	private DepartmentController departmentController;
	private DepartmentMenu departmentMenu;
	private LocationMenu locationMenu;

	
	public ProductMenu(ProductController productController, LocationController locationController, DepartmentController departmentController, DepartmentMenu departmentMenu, LocationMenu locationMenu) {
		this.productController = productController;
		this.locationController = locationController;
		this.departmentController = departmentController;
		this.departmentMenu = departmentMenu;
		this.locationMenu = locationMenu;
	}
	
	public LocationController getLocationController() {
		return locationController;
	}
	
	public ProductController getProductController() {
		return productController;
	}
	
	public DepartmentController getDepartmentController() {
		return departmentController;
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
                case 6:
                	showStatistics();
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
        System.out.println(" (6) Show statistics");
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
	   	productController.setStockToBarcodes(product);
	   	if (productController.findProduct(name) != null) {
	   		System.out.println("----- Product -----");
    		System.out.println(" Name: " + name);
    		System.out.println(" Type: " + product.getType());
    		System.out.println(" Location: " + product.getLocation());
    		System.out.println(" Price: " + product.getPrice());
			System.out.println(" Stock: " + product.getStock());
			System.out.println("Send notification when the stock drops below: " + product.getMinStock() + "\n");
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
			productController.setStockToBarcodes(product);
			Location location;
			Department department;
			
	    	if (productController.updateProduct(name) != null) {
	    		ArrayList<Integer> barcodes= productController.getProductContainer().findProduct(name).getBarcodeList();
	    		
	    		int oldStock = product.getStock();
	    		System.out.println("Current name " + "[" + product.getName() + "]");
	            System.out.print("New name: ");
	            name = getStringFromUser(keyboard);
	            System.out.println("Current type " + "[" + product.getType() + "]");
	            System.out.print("New type: ");
	            String type = getStringFromUser(keyboard);
	            System.out.println("Current location: ");
	            System.out.println("Department: " + "[" + product.getLocation().getDepartment() + "]");
		        System.out.println("Aisle: " + "[" + product.getLocation().getAisle() + "]");
		        System.out.println("Shelf: " + "[" + product.getLocation().getShelf() + "]");
		        System.out.print("New department name: ");
		        String departmentName = getStringFromUser(keyboard);
		        if(departmentController.findDepartment(departmentName) == null) {
		        	System.out.println("Department does not exist! Please create it first!");
		        	return;
		        }
		        else department = departmentController.findDepartment(departmentName);
		        System.out.print("New aisle: ");
		        int aisle = getIntegerFromUser(keyboard);
		        System.out.print("New shelf: ");
		        int shelf = getIntegerFromUser(keyboard);
		        if(locationController.getLocationContainer().findLocation(department, aisle, shelf) == null ) {
		        	System.out.println("Location does not exist! Please create it first!");
		        	return;
		        }
		        else location = locationController.getLocationContainer().findLocation(department, aisle, shelf);
	            System.out.println("Current price " + "[" + product.getPrice() + "]");
	            System.out.print("New price: ");
	            double price = getDoubleFromUser(keyboard);
				System.out.println("Current stock " + "[" + product.getStock() + "]");
				System.out.print("New stock: ");
				int stock = getIntegerFromUser(keyboard);
				System.out.println("Send notification when the stock drops below [" + product.getMinStock() + "]");
				System.out.println("New minimum stock: ");
				int minStock = getIntegerFromUser(keyboard);
				int salesCounter = product.getSalesCounter();
				int numberOfItemSold = product.getNumberOfItemSold();

				product = new Product(name, type, location, price, stock, minStock);

				product.setSalesCounter(salesCounter);
				product.setNumberOfItemSold(numberOfItemSold);

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
		    				productController.removeFromStock(name, i);
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
	         productController.setStockToBarcodes(product);
	         System.out.println("����� Product " + (i+1) + " �����");
	         System.out.println("Name: " + product.getName());
	         System.out.println("Type: " + product.getType());
	         System.out.println("Location: ");
	         System.out.println("Warehouse: " + product.getLocation().getDepartment().getWarehouse());
	         System.out.println("Department: " + product.getLocation().getDepartment().getName());
	         System.out.println("Aisle: " + product.getLocation().getAisle());
	         System.out.println("Shelf: " + product.getLocation().getShelf());
	         System.out.println("Price: " + product.getPrice());
			 System.out.println("Stock: " + product.getStock());
			 System.out.print("Barcodes: ");
			 for(int barcode: product.getBarcodeList()) {
				 System.out.print(barcode + " ");
			 }
			 System.out.println();
			 System.out.println("Send notification when the stock drops below: " + product.getMinStock());
	     } 
	     System.out.println("\n*************************\n");
	 }
	 
	 private Product getDataToNewProduct() {
	    	Scanner keyboard = new Scanner(System.in);
	        String name = null;
	        Department department;
	        Location location;
	        
	    	while(name == null){
	            
	    		System.out.print(" Name of the product: ");
	            
	            String nonCheckedName = getStringFromUser(keyboard);
	            ArrayList<Product> productList = productController.getProductContainer().getProductList();
	            
	            if (productList.isEmpty()) {
	                name = nonCheckedName;
	            }
	            for(Product _product: productList) {
	                if(_product.getName().equals(nonCheckedName)){
	                    System.out.println(" Name is already taken, try different one");
	                }
	                
	                else {
	                    name = nonCheckedName;
	                }
	            }
	        }
	        System.out.print(" Type: ");
	        String type = getStringFromUser(keyboard);
	        System.out.println(" Location: ");
	        System.out.print("Department name: ");
	        String departmentName = getStringFromUser(keyboard);
	        if(departmentController==null) {
	        	departmentController= new DepartmentController();
	        	departmentMenu = new DepartmentMenu(departmentController);
	        }
	        if(departmentController.findDepartment(departmentName)==null) {
	        	System.out.println("Department does not exist! Please create one!");
	        	departmentMenu.createDepartment();
	        }	
	        department = departmentController.findDepartment(departmentName);
	        System.out.print("Aisle: ");
	        int aisle = getIntegerFromUser(keyboard);
	        System.out.print("Shelf: ");
	        int shelf = getIntegerFromUser(keyboard);
	        if( locationController == null) {
		        locationController = new LocationController();
		        locationMenu = new LocationMenu(locationController, departmentController);
	        }
	        if( locationController.getLocationContainer().findLocation(department, aisle, shelf)==null) {
		        System.out.println("Location does not exist! Please create one!");
	        	locationMenu.createLocation();
	        }
	        location = locationController.getLocationContainer().findLocation(department, aisle, shelf);
	        System.out.print(" Price: ");
	        double price = getDoubleFromUser(keyboard);
		 	System.out.print(" Stock: ");
		 	int stock = getIntegerFromUser(keyboard);
		 	System.out.println("Send notification when the stock drops below: ");
		 	int minStock = getIntegerFromUser(keyboard);

		 	Product product = new Product(name, type, location, price, stock, minStock);

		 	product.setNumberOfItemSold(0);
		 	product.setSalesCounter(0);

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

	private void showStatistics() {
		ArrayList<Product> productList = productController.getProductContainer().getProductList();
		System.out.println("\n****** Products Statistics ******");
		System.out.println("Most sold product: " + findMostSoldProduct(productList).getName() + ". Number of products sold: " + findMostSoldProduct(productList).getNumberOfItemSold());
		System.out.println("Item was purchased the most times: " + findMostTimesPurchasedProduct(productList).getName() + ". Number of times: " + findMostTimesPurchasedProduct(productList).getSalesCounter());
		System.out.println("Least sold product: " + findLeastSoldProduct(productList).getName() + ". Number of products sold: " + findLeastSoldProduct(productList).getNumberOfItemSold());
		System.out.println("Item was purchased the least times: " + findLeastTimesPurchasedProduct(productList).getName() + ". Number of times: " + findLeastTimesPurchasedProduct(productList).getSalesCounter());
		System.out.println("Product with the biggest stock: " + findProductWithBiggestStock(productList).getName() + ". Stock: " + findProductWithBiggestStock(productList).getStock());
		System.out.println("Product with the smallest stock: " + findProductWithSmallestStock(productList).getName() + ". Stock: " + findProductWithSmallestStock(productList).getStock());
		System.out.println("\n");
		for(int i=0; i<productList.size(); i++) {
			Product product = productList.get(i);
			System.out.println("����� Product " + (i+1) + " �����");
			System.out.println("Name: " + product.getName());
			System.out.println("Number of times item was purchased: " + product.getSalesCounter());
			System.out.println("Number of total sold: " + product.getNumberOfItemSold());
		}
	}

	private Product findMostTimesPurchasedProduct(ArrayList<Product> products) {
		int max = 0;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getSalesCounter()>max) {
				max = p.getSalesCounter();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}

	private Product findMostSoldProduct(ArrayList<Product> products) {
		int max = 0;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getNumberOfItemSold()>max) {
				max = p.getNumberOfItemSold();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}

	private Product findLeastTimesPurchasedProduct(ArrayList<Product> products) {
		int min = Integer.MAX_VALUE;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getSalesCounter()<min) {
				min = p.getSalesCounter();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}

	private Product findLeastSoldProduct(ArrayList<Product> products) {
		int min = Integer.MAX_VALUE;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getNumberOfItemSold()<min) {
				min = p.getNumberOfItemSold();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}

	private Product findProductWithBiggestStock(ArrayList<Product> products) {
		int max = 0;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getStock()>max) {
				max = p.getStock();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}

	private Product findProductWithSmallestStock(ArrayList<Product> products) {
		int min = Integer.MAX_VALUE;
		String nameOfMax = null;
		for (Product p: products) {
			if(p.getStock()<min) {
				min = p.getStock();
				nameOfMax = p.getName();
			}
		}
		return productController.findProduct(nameOfMax);
	}
	
}