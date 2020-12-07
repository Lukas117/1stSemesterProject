package View;

import java.util.Scanner;


public class LoginMenu {
	private MainMenu mainMenu;

	public LoginMenu() {
		mainMenu = new MainMenu();
	}
	
	public void start() {
		logIn();
	}
	
	private void logIn() {
        boolean running = true;
        
        while (running) {
            int choice = writeLogin();
            switch (choice) {
                case 1:
                	login();
                    break;
                case 2:
                	createEmployee();
                    break;
                case 0:
                    System.out.println("\n Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Unknown error, choice = "+choice);
                    break;
            }
        }
    }
	
	@SuppressWarnings("resource")
	private int writeLogin() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Log in ******");
        System.out.println(" (1) Log in");
        System.out.println(" (2) Create an account");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice: ");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
	
//	@SuppressWarnings("resource")
//	private void findEmployee() {
//    	Scanner keyboard = new Scanner(System.in);
//    	
//    	System.out.print(" Username: ");
//    	String username = keyboard.nextLine();
//    	System.out.print(" Password: ");
//    	String password = keyboard.nextLine();
//    	
//    	//if (mainMenu.getEmployeeMenu().getEmployeeController().findEmployee(username,password)) {
//    			for (Employee _employee: mainMenu.getEmployeeMenu().getEmployeeController().getEmployeeContainer().getEmployees()) {
//    				if (_employee.getUsername().equals(username)) {
//    					if (_employee.getPassword().equals(password)) {
//    						System.out.println(" Login succesfull!\n");
//    						mainMenu.start();
//    					}
//    		        }
//    				else {
//    		    		System.out.println(" Wrong username or password!\n");
//    				}
//    			}    			
//    }	
	
	private void login() {
    	if (mainMenu.getEmployeeMenu().logIn()) {
    		mainMenu.start();
    	}
    }
	
	private void createEmployee() {
			mainMenu.getEmployeeMenu().createEmployee();	
	}
}
