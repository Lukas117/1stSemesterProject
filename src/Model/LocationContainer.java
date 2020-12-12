package Model;

import java.util.*;

public class LocationContainer {
	
	private ArrayList<Location> locationList = new ArrayList<> ();
	private static LocationContainer instance;
	
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
			foundLocation = true;
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