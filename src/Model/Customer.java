package Model;

public class Customer {
	private long cprNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private int zipCode;
    
    public Customer (long cprNumber, String name, String email, String phoneNumber, String address, String city, int zipCode) {
        this.setCprNumber(cprNumber);
    	this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
        this.setCity(city);
        this.setZipCode(zipCode);
    }
    
	public long getCprNumber() {
		return cprNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getName() {
		return name;
	}
	
	public void setCprNumber(long cprNumber) {
		this.cprNumber = cprNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public void setName(String name) {
		this.name = name;
	}
}
