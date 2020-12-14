package Controller;

import Model.Customer;
import Model.CustomerContainer;

public class CustomerController {
	private CustomerContainer customerContainer;
    
    public CustomerController() {
    	customerContainer = CustomerContainer.getInstance();
    }  
    
	public CustomerContainer getCustomerContainer() {
		return customerContainer;
	}
	
    public boolean createCustomer(Customer customer) {
    	return customerContainer.addCustomer(customer);
    }
    
    public Customer findCustomer(long cprNumber) {
    	return customerContainer.findCustomer(cprNumber);
    }

    public Customer updateCustomer(long cprNumber) {
    	return customerContainer.updateCustomer(cprNumber);
    }
    
    public boolean deleteCustomer(Customer customer) {
    	return customerContainer.deleteCustomer(customer);
    }
    
    public boolean cprCheck(long cpr) {
    	return customerContainer.cprCheck(cpr);
    }
}
