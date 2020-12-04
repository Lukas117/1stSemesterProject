package Model;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerContainer {
	private static CustomerContainer customerContainer;
    private HashMap<String, Customer> map;

    private CustomerContainer() {
        map = new HashMap<>();
    }

    public void addCustomer() {
        Scanner keyb = new Scanner(System.in);
        String name;
        int ID;
        String group;
        String email;
        String phone;
        String address;
        String city;
        int zipCode;

        System.out.print("Enter name: ");
        name=keyb.nextLine();
        System.out.print("Enter ID: ");
        ID=Integer.parseInt(keyb.nextLine());
        System.out.print("Enter group: ");
        group=keyb.nextLine();
        System.out.print("Enter email: ");
        email=keyb.nextLine();
        System.out.print("Enter phone number: ");
        phone=keyb.nextLine();
        System.out.print("Enter address: ");
        address=keyb.nextLine();
        System.out.print("Enter city: ");
        city=keyb.nextLine();
        System.out.print("Enter zip code: ");
        zipCode=Integer.parseInt(keyb.nextLine());
        map.put(name, new Customer(ID, group, email, phone, address, city, zipCode));
        System.out.println(name + " added to the database!\n");
    }

    public static CustomerContainer instance() {
        if(customerContainer == null) {
            customerContainer = new CustomerContainer();
        }

        return customerContainer;
    }

    public Boolean containsCustomer(String name){
        return map.containsKey(name);
    }

    public Customer findCustomer(String name){
        return map.get(name);
    }

    public void searchForCustomer(String name) {
        Customer customer;
        customer=map.get(name);

        if (customer==null) {
            System.out.println("\nError: Cannot find name!\n");
        }
        else {
            customer.print();
        }
    }

    public void removeCustomer(String name) {
        map.remove(name);
    }
}
