package Model;

import java.util.ArrayList;

public class CustomerContainer {
	private static CustomerContainer instance;
	private ArrayList<Customer> customerList;

    private CustomerContainer() {
    	customerList = new ArrayList<>();
    }
    
    public ArrayList<Customer> getCustomerList() {
    	return customerList;
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

    public Customer findCustomer(long cprNumber){
		for (Customer _customer: customerList) {
			if (_customer.getCprNumber() == (cprNumber)) {
				return _customer;
	        }
		}
	    return null;
	}

    public Customer updateCustomer(long cprNumber) {
    	return findCustomer(cprNumber);
    }

    public boolean deleteCustomer(Customer customer) {
    	boolean deletedCustomer = false;
    	
    	Customer customerToDelete = null;
    	for (Customer _customer: customerList) {
            if (_customer.getName().equals(customer.getName())) {           
            	customerToDelete = _customer;
            	deletedCustomer = true;
            }
        }
    	if (deletedCustomer) {
    		customerList.remove(customerToDelete);
    	}
		return deletedCustomer;
    }
    
    public boolean cprCheck(long cpr) {
		boolean foundCpr = false;
		for(Customer x : getCustomerList()) {
			if (x.getCprNumber() == cpr) {
				foundCpr = true;
			}
		}
		return foundCpr;
	}
}