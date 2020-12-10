package Model;

import java.util.*;

public class LocationContainer {
	
	private ArrayList<Location> locationList = new ArrayList<> ();
	private static LocationContainer instance;
	
	public ArrayList<Location> getLocationList() {
		return locationList;
	}
	
}
