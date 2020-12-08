package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.CustomerController;
import Model.Customer;
import Model.Employee;

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
                	//updateCustomer();
                    break;
                case 4:
                	//deleteCustomer();
                    break;
                case 5:
                	//showCustomers();
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
        	System.out.println(" Username is already taken, try different one");
    	}
    	else {
    		customerController.createCustomer(customer);
    		System.out.println("\n Employee created! \n");
    	}
    }
	
	@SuppressWarnings("resource")
	private void findCustomer() {
		Scanner keyboard = new Scanner(System.in);
    	
    	System.out.print(" Name: ");
    	String name = keyboard.nextLine();
    	
    	Customer customer = customerController.findCustomer(name);    
    	
    	if (customerController.findCustomer(name) != null) {
    		System.out.println("----- Customer -----");
    		System.out.println(" Name: " + name);
    		System.out.println(" Email: " + customer.getEmail() + "\n");
    		//more info
    	}
    	else {
    		System.out.println(" User does not exist!\n");
    	}
	}
	
    @SuppressWarnings("resource")
	private Customer getDataToNewCustomer() {
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.print(" Id: ");
        int id = getIntegerFromUser(keyboard);
        
        keyboard = new Scanner(System.in);
        String name = null;
    	while(name == null){
            
    		System.out.print(" Name: ");
            
            while (!keyboard.hasNextLine()) {
                System.out.println(" Input must be a username - try again");
                keyboard.nextLine();
            }
            String nonCheckedName = keyboard.nextLine();
            ArrayList<Customer> customers = customerController.getCustomerContainer().getCustomerList();
            
            if (customers.isEmpty()) {
                name = nonCheckedName;
            }
            for(Customer customer: customers) {
                if(customer.getName() == nonCheckedName){
                    System.out.println(" Name is already taken, try different one");
                }
                
                else {
                	name = nonCheckedName;
                }
            }
        }
    	
        System.out.print(" Email: ");
        String email = keyboard.nextLine();
        System.out.print(" Phone number: ");
        String phoneNumber = keyboard.nextLine();
        System.out.print(" Address: ");
        String address = keyboard.nextLine();
        System.out.print(" City: ");
        String city = keyboard.nextLine();
        System.out.print(" Zip code: ");
        int zipCode = getIntegerFromUser(keyboard);
        
		return new Customer(id,name,email,phoneNumber,address,city,zipCode);
    }

    private Integer getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextLong()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextInt();
	}
}