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
	
	public SaleMenu(SaleController saleController, CustomerController customerController, ProductController productController) {
		this.saleController = saleController;
		this.customerController = customerController;
		this.productController = productController;
	}
	
	public SaleController getSaleController() {
		return saleController;
	}
	
	public ProductController getProductController() {
		return productController;
	}
	
	public CustomerController getCustomerController() {
		return customerController;
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
	
	@SuppressWarnings("resource")
	private int writeSaleMeu() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("****** Sale menu ******");
        System.out.println(" (1) Create sale");
        System.out.println(" (2) Find sale");
        System.out.println(" (3) Update sale");
        System.out.println(" (4) Delete sale");
        System.out.println(" (5) Show sale");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        int choice = getIntegerFromUser(keyboard);
        return choice;
	}
	
	public void createSale() {
		Sale sale = getDataToNewSale();
		
		if (saleController.createSale(sale)) {
			System.out.println("Sale already exists.");
		}
		else {
			saleController.createSale(sale);
			System.out.println("\n Sale created! \n");
		}
	}
	
	@SuppressWarnings("resource")
	public void findSale() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("ID: ");
		int id = getIntegerFromUser(keyboard);
		
		Sale sale = saleController.findSale(id);
		
		if (saleController.findSale(id) != null) {
			System.out.println("----- Sale -----");
			System.out.println("ID: " + sale.getId());
			System.out.println("Customer name: " + sale.getCustomer().getName());
			System.out.println("Total price: " + sale.getPrice());
			System.out.println("Items: ");
			for (Product item: sale.getShoppingCart()) {
				System.out.println(item.getName());
				System.out.println(item.getStock());
			}
			System.out.print("Delivery: ");
			if (sale.isDispatchable()) System.out.print("Yes\n");
			else System.out.print("No\n");
			System.out.println("ID: " + sale.getId());
		}
		else {
			System.out.println(" Sale does not exist!\n");
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
			System.out.println("Sale deleted!");
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
			System.out.println("Price: " + sale.getPrice() + "kr.");
			System.out.println("Customer's CPR number: " + sale.getCustomer().getCprNumber());
			System.out.println("Items: ");
			printSaleItems(sale.getShoppingCart());
		}
		System.out.println("************************\n");
	}
	
	@SuppressWarnings("resource")
	private Sale getDataToNewSale() {
		Scanner keyboard = new Scanner(System.in);
		int id = 0;
		LocalDateTime purchaseDate = null;
		LocalDateTime paymentDeadline = null;
		boolean dispatchable = false;
		Customer customer = null;
		ArrayList<Product> cart= new ArrayList<>();
		double totalPrice=0;

		while(id == 0) {
			
			System.out.print(" ID: ");
			
			while (!keyboard.hasNextInt()) {
				System.out.println(" Input must be a number - try again");
				keyboard.nextLine();
			}
			int nonCheckedId = keyboard.nextInt();
			ArrayList<Sale> sales = saleController.getSaleContainer().getSales();
			
			if (sales.isEmpty()) {
				id = nonCheckedId;
			}
			for(Sale sale: sales) {
				if(sale.getId() == nonCheckedId) {
					System.out.println(" ID is already taken, try different one");
				}
				else {
					id = nonCheckedId;
				}
			}
		}
		System.out.println("Customer CPR number: ");
		long cprNumber = getLongFromUser(keyboard);
		if(!cprCheck(cprNumber)) {
			System.out.println("Customer does not exist, please create customer.");
		}
		else {
			customer = customerController.findCustomer(cprNumber);
		}

		int choice=0;
		while(choice!=2) {
			keyboard = new Scanner(System.in);
			System.out.println(" Name of the product: ");
			String name = keyboard.nextLine();
			System.out.println(" Number of products: ");
			int numberOfProducts = keyboard.nextInt();
			cart.add(addProductToCart(name, numberOfProducts));
			System.out.println("(1) Add more products");
			System.out.println("(2) Finish");
			choice = keyboard.nextInt();
		}
		totalPrice=getTotalPrice(cart);
		dispatchable=getDelivery();

		return new Sale(id, totalPrice, null, null, dispatchable, customer, cart);
	}
	
	@SuppressWarnings("resource")
	private Product addProductToCart(String name, int numberOfProducts) {
		ArrayList<Product> products = productController.getProductContainer().getProductList();
			Product temp;
			Product product = productController.findProduct(name);
			temp = product;
			productController.updateStock(temp, product.getStock(), numberOfProducts);
		return temp;
	}

	private double getTotalPrice(ArrayList<Product> cart) {
		double total=0;
		for (Product item: cart) {
			total=total+(item.getPrice()*item.getBarcodeList().size());
		}
		return total;
	}

	private boolean getDelivery() {
		boolean dispatchable=false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Delivery (Yes/No): ");
		String delivery = keyboard.nextLine();

		if(delivery.equals("Yes")) dispatchable = true;
		else if(delivery.equals("No")) dispatchable = false;
		else System.out.println("Choose from yes or no");
		return dispatchable;
		
	}
	
//	@SuppressWarnings("resource")
//	private ArrayList<Product> addProductToCart() {
//		ArrayList<Product> products = productController.getProductContainer().getProductList();
//		ArrayList<Integer> saleItems = new ArrayList<>();
//		Scanner keyboard = new Scanner(System.in);
//		
//		System.out.println(" Name of the product: ");
//		String name = keyboard.nextLine();
//		Product product = productController.findProduct(name);
//		ArrayList<Integer> barcodes = product.getBarcodeList();
//		System.out.println(" Number of products: ");
//		int numberOfProducts = keyboard.nextInt();
//		
//		saleItems.add(product);
//		
//		return saleItems;
//	}
	
	private boolean cprCheck(long cpr) {
		boolean foundCpr=false;
		for(Customer x : customerController.getCustomerContainer().getCustomerList()) {
			if (x.getCprNumber()==cpr) {
				foundCpr=true;
			}
		}
		return foundCpr;
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

	private void printSaleItems(ArrayList<Product> cart) {
		for (Product item: cart) {
			System.out.println(item.getName());
			for(int barcode: item.getBarcodeList()) {
				System.out.println(barcode);
			}
		}
	}

	private Integer getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextInt()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextInt();
	}
}
