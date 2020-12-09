package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.CustomerController;
import Model.Customer;

public class CustomerMenu {
	private CustomerController customerController;
	
	public CustomerMenu(CustomerController customerController) {
		this.customerController = customerController;
	}
	
	public CustomerController getCustomerController() {
		return customerController;
	}
	
	public void start() {
		customerMenu();
	}
	
	private void customerMenu() {
        boolean running = true;
        
        while(running) {
            int choice = writeCustomerMenu();
            switch(choice) {
                case 1:
                	createCustomer();
                    break;
                case 2:
                	findCustomer();
                 	break;
                case 3:
                	updateCustomer();
                    break;
                case 4:
                	deleteCustomer();
                    break;
                case 5:
                	showCustomers();
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
	
	private int writeCustomerMenu()  {
        @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
        
        System.out.println("****** Customer menu ******");
        System.out.println(" (1) Create customer");
        System.out.println(" (2) Find customer");
        System.out.println(" (3) Update customer");
        System.out.println(" (4) Delete customer");
        System.out.println(" (5) Show customers");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        while (!keyboard.hasNextInt()) {
            System.out.println(" Input must be a number - try again");
            keyboard.nextLine();
        }
        
        int choice = keyboard.nextInt();
        return choice;
    }
	
	public void createCustomer() {
    	Customer customer = getDataToNewCustomer();
    	
    	if (customerController.createCustomer(customer)) {
        	System.out.println(" ID is already taken, try different one");
    	}
    	else {
    		customerController.createCustomer(customer);
    		System.out.println("\n Customer created! \n");
    	}
    }
	
	@SuppressWarnings("resource")
	private void findCustomer() {
		Scanner keyboard = new Scanner(System.in);
    	
    	System.out.print(" CPR Number (without dash): ");
    	long cprNumber = keyboard.nextLong();
    	
    	Customer customer = customerController.findCustomer(cprNumber);    
    	
    	if (customerController.findCustomer(cprNumber) != null) {
    		System.out.println("----- Customer -----");
    		System.out.println(" CPR Number: " + cprNumber);
    		System.out.println(" Name: " + customer.getName());
    		System.out.println(" Email: " + customer.getEmail() + "\n");
    		System.out.println(" Phone number: " + customer.getPhoneNumber() + "\n");
    		System.out.println(" Address: " + customer.getAddress() + "\n");
    		System.out.println(" City: " + customer.getCity() + "\n");
    		System.out.println(" Zipcode: " + customer.getZipCode() + "\n");

    	}
    	else {
    		System.out.println(" User does not exist!\n");
    	}
	}
	
	@SuppressWarnings("resource")
	private void deleteCustomer() {
    	Scanner keyboard;
    	int id;
    	
    	System.out.println(" Write id of the customer that you want to delete:");
    	keyboard = new Scanner(System.in);
    	id = keyboard.nextInt();
    	Customer customer = customerController.findCustomer(id);
		if (customerController.deleteCustomer(customer)) {
    		System.out.println(" Customer deleted!\n");
    	}
    	
    	else {
    		System.out.println("Err: System didn't find person by the username, therefore the player cannot be deleted.");
    	}	
    }
    
    private void showCustomers() {
    	ArrayList<Customer> customers = customerController.getCustomerContainer().getCustomerList();
        
        System.out.println("\n****** Registered customers ******");
        for(int i=0; i<customers.size(); i++) {
        	Customer customer = customers.get(i);
            
            System.out.println("––––– Customer " + (i+1) + " –––––");
            System.out.println("CPR Number: " + customer.getCprNumber());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone number: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("City: " + customer.getCity());
            System.out.println("Zip code: " + customer.getZipCode());
        }
        System.out.println("*************************\n");
    }
	
    @SuppressWarnings("resource")
	private Customer getDataToNewCustomer() {
    	Scanner keyboard;
        
        keyboard = new Scanner(System.in);
        long cprNumber = 0;
    	while(cprNumber == 0){
    		System.out.print(" CPR Number (without dash): ");
            
            while (!keyboard.hasNextLong()) {
                System.out.println(" Input must be a number - try again");
                keyboard.nextLong();
            }
            long nonCheckedCprNumber = keyboard.nextLong();
            ArrayList<Customer> customers = customerController.getCustomerContainer().getCustomerList();
            
            if (customers.isEmpty()) {
            	cprNumber = nonCheckedCprNumber;
            }
            for(Customer customer: customers) {
                if(customer.getCprNumber() == nonCheckedCprNumber){
                    System.out.println(" CPR Number is already used.");
                }
                
                else {
                	cprNumber = nonCheckedCprNumber;
                }
            }
        }
    	
    	keyboard = new Scanner(System.in);
    	System.out.print(" Name: ");
        String name = keyboard.nextLine();
        System.out.print(" Email: ");
        String email = keyboard.nextLine();
        System.out.print(" Phone number: ");
        String phoneNumber = keyboard.nextLine();
        System.out.print(" Address: ");
        String address = keyboard.nextLine();
        System.out.print(" City: ");
        String city = keyboard.nextLine();
        System.out.print(" Zipcode: ");
        int zipCode = getIntegerFromUser(keyboard);
        
		return new Customer(cprNumber, name, email, phoneNumber, address, city, zipCode);
    }

    private Integer getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextLong()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextInt();
	}
}