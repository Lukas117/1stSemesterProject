package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.LocationController;
import Model.Department;
import Model.DepartmentContainer;
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
	
	/*
	 * private int writeLocationMenu() { Scanner keyboard = new Scanner(System.in);
	 * 
	 * System.out.println("****** Location menu ******");
	 * System.out.println(" (1) Create location");
	 * System.out.println(" (2) Delete location");
	 * System.out.println(" (0) Go back"); System.out.print("\n Choice: ");
	 * 
	 * int choice = getIntegerFromUser(keyboard); return choice; }
	 * 
	 * public void createLocation() { //Location location = getDataToNewLocation();
	 * 
	 * if (locationController.addLocation(location)) {
	 * System.out.println("Location is already used, try different one"); } else {
	 * locationController.addLocation(location); System.out.println("\n"); }
	 * 
	 * if (locationController.findLocation(aisle) !=null) {
	 * System.out.println("----- Location -----"); } }
	 */
	
	/*
	 * public void deleteLocation() { Scanner keyboard = new Scanner(System.in);
	 * 
	 * System.out.
	 * println("Type the location that you want to delete(department, aisle, shelf):"
	 * ); String department = getStringFromUser(keyboard); int aisle =
	 * getIntegerFromUser(keyboard); int shelf = getIntegerFromUser(keyboard);
	 * Department department1 = null; Department department2 = null; for(Department
	 * department3 : DepartmentContainer.getDepartmentList())
	 * if(department1.getName().equals(department)) { department2 = department1; }
	 * if (locationController.deleteLocation(department2, aisle, shelf)) {
	 * System.out.println("Location deleted!\n"); }
	 * 
	 * else { System.out.println("Location not found.\n"); } }
	 */
		
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
