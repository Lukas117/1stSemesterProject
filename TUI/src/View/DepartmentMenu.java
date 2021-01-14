package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.DepartmentController;
import Controller.LocationController;
import Model.Department;
import Model.DepartmentContainer;

public class DepartmentMenu {
	private LocationController locationController;
	private DepartmentController departmentController;
	
	public DepartmentMenu(DepartmentController departmentController) {
		this.departmentController = departmentController;
	}
	
	public DepartmentController getDepartmentController() {
		return departmentController;
	}
	
	public void start() {
		departmentMenu();
	}
	
	private void departmentMenu() {
		boolean running = true;
		
		while (running) {
			int choice = writeDepartmentMenu();
			switch (choice) {
			case 1:
				createDepartment();
				break;
			case 2:
				findDepartment();
				break;
			case 3:
				deleteDepartment();
				break;
			case 4:
				showDepartment();
				break;
			case 0:
				running = false;
				break;
			default:
				System.out.println("Unknown error with choise = " + choice);
				break;
			}
		}
	}
	
	private int writeDepartmentMenu() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("****** Department menu ******");
        System.out.println(" (1) Create department");
        System.out.println(" (2) Find department");
        System.out.println(" (3) Delete department");
        System.out.println(" (4) Show department");
        System.out.println(" (0) Go back"); 
        System.out.print("\n Choice: ");
        
        int choice = getIntegerFromUser(keyboard);
        return choice;
	}

	
	public void createDepartment() {
		Department department = getDataToNewDepartment();
		
		if (departmentController.createDepartment(department)) {
			System.out.println("Department already exists.");
		}
		else {
			departmentController.createDepartment(department);
			System.out.println("\n Department created! \n");
		}
	}
	
	public void findDepartment() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = getStringFromUser(keyboard);
		
		Department department = departmentController.findDepartment(name);
		
		if (departmentController.findDepartment(name) != null) {
			System.out.println("----- Department -----");
			System.out.println("Name: " + department.getName());
		}
		else {
			System.out.println(" Department does not exist!\n");
		}
	}
	
	private void deleteDepartment() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Name of the department that you want to delete: ");
		String name = getStringFromUser(keyboard);
		Department department = departmentController.findDepartment(name);
		if (departmentController.deleteDepartment(department)) {
			System.out.println("Department deleted!");
		}
		else {
			System.out.println(" Department not found.");
		}
	}
	
	private void showDepartment() {
		ArrayList<Department> departments = departmentController.getDepartmentContainer().getDepartmentList();
		
		System.out.println("\n****** Registered Departments *******");
		for(int i=0; i<departments.size(); i++) {
			Department department = departments.get(i);
			
			System.out.println("----- Department number: " + (i+1) + "-----");
			System.out.println("Department name: " + department.getName());
			System.out.println("Department warehouse: " + department.getWarehouse());
		}
		System.out.println("************************\n");
	}
	
	private Department getDataToNewDepartment() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Department name: ");
		String name = getStringFromUser(keyboard);
		System.out.print("Warehouse: ");
		String warehouse = getStringFromUser(keyboard);
		
		return new Department(name, warehouse);
	}
	
	private Integer getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextInt()) {
    		System.out.println("Input must be a number - try again");
    		keyboard.nextLine();
    	}
    	return keyboard.nextInt();
	}
	private String getStringFromUser(Scanner keyboard) {
		while (!keyboard.hasNextLine()) {
			System.out.println("Input must be a word - try again");
			keyboard.nextLine();
		}
		return keyboard.next();
	}
}
