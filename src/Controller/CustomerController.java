package Controller;

import Model.Customer;
import Model.CustomerContainer;

public class CustomerController {
	private CustomerContainer customerController;
    
    public CustomerController() {
    	customerController = CustomerContainer.getInstance();
    }  
    
	public CustomerContainer getCustomerContainer() {
		return customerController;
	}
	
    public boolean createCustomer(Customer customer) {
    	return customerController.addCustomer(customer);
    }
    
    public Customer findCustomer(long cprNumber) {
    	return customerController.findCustomer(cprNumber);
    }

    public Customer updateCustomer(String name) {
    	return customerController.updateCustomer(name);
    }
    
    public boolean deleteCustomer(Customer employee) {
    	return customerController.deleteCustomer(employee);
    }
}
