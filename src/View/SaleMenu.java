package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.SaleController;
import Controller.ProductController;
import Controller.CustomerController;
import Model.Sale;
import Model.Customer;
import Model.Product;
import java.time.LocalDateTime;

public class SaleMenu {
	private SaleController saleController;
	private CustomerController customerController;
	private ProductController productController;
	private EmployeeMenu employeeMenu;
	private CustomerMenu customerMenu;
	
	public SaleMenu(SaleController saleController, CustomerController customerController, ProductController productController, EmployeeMenu employeeMenu, CustomerMenu customerMenu) {
		this.saleController = saleController;
		this.customerController = customerController;
		this.productController = productController;
		this.employeeMenu = employeeMenu;
		this.customerMenu = customerMenu;
	}
	
	public void start() {
		saleMenu();
	}
	
	private void saleMenu() {
		boolean running = true;
		
		while(running) {
			int choice = writeSaleMeu();
			switch(choice) {
				case 1:
					createSale();
					break;
				case 2:
					findSale();
					break;
				case 3:
					updateSale();
					break;
				case 4:
					deleteSale();
					break;
				case 5:
					showSale();
					break;
				case 0:
					running = false;
					break;
				default:
					System.out.println("Unknown error with choise = " + choice);
					break;
			}
		}
	}
	
	private int writeSaleMeu() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("****** Sale menu ******");
        System.out.println(" (1) Create sale");
        System.out.println(" (2) Find sale");
        System.out.println(" (3) Update sale");
        System.out.println(" (4) Delete sale");
        System.out.println(" (5) Show sales");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        int choice = getIntegerFromUser(keyboard);
        return choice;
	}
	
	private void createSale() {
		Sale sale = getDataToNewSale();
		
		if (saleController.createSale(sale)) {
			System.out.println("Sale already exists.");
		}
		else {
			saleController.createSale(sale);
			employeeMenu.getCurrentUser().setSaleCounter(employeeMenu.getCurrentUser().getSaleCounter() + 1);
			System.out.println("\n Sale created! \n");
		}
	}
	
	private void findSale() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("ID: ");
		int id = getIntegerFromUser(keyboard);
		Sale sale = saleController.findSale(id);
		
		if (saleController.findSale(id) != null) {
			System.out.println("----- Sale -----");
			System.out.println("ID: " + sale.getId());
			System.out.println("Customer name: " + sale.getCustomer().getName());
			System.out.println("Customer's CPR number: " + sale.getCustomer().getCprNumber());
			System.out.println("Total price: " + sale.getPrice() + " dkk");
			System.out.print("Items: ");
			for (Product item: sale.getShoppingCart()) {
				System.out.println("	Name: " + item.getName()+ " Quantity: " + item.getBarcodeList().size());
			}
			System.out.print("Delivery: ");
			if (sale.isDelivery()) {
				System.out.println("Yes. Item will be delivered.\n");
			}
			else {
				System.out.println("No. Pick up at the store.\n");
			}
		}
		else {
			System.out.println(" Sale does not exist.\n");
		}
	}
	
	private void updateSale() {
		Scanner keyboard = new Scanner(System.in);

		LocalDateTime purchaseDate = null;
		LocalDateTime paymentDeadline = null;
		boolean dispatchable = false;
		Customer customer = null;
		ArrayList<Product> cart= new ArrayList<>();
		
		System.out.println("ID: ");
		int id = getIntegerFromUser(keyboard);
		Sale sale = saleController.getSaleContainer().findSale(id);
		
		if (saleController.updateSale(id) != null) {
			saleController.deleteSale(sale);
			
			System.out.println("Current ID " + "[" + sale.getId() + "]");
			System.out.println("Write the new ID: ");
			id = getIntegerFromUser(keyboard);
			System.out.println("Current price " + "[" + sale.getPrice() + "]");
			System.out.println("New price: ");
			double price = getDoubleFromUser(keyboard);
			
			sale = new Sale(id, price, purchaseDate, paymentDeadline, dispatchable, customer, cart);
			
			if (saleController.getSaleContainer().addSale(sale)) {
				System.out.println("\n Sale already exists!\n");
			}
			else {
				saleController.createSale(sale);
				System.out.println("\nSale updated.\n");
			}
		}
		else {
			System.out.println(" Sale not found.\n");
		}
	}

	private void deleteSale() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(" ID of the sale that you want to delete: ");
		int id = getIntegerFromUser(keyboard);
		Sale sale = saleController.findSale(id);
		if (saleController.deleteSale(sale)) {
			System.out.println(" Sale deleted!");
		}
		else {
			System.out.println(" Sale not found.");
		}
	}
	
	private void showSale() { 
		ArrayList<Sale> sales = saleController.getSaleContainer().getSales();
		
		System.out.println("\n****** Registered Sales *******");
		for(int i=0; i<sales.size(); i++) {
			Sale sale = sales.get(i);
			
			System.out.println("----- Sale number: " + (i+1) + "-----");
			System.out.println("Sale ID: " + sale.getId());
			System.out.println("Price: " + sale.getPrice() + " dkk");
			System.out.println("Customer's CPR number: " + sale.getCustomer().getCprNumber());
			System.out.print("Items: ");
			for (Product item: sale.getShoppingCart()) {
				System.out.println("	Name: " + item.getName()+ " Quantity: " + item.getStock());
			}
		}
		System.out.println("************************\n");
	}
	
	private Sale getDataToNewSale() {
		Scanner keyboard = new Scanner(System.in);
		int id = 0;
		LocalDateTime purchaseDate = null;
		LocalDateTime paymentDeadline = null;
		Customer customer = null;
		ArrayList<Product> shoppingCart = new ArrayList<>();

		while(id == 0) {
			
			System.out.print(" ID: ");
			
			int nonCheckedId = getIntegerFromUser(keyboard);
			ArrayList<Sale> saleList = saleController.getSaleContainer().getSales();
			
			if (saleList.isEmpty()) {
				id = nonCheckedId;
			}
			for(Sale _sale: saleList) {
				if(_sale.getId() == nonCheckedId) {
					System.out.println(" ID is already taken, try different one");
				}
				else {
					id = nonCheckedId;
				}
			}
		}
		
		System.out.print(" Customer's CPR number: ");
		long cprNumber = getLongFromUser(keyboard);
		if(!customerController.cprCheck(cprNumber)) {
			System.out.println(" Customer does not exist, please create customer.");
			customerMenu.createCustomer();
			customer = customerController.findCustomer(cprNumber);
		}
		else {
			customer = customerController.findCustomer(cprNumber);
		}

		int choice = 0;
		while(choice != 2) {
			keyboard = new Scanner(System.in);
			System.out.print(" Name of the product: ");
			String name = getStringFromUser(keyboard);
			System.out.print(" Number of products: ");
			int numberOfProducts = getIntegerFromUser(keyboard);
			shoppingCart.add(addProductToCart(name, numberOfProducts));
			System.out.println(" (1) Add more products");
			System.out.println(" (2) Finish");
			System.out.print(" Choice: ");
			choice = getIntegerFromUser(keyboard);
		}
		
		double totalPrice = getTotalPrice(shoppingCart);
		boolean delivery = getDelivery();

		return new Sale(id, totalPrice, null, null, delivery, customer, shoppingCart);
	}
	
	private Product addProductToCart(String name, int numberOfProducts) {
		Product product = productController.findProduct(name);
		while (!productController.stockCheck(numberOfProducts,product)) {
			System.out.println(" Not enough in stock.");
			Scanner keyboard = new Scanner(System.in);
			numberOfProducts = getIntegerFromUser(keyboard);
		}
		productController.removeFromStock(name, numberOfProducts);
		product.setStock(numberOfProducts);
		return product;
	}

	private double getTotalPrice(ArrayList<Product> shoppingCart) { //wrong
		double total = 0;
		for (Product item: shoppingCart) {
			total += (item.getPrice() * item.getStock());
		}
		return total;
	}

	private boolean getDelivery() {
		boolean delivery = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print(" Delivery (1 Yes/2 No): ");
		int option = getIntegerFromUser(keyboard);
		switch (option) {
			case 1:
				delivery = true;
				break;
			case 2:
				delivery = false;
				break;
			default:
				System.out.println(" Option not available.");
				break;
		}
		return delivery;
	}
	
	private Double getDoubleFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextDouble()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextDouble();
	}

	private Long getLongFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextLong()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextLong();
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