package Model;

import java.util.ArrayList;

public class EmployeeContainer {
	private static EmployeeContainer instance;
	private ArrayList<Employee> employeeList;
	private Employee example = new Employee("Balint", "Balint Tamas", "balint.tamas@gmail.com", "123", 0);
	
	private EmployeeContainer() {
		employeeList = new ArrayList<>();
		addEmployee(example);
	}
		
	public ArrayList<Employee> getEmployees() {
		return employeeList;
	}
	
	public static EmployeeContainer getInstance() {
        if(instance == null) {
            instance = new EmployeeContainer();
        }
        return instance;
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
		return findEmployee(username);
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