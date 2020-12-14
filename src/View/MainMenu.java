package View;

import java.util.Scanner;
import Controller.EmployeeController;
import Controller.ProductController;
import Controller.CustomerController;
import Controller.SaleController;
import Controller.LocationController;
import Controller.DepartmentController;

public class MainMenu {
	private EmployeeController employeeController;
	private EmployeeMenu employeeMenu;
	private ProductController productController;
	private ProductMenu productMenu;
	private CustomerController customerController;
	private CustomerMenu customerMenu;
	private SaleController saleController;
	private SaleMenu saleMenu;
	private DepartmentController departmentController;
	private DepartmentMenu departmentMenu;
	private LocationController locationController;
	private LocationMenu locationMenu;

    
    public MainMenu() {
    	employeeController = new EmployeeController();
    	employeeMenu = new EmployeeMenu(employeeController);
    	productController = new ProductController();
    	productMenu = new ProductMenu(productController);
    	customerController = new CustomerController();
    	customerMenu = new CustomerMenu(customerController);
    	saleController = new SaleController();
    	saleMenu = new SaleMenu(saleController, customerController, productController, employeeMenu);
    	departmentController = new DepartmentController();
    	departmentMenu = new DepartmentMenu(departmentController);
    	locationController = new LocationController();
    	locationMenu = new LocationMenu(locationController, departmentController);
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
                    saleMenu.start();
                    break;
                case 2:
                    productMenu.start();
                    break;
                case 3:
                    employeeMenu.start();
                    break;
                case 4:
                    customerMenu.start();
                    break;
                case 5:
                	departmentMenu.start();
                	break;
                case 6:
                	locationMenu.start();
                	break;
                case 0:
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
        System.out.println(" (5) Department menu");
        System.out.println(" (6) Location menu");
        System.out.println(" (0) Exit the program");
        System.out.print("\n Choice: ");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
}
