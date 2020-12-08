package View;

import java.util.Scanner;
import Controller.EmployeeController;
import Controller.ProductController;

public class MainMenu {
	private EmployeeController employeeController;
	private EmployeeMenu employeeMenu;
	private ProductController productController;
	private ProductMenu productMenu;
    
    public MainMenu() {
    	employeeController = new EmployeeController();
    	employeeMenu = new EmployeeMenu(employeeController);
    	productController = new ProductController();
    	productMenu = new ProductMenu(productController);
    }
   public EmployeeMenu getEmployeeMenu()
   {
	   return employeeMenu;
   }
    
	public void start() {
        mainMenu();
    }

    private void mainMenu() {
        boolean running = true;
        
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                    //borrowerMenu.start();
                    break;
                case 2:
                    productMenu.start();
                    break;
                case 3:
                    employeeMenu.start();
                    break;
                case 4:
                    //copyMenu.start();
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
	private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Sale menu");
        System.out.println(" (2) Product menu");
        System.out.println(" (3) Employee menu");
        System.out.println(" (4) Customer menu");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice: ");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
}
