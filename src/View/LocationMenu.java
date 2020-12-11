package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.LocationController;
import Model.Employee;
import Model.Location;

public class LocationMenu {
	private LocationController locationController;
	private Location currentLocation;
	
	public LocationMenu(LocationController locationController) {
		this.locationController = locationController;
	}
	
	public LocationController getLocationController() {
		return locationController;
	}
	
	public void start() {
		locationMenu();
	}
	
	private void locationMenu() {
		boolean running = true;
		
		while(running) {
			int choice = writeLocationMenu();
			switch(choice) {
			case 1:
            	createLocation();
                break;
            case 2:
            	findLocation();
             	break;
            case 3:
                updateLocation();
                break;
            case 4:
            	deleteLocation();
                break;
            case 5:
            	showLocation();
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
	
	private int writeLocationMenu()  {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("****** Location menu ******");
        System.out.println(" (1) Create location");
        System.out.println(" (2) Find location");
        System.out.println(" (3) Update location");
        System.out.println(" (4) Delete location");
        System.out.println(" (5) Show location");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
	
	public void createLocation() {
		Location location = getDataToNewLcation();
		
		if (locationController.addLocation(location)) {
			System.out.println("Location is already used, try different one");
		}
		else {
			locationController.addLocation(location);
			System.out.println("\n");
		}
	}
	
	@SuppressWarnings("resource")
	public boolean findLocation() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Location name: ");
		int locaation = locationController.findLocation(aisle);
	}
	
	if (locationController.findLocation(aisle) !=null) {
		System.out.println("----- Location -----");
		System.out.println(" Location: " + ;
		System.out.println(" Name: " + employee.getName());
		System.out.println(" Email: " + employee.getEmail());
		System.out.println(" Password: " + employee.getPassword());
		System.out.println(" Number of sales: " + employee.getSaleCounter() + "\n");
	}
	
	@SuppressWarnings("resource")
	private void updateLocation() {
    	Scanner keyboard = new Scanner(System.in);

    	System.out.print(" Username: ");
    	String username = keyboard.nextLine();
		Employee employee = employeeController.getEmployeeContainer().findEmployee(username);    	
    	
    	if (employeeController.updateEmployee(username) != null) {
    		employeeController.deleteEmployee(employee);

    		System.out.println("Current username " + "[" + employee.getUsername() + "]");
            System.out.print("New username: ");
            username = keyboard.nextLine();
            System.out.println("Current name " + "[" + employee.getName() + "]");
            System.out.print("New name: ");
            String name = keyboard.nextLine();
            System.out.println("Current email " + "[" + employee.getEmail() + "]");
            System.out.print("New email: ");
            String email = keyboard.nextLine();
            System.out.println("Current password " + "[" + employee.getPassword() + "]");
            System.out.print("New password: ");
            String password = keyboard.nextLine();
    		int saleCounter = currentUser.getSaleCounter();
    		
    		employee = new Employee(username, name, email, password, saleCounter);
    		
    		if (employeeController.getEmployeeContainer().addEmployee(employee)) {
        		System.out.println("\n User already exists!\n");
        	}
        	else {
        		employeeController.createEmployee(employee);
        		System.out.println("\n Employee updated! \n");
        	}
    	}
    	else {
    		System.out.println(" Employee not found.\n");
    	}
    }
 }
