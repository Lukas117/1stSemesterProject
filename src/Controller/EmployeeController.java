package Controller;

import java.util.ArrayList;
import Model.Employee;
import Model.EmployeeContainer;

public class EmployeeController {
	private EmployeeContainer employeeContainer;
	
    
    public EmployeeController() {
    	employeeContainer = EmployeeContainer.getInstance();
    }  
    
	public EmployeeContainer getEmployeeContainer() {
		return employeeContainer;
	}
	
    public Employee checkUser(String username,String password) {
    	ArrayList<Employee> employeeList = employeeContainer.getEmployees();
    	for (Employee _employee: employeeList) {
			if (_employee.getUsername().equals(username)) {
				if (_employee.getPassword().equals(password)) {
					return _employee;
				}
			}
    	}      
        return null;
    }
    
    public boolean createEmployee(Employee employee) {
    	return employeeContainer.addEmployee(employee);
    }
    
    public Employee findEmployee(String username) {
    	return employeeContainer.findEmployee(username);
    }

    public Employee updateEmployee(String username) {
    	return employeeContainer.updateEmployee(username);
    }
    
    public boolean deleteEmployee(Employee employee) {
    	return employeeContainer.deleteEmployee(employee);
    }
}