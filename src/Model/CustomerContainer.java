package Model;

import java.util.HashMap;
import java.util.ArrayList;


public class CustomerContainer {
	private static CustomerContainer instance;
	private ArrayList<Customer> customerList = new ArrayList<>();
    //private HashMap<String, Customer> map;

    private CustomerContainer() {
    	//instance = new CustomerContainer();
    }

    public static CustomerContainer getInstance() {
        if(instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }

    public boolean addCustomer(Customer newCustomer) {
		boolean foundCustomer = false;
		
		if (customerList.isEmpty()) {
        	foundCustomer = false;
        }
        for (Customer _customer: customerList) {
            if (_customer.getName().equals(newCustomer.getName())) {
            	foundCustomer = true;
            }
        }
        if (!foundCustomer) {
        	customerList.add(newCustomer);
        }
		return foundCustomer; 
    }

    public Customer findCustomer(String name){

    }

    //public Customer

    public void deleteCustomer(String name) {
        customers.remove(name);
    }
}
