package Model;

public class Location {
	
	private Department department;
	private int aisle;
	private int shelf;
	
	
	public Location (Department department, int aisle, int shelf) {
		this.department = department;
		this.aisle = aisle;
		this.shelf = shelf;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getAisle() {
		return aisle;
	}

	public void setAisle(int aisle) {
		this.aisle = aisle;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
}