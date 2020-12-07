package Model;

public class Employee {
	private String username;
	private String email;
	private String password;
	
	public Employee(String username,String email,String password) {
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
}
