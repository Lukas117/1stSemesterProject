package Model;

import java.util.Random;

public class Customer {
	private int id;
    //private String group;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private int zipCode;
    private String name;
    
    public Customer (int id, String name, String email, String phoneNumber, String address, String city, int zipCode) {
    	id = getId();
        this.setName(name);
        //this.group = group;
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
        this.setCity(city);
        this.setZipCode(zipCode);
    }
    
    

	public int getId() {
		return id;
	}
//	public String getGroup() {
//		return group;
//	}
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
	
	public void randomId() {
		Random rand = new Random ();
        this.id = rand.nextInt(10000)+1;
	}
//	public void setGroup(String group) {
//		this.group = group;
//	}
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
