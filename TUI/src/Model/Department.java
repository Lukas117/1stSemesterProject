package Model;

public class Department {
	private String name;
	private String warehouse;
	
	public Department (String name, String warehouse) {
		this.name = name;
		this.warehouse = warehouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
}
