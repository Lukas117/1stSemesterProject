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
		int location = locationController.findLocation(aisle);
	}
	
	if (locationController.findLocation(aisle) !=null) {
		System.out.println("----- Location -----");
		System.out.println(" Location: " + ;
		System.out.println(" Name: " + employee.getName());
		System.out.println(" Email: " + employee.getEmail());
		System.out.println(" Password: " + employee.getPassword());
		System.out.println(" Number of sales: " + employee.getSaleCounter() + "\n");
	}
	
 }
