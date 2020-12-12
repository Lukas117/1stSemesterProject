package Controller;

import java.util.*;

import Model.Department;
import Model.Location;
import Model.LocationContainer;

public class LocationController {
	private LocationContainer locationContainer;
	
	private LocationController() {
		locationContainer = LocationContainer.getInstance();
	}
	
	public LocationContainer getLocationContainer() {
		return locationContainer;
	}
	
	public boolean addLocation(Location location) {
		return locationContainer.addLocation(location);
	}
	
	public boolean deleteLocation(Department department, int aisle, int shelf) {
		return locationContainer.deleteLocation(department, aisle, shelf);
	}
}
