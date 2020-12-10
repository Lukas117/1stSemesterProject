package Model;

public class Employee {
	private String username;
	private String name;
	private String email;
	private String password;
	private int saleCounter;
	
	public Employee(String username, String name, String email, String password, int saleCounter) {
		this.setUsername(username);
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setSaleCounter(saleCounter);
	}
	
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public int getSaleCounter() {
		return saleCounter;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	public void setSaleCounter(int newSaleCounter) {
		this.saleCounter = newSaleCounter;
	}
}
