package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.EmployeeController;
import Model.Employee;

public class EmployeeMenu {
	private EmployeeController employeeController;
    private Employee currentUser;
    
    public EmployeeMenu(EmployeeController employeeController) {
       this.employeeController = employeeController;
    }
    
    public EmployeeController getEmployeeController() {
    	return employeeController;
    }
    
    public void start() {
        employeeMenu();
    }
    
    private void employeeMenu() {
        boolean running = true;
        
        while(running) {
            int choice = writeEmployeeMenu();
            switch(choice) {
                case 1: 
                	createEmployee();
                    break;
                case 2:
                	findEmployee();
                 	break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                	deleteEmployee();
                    break;
                case 5:
                	showEmployees();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Unknown error with choice = " + choice);
                    break;
            }
        }
    }
    
    private int writeEmployeeMenu()  {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("****** Employee menu ******");
        System.out.println(" (1) Create employee");
        System.out.println(" (2) Find employee");
        System.out.println(" (3) Update employee");
        System.out.println(" (4) Delete employee");
        System.out.println(" (5) Show employees");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    public boolean checkUser() {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.print(" Username: ");
    	String username = getStringFromUser(keyboard);
    	System.out.print(" Password: ");
    	String password = getStringFromUser(keyboard);
    	
    	if (employeeController.checkUser(username,password) != null) {
			currentUser = employeeController.checkUser(username,password);
    		System.out.println(" Login successfull!\n");
    		return true;
    	}
    	else {
    		System.out.println(" User does not exist!\n");
    	}
		return false;
    }
    
    public Employee getCurrentUser() {
    	return currentUser;
    }
        
    public void createEmployee() {
    	Employee employee = getDataToNewEmployee();
    	
    	if (employeeController.createEmployee(employee)) {
        	System.out.println(" Username is already taken, try different one");
    	}
    	else {
    		employeeController.createEmployee(employee);
    		System.out.println("\n Employee created! \n");
    	}
    }
    
    private void findEmployee() {
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.print(" Username: ");
    	String username = getStringFromUser(keyboard);
    	Employee employee = employeeController.findEmployee(username);    
    	
    	if (employeeController.findEmployee(username) != null) {
    		System.out.println("----- Employee -----");
    		System.out.println(" Username: " + username);
    		System.out.println(" Name: " + employee.getName());
    		System.out.println(" Email: " + employee.getEmail());
    		System.out.println(" Password: " + employee.getPassword());
    		System.out.println(" Number of sales: " + employee.getSaleCounter() + "\n");
    	}
    	else {
    		System.out.println(" User does not exist!\n");
    	}
    }
    
    private void updateEmployee() {
    	Scanner keyboard = new Scanner(System.in);

    	System.out.print(" Username: ");
    	String username = getStringFromUser(keyboard);
		Employee employee = employeeController.getEmployeeContainer().findEmployee(username);    	
    	
    	if (employeeController.updateEmployee(username) != null) {

    		System.out.println("Current username " + "[" + employee.getUsername() + "]");
            System.out.print("New username: ");
            username = getStringFromUser(keyboard);
            System.out.println("Current name " + "[" + employee.getName() + "]");
            System.out.print("New name: ");
            String name = getStringFromUser(keyboard);
            System.out.println("Current email " + "[" + employee.getEmail() + "]");
            System.out.print("New email: ");
            String email = getStringFromUser(keyboard);
            System.out.println("Current password " + "[" + employee.getPassword() + "]");
            System.out.print("New password: ");
            String password = getStringFromUser(keyboard);
    		
            int saleCounter = currentUser.getSaleCounter();
    		
    		employee = new Employee(username, name, email, password, saleCounter);
    		
    		if (employeeController.getEmployeeContainer().addEmployee(employee)) {
        		System.out.println("\n User already exists!\n");
        	}
        	else {
        		employeeController.deleteEmployee(employee);
        		employeeController.createEmployee(employee);
        		System.out.println("\n Employee updated! \n");
        	}
    	}
    	else {
    		System.out.println(" Employee not found.\n");
    	}
    }
    
    private void deleteEmployee() {
    	Scanner keyboard = new Scanner(System.in);;
    	
    	System.out.println(" Write username of the employee that you want to delete:");
    	String username = getStringFromUser(keyboard);
    	Employee employee = employeeController.findEmployee(username);
    	
		if (employeeController.deleteEmployee(employee)) {
    		System.out.println(" Employee deleted!\n");
    	}
    	
    	else {
    		System.out.println(" Employee not found.\n");
    	}	
    }
    
    private void showEmployees() {
    	ArrayList<Employee> employees = employeeController.getEmployeeContainer().getEmployees();
        
        System.out.println("\n****** Registered employees ******");
        for(int i=0; i<employees.size(); i++) {
        	Employee employee = employees.get(i);
            
            System.out.println("����� Employee " + (i+1) + " �����");
            System.out.println("Username: " + employee.getUsername());
            System.out.println("Name: " + employee.getName());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Password: " + employee.getPassword());
            System.out.println("Number of sales: " + employee.getSaleCounter());
            
        }
        System.out.println("**********************************\n");
    }
    
    private Employee getDataToNewEmployee() {
    	Scanner keyboard = new Scanner(System.in);
        String username = null;
        
    	while(username == null){
            
    		System.out.print(" Username: ");
            
    		String nonCheckedUsername = getStringFromUser(keyboard);
            ArrayList<Employee> employees = employeeController.getEmployeeContainer().getEmployees();
            
            if (employees.isEmpty()) {
                username = nonCheckedUsername;
            }
            for(Employee employee: employees) {
                if(employee.getUsername() == nonCheckedUsername){
                    System.out.println(" Username is already taken, try different one");
                }
                else {
                    username = nonCheckedUsername;
                }
            }
        }
    	System.out.print(" Name: ");
        String name = getStringFromUser(keyboard);
        System.out.print(" Email: ");
        String email = getStringFromUser(keyboard);
        System.out.print(" Password: ");
        String password = getStringFromUser(keyboard);
        int saleCounter = 0;
        
		return new Employee(username, name, email, password, saleCounter);
    }
    
    private Integer getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextInt()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextInt();
	}
    
    private String getStringFromUser(Scanner keyboard) {
		String inputToString = null;
		while((inputToString = keyboard.nextLine()).isBlank()) {
  		  System.out.println("You need to type something.");
  		}
		return inputToString;
    }
}