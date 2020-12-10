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
			if (location.getLocation().equals(newLocation.getLocation())) {
				foundLocation =true;
			}
		}
		if (!foundLocation) {
			locationList.add(newLocation);
		}
		return foundLocation;
	}
	
	public Location findLocation(int aisle) {
		for(Location location : locationList) {
			if(location.getAisle()==(aisle)) {
				return location;
			}
		}
		return null;
	}
	
	public boolean deleteLocation(int aisle) {
		boolean deletedLocation = false;
		Location locationToDelete = null;
		for(Location location1: locationList) {
			if (location1.getAisle()==(aisle)) {
				locationToDelete = location1;
				deletedLocation = true;
			}
		}
		if (deletedLocation) {
			locationList.remove(locationToDelete);
		}
		return deletedLocation;
	}
}

//aisle
//department
//