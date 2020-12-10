package Model;

public class Location {
	
	private String name;
	private String location;
	private String type;
	private int aisle;
	private String warehouse;
	
	
	public Location (String name, String location, String type, int asile, String warehouse) {
		this.name = name;
		this.location = location;
		this.type = type;
		this.aisle = aisle;
		this.warehouse = warehouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAisle() {
		return aisle;
	}

	public void setAisle(int aisle) {
		this.aisle = aisle;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	


}