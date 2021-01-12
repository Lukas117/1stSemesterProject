package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.DepartmentController;
import Controller.LocationController;
import Model.Department;
import Model.DepartmentContainer;
import Model.Employee;
import Model.Location;
import Model.LocationContainer;

public class LocationMenu {
	private LocationController locationController;
	private Location currentLocation;
	private DepartmentController departmentController;

	public LocationMenu(LocationController locationController, DepartmentController departmentController ) {
		this.locationController = locationController;
		this.departmentController = departmentController;
	}

	public LocationController getLocationController() {
		return locationController;
	}

	public void start() {
		locationMenu();
	}

	private void locationMenu() {
		boolean running = true;

		while (running) {
			int choice = writeLocationMenu();
			switch (choice) {
			case 1:
				createLocation();
				break;
			case 2:
				deleteLocation();
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

	private int writeLocationMenu() { 
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("****** Location menu ******");
		System.out.println(" (1) Create location");
		System.out.println(" (2) Delete location");
		System.out.println(" (0) Go back"); System.out.print("\n Choice: ");
		
		int choice = getIntegerFromUser(keyboard);
		return choice;
	}
	
	public void createLocation() { 
		Location location = getDataToNewLocation();
		  
		if (locationController.addLocation(location)) {
			System.out.println("Location is already created.");
		}
		else {
			locationController.addLocation(location);
			System.out.println("\n Location is created! \n");
		}
	}
	 
	public void deleteLocation() {
		Scanner keyboard = new Scanner(System.in);
		
	    System.out.println("Type the location that you want to delete(department, aisle, shelf):");
	    String name = getStringFromUser(keyboard);
	    Department department = departmentController.findDepartment(name);
	    int aisle = getIntegerFromUser(keyboard);
	    int shelf = getIntegerFromUser(keyboard);
	    
	    if (locationController.deleteLocation(department, aisle, shelf)) {
	    	System.out.println("Location deleted!\n");
	    }
	    else {
	    	System.out.println("Location not found.\n");
	    }
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
		while ((inputToString = keyboard.nextLine()).isBlank()) {
			System.out.println("You need to type something.");
		}
		return inputToString;
	}
	
	private Location getDataToNewLocation() {
    	Scanner keyboard = new Scanner(System.in);
        String name = null;
        System.out.print("Department: ");
        name = getStringFromUser(keyboard);
        Department department = departmentController.findDepartment(name); //later a checking cycle should be added that checks if the department exists or not
        System.out.print("Aisle: ");
        int nonCheckedAisle = getIntegerFromUser(keyboard);
        System.out.print("Shelf: ");
        int nonCheckedShelf = getIntegerFromUser(keyboard);
        /*ArrayList<Location> locations = locationController.getLocationContainer().getLocationList();
        int aisle = 0;
        int shelf = 0;
        for(Location location: locations) {
        	if(location.getAisle() == nonCheckedAisle && location.getShelf() == nonCheckedShelf){
        		System.out.println("Location already exists!");
            }
        	else {
        		aisle = nonCheckedAisle;
        		shelf = nonCheckedShelf;
        	}
        } */
		return new Location(department, nonCheckedAisle, nonCheckedShelf);
    }
}
