package Controller;

import java.util.*;
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
	
	public Location findLocation(int aisle) {
		return locationContainer.findLocation(aisle);
	}
	
	public boolean deleteLocation(int aisle) {
		return locationContainer.deleteLocation(aisle);
	}
}
