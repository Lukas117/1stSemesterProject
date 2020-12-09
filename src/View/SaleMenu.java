package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.SaleController;
import Controller.ProductController;
import Controller.CustomerController;
import Model.Sale;
import Model.Customer;

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
        
        while (!keyboard.hasNextInt()) {
        	System.out.println(" Input must be a number - try again");
        	keyboard.nextLine();
        }
        
        int choice = keyboard.nextInt();
        return choice;
	}
	
	public void createSale() {
		Sale sale = getDataToNewSale();
		
		if (saleController.createSale(sale)) {
			System.out.println("Sale is already created, please create another one!");
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
		int id = keyboard.nextInt();
		
		Sale sale = saleController.findSale(id);
		
		if (saleController.findSale(id) != null) {
			System.out.println("----- Sale -----");
			System.out.println("ID: " + sale.getID());
		}
		else {
			System.out.println(" Sale does not exist!\n");
		}
	}
	
	@SuppressWarnings("resource")
	private void updateSale() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("ID: ");
		int id = keyboard.nextInt();
		Sale sale = saleController.getSaleContainer().findSale(id);
		
		if (saleController.updateSale(id) != null) {
			saleController.deleteSale(sale);
			
			System.out.println("Current ID " + "[" + sale.getID() + "]");
			System.out.println("Write the new ID: ");
			id = keyboard.nextInt();
			System.out.println("Current price " + "[" + sale.getPrice() + "]");
			System.out.println("New price: ");
			int price = keyboard.nextInt();
			
			sale = new Sale(id, price);
			
			if (saleController.getSaleContainer().addSale(sale)) {
				System.out.println("\n Sale already exists!!!\n");
			}
			else {
				saleController.createSale(sale);
				System.out.println("\nSale updated\n");
			}
		}
		else {
			System.out.println(" Sale not found\n");
		}
	}
	@SuppressWarnings("resource")
	private void deleteSale() {
		Scanner keyboard;
		int id = 0;
		
		System.out.println(" write ID of the slae that you want to delete: ");
		keyboard = new Scanner(System.in);
		Sale sale = saleController.findSale(id);
		if (saleController.deleteSale(sale)) {
			System.out.println(" Sale deleted");
		}
		else {
			System.out.println("Err; System didn't find sale by the ID, therefore the sale cannot be deleted.");
		}
	}
	
	private void showSale() {
		ArrayList<Sale> sales = saleController.getSaleContainer().getSales();
		
		System.out.println("\n****** Registered Sales *******");
		for(int i=0; i<sales.size(); i++) {
			Sale sale = sales.get(i);
			
			System.out.println("----- Sale " + (i+1) + "-----");
			System.out.println("ID: " + sale.getID());
			System.out.println("Price: " + sale.getPrice());
		}
		System.out.println("**********************\n");
	}
	
	@SuppressWarnings("resource")
	private Sale getDataToNewSale() {
		Scanner keyboard = new Scanner(System.in);
		int id = 0;
		
		while(id == 0) {
			
			System.out.println(" ID: ");
			
			while (!keyboard.hasNextInt()) {
				System.out.println(" Input must be a ID - try again");
				keyboard.nextInt();
			}
			int nonCheckedId = keyboard.nextInt();
			ArrayList<Sale> sales = saleController.getSaleContainer().getSales();
			
			if (sales.isEmpty()) {
				id = nonCheckedId;
			}
			for(Sale sale: sales) {
				if(sale.getID() == nonCheckedId) {
					System.out.println(" ID is already taken, try different one");
				}
				else {
					id = nonCheckedId;
				}
			}
		}
		System.out.println("Customer CPR number: ");
		long cpr = keyboard.nextLong();
		if(!cprCheck(cpr)) System.out.println("Customer does not exist, please create customer.");
		System.out.println("Product name: ");
		
		System.out.println(" Price: ");
		int price = keyboard.nextInt();
		
		return new Sale(id, price);
	}
	
	private boolean cprCheck(long cpr) {
		
		boolean foundCpr=false;
		for(Customer x : customerController.getCustomerContainer().getCustomerList()) {
			if (x.getCprNumber()==cpr) {
				foundCpr=true;
			}
		}
		return foundCpr;
	}
}
