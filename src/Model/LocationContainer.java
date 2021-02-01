package Model;

import java.util.*;
import Controller.DepartmentController;

public class LocationContainer {
	
	private ArrayList<Location> locationList = new ArrayList<> ();
	private static LocationContainer instance;
	private DepartmentController depCont = new DepartmentController();
	private Location loc1;
	private Location loc2;
	private Location loc3;
	private Location loc4;
	private Location loc5;
	private Location loc6;
	
	private LocationContainer() {
		loc1 = new Location(depCont.findDepartment("Kitchen and Bathroom department"),1,1);
		loc2 = new Location(depCont.findDepartment("Kitchen and Bathroom department"),1,2);
		loc3 = new Location(depCont.findDepartment("Kitchen and Bathroom department"),2,1);
		loc4 = new Location(depCont.findDepartment("Timber department"),1,1);
		loc5 = new Location(depCont.findDepartment("Timber department"),1,2);
		loc6 = new Location(depCont.findDepartment("Timber department"),2,1);
		
		
		addLocation(loc1);
		addLocation(loc2);
		addLocation(loc3);
		addLocation(loc4);
		addLocation(loc5);
		addLocation(loc6);
	}
	
	
	public ArrayList<Location> getLocationList() {
		return locationList;
	}
	
	public static LocationContainer getInstance() {
		if(instance == null) {
			instance = new LocationContainer();
		}
		return instance;
	}
	
	public boolean addLocation(Location newLocation) {
		boolean foundLocation = false;
		
		if (locationList.isEmpty()) {
			foundLocation = false;
		}
		for (Location location : locationList) {
			if (location.getDepartment().equals(newLocation.getDepartment()) && location.getAisle()==newLocation.getAisle() && location.getShelf()==newLocation.getShelf()) {
				foundLocation = true;
			}
		}
		if (!foundLocation) {
			locationList.add(newLocation);
		}
		return foundLocation;
	}

	public boolean deleteLocation(Department department, int aisle, int shelf) {
		boolean deletedLocation = false;
		Location locationToDelete = null;
		for(Location location1: locationList) {
			if (location1.getDepartment()==department && location1.getAisle()==aisle && location1.getShelf()==shelf) {
				locationToDelete = location1;
				deletedLocation = true;
			}
		}
		if (deletedLocation) {
			locationList.remove(locationToDelete);
		}
		return deletedLocation;
	}
	
	public Location findLocation(Department department, int aisle, int shelf) {
		Location locationToFind = null;
		for(Location location1 : locationList) {
			if(location1.getDepartment()==department && location1.getAisle()==aisle && location1.getShelf()==shelf) {
				locationToFind = location1;
			}
		}
		return locationToFind;
	}
}

//aisle
//department
//