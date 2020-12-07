package Model;

import java.util.ArrayList;

public class EmployeeContainer {
	
	private static EmployeeContainer instance;
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
	private EmployeeContainer() {
		instance = new EmployeeContainer();
	}
		
	public ArrayList<Employee> getEmployees() {
		return employeeList;
	}
	public EmployeeContainer getEmployeeContainer() {
		return instance;
	}
	
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
	
	public void addEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
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
		
	public void deleteEmployee(Employee employee) {
		employeeList.remove(employee);
	}
}

