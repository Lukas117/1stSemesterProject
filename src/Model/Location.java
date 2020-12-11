package Model;

public class Location {
	
	private String name;
	private String location;
	private String type;
	private int aisle;
	private String warehouse;
	private int shelf;
	
	
	public Location (String name, String location, String type, int aisle, String warehouse, int shelf) {
		this.name = name;
		this.location = location;
		this.type = type;
		this.aisle = aisle;
		this.warehouse = warehouse;
		this.shelf = shelf;
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

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
}