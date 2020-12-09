package Model;

import java.util.ArrayList;

public class CustomerContainer {
	private static CustomerContainer instance;
	private ArrayList<Customer> customerList = new ArrayList<>();
    //private HashMap<String, Customer> map;

    private CustomerContainer() {
    	//instance = new CustomerContainer();
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
    	for (Customer _employee: customerList) {
            if (_employee.getName().equals(customer.getName())) {           
            	customerToDelete = _employee;
            	deletedCustomer = true;
            }
        }
    	if (deletedCustomer) {
    		customerList.remove(customerToDelete);
    	}
		return deletedCustomer;
    }
}
