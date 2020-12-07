package Controller;

import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeContainer;

public class EmployeeController {
	private EmployeeContainer employeeContainer;
    private ArrayList<Employee> employees;
    
    public EmployeeController() {
    	employeeContainer = employeeContainer.getEmployeeContainer();
    	employees = employeeContainer.getEmployees();
    }  
    
    public EmployeeContainer getEmployeeContainer() {
    	return employeeContainer;
    }
    
    public boolean logIn(String username,String password) {
    	boolean foundEmployee = false;
        
    	if (employeeContainer.logIn(username,password) != null) {
    		foundEmployee = true;
        }
        
        return foundEmployee;
    }
    
    public boolean createEmployee(Employee employee) {
        boolean foundEmployee = false;
        
        if (employees.isEmpty()) {
        	foundEmployee = false;
        }
        for (Employee _employee: employees) {
            if (_employee.getUsername().equals(employee.getUsername())) {
            	foundEmployee = true;
            }
        }
        if (!foundEmployee) {
        	employeeContainer.addEmployee(employee);
        }
		return foundEmployee;
    }
    
    public boolean findEmployee(String username) {
    	boolean foundEmployee = false;
        
    	if (employeeContainer.findEmployee(username) != null) {
    		foundEmployee = true;
        }
        
        return foundEmployee;
    }

    
    public boolean updateEmployee(String username) {
        boolean foundEmployee = false;
        
        if (employeeContainer.updateEmployee(username) != null) {
        	foundEmployee = true;
        	}
        
		return foundEmployee;
    }
    
    public boolean deleteEmployee(String username) {
    	boolean foundEmployee = false;
    	Employee employeeToDelete = null;

    	for (Employee _employee: employees) {
            if (_employee.getUsername().equals(username)) {
//                for(int _serialNumber: _player.loans){	for Game Characters
//                    for(Loan loan: loanContainer.loanList){
//                        loan.personCpr = 0;
//                    }
//                }             
            	foundEmployee = true;
            	employeeToDelete = _employee;
            }
        }
        if (foundEmployee) {
        	employeeContainer.deleteEmployee(employeeToDelete);
        }
        
		return foundEmployee;
    }		

}

