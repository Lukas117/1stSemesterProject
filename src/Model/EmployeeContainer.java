package Model;

import java.util.ArrayList;

public class EmployeeContainer {
	
	//private static EmployeeContainer instance;
	private ArrayList<Employee> employeeList = new ArrayList<>();
		
	public EmployeeContainer() {
		//instance = new EmployeeContainer();
	}
		
	public ArrayList<Employee> getEmployees() {
		return employeeList;
	}
//	public EmployeeContainer getInstance() {
//		return instance;
//	}
	
	public Employee logIn(String username,String password) {
		for (Employee _employee: employeeList) {
			if (_employee.getUsername().equals(username)) {
				if (_employee.getPassword().equals(password)) {
				return _employee;
				}
	        }
		}
		return null;
	}
	
	public boolean addEmployee(Employee newEmployee) {
		boolean foundEmployee = false;
		
		if (employeeList.isEmpty()) {
        	foundEmployee = false;
        }
        for (Employee _employee: employeeList) {
            if (_employee.getUsername().equals(newEmployee.getUsername())) {
            	foundEmployee = true;
            }
        }
        if (!foundEmployee) {
        	employeeList.add(newEmployee);
        }
		return foundEmployee;
	}
		
	public Employee findEmployee(String username) {
		for (Employee _employee: employeeList) {
			if (_employee.getUsername().equals(username)) {
				return _employee;
	        }
		}
	    return null;
	}

	public Employee updateEmployee(String username) {
		for (Employee _employee :employeeList) {
	        if (_employee.getUsername().equals(username)) {
	        	return _employee;
	        }
		}
		return null;
	}
    		
	public boolean deleteEmployee(Employee employee) {
    	boolean deletedEmployee = false;
    	Employee employeeToDelete = null;
    	for (Employee _employee: employeeList) {
            if (_employee.getUsername().equals(employee.getUsername())) {           
            	employeeToDelete = _employee;
            	deletedEmployee = true;
            }
        }
    	if (deletedEmployee) {
    		employeeList.remove(employeeToDelete);
    	}
		return deletedEmployee;
    }		
}

