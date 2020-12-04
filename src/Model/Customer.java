package Model;
import java.util.Locale;

public class Customer {
	private int ID;
    private String group;
    private String email;
    private String phone;
    private String address;
    private String city;
    private int zipCode;
    public Customer (int ID, String group, String email,
                     String phone, String address, String city, int zipCode) {
        this.ID = ID;
        this.group = group;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipcode(int zipcode) {
        this.zipCode = zipcode;
    }

    public void print(){
        System.out.println("Address: " + getAddress());
        System.out.println("Postal Code: " + getZipCode());
        System.out.println("City: " + getCity());
        System.out.println("Phone number: " + getPhone());
    }
}
