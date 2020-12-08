package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.SaleController;
import Model.Sale;

public class SaleMenu {
	private SaleController saleController;
	
	public SaleMenu(SaleController employeeController) {
		this.saleController = saleController;
	}
	
	public SaleController getSaleController() {
		return saleController;
	}
	
	public void start() {
		saleMenu();
	}
	
	private void saleMenu() {
		boolean running = true;
		
		while(running) {
			int choice = writeSaleMeu();
			switch(choice) {
				case 1:
					createSale();
					break;
				case 2:
					findSale();
					break;
				case 3:
					updateSale();
					break;
				case 4:
					deleteSale();
					break;
				case 5:
					showEmployees();
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
	
	private int writeSaleMeu() {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("****** Sale menu ******");
        System.out.println(" (1) Create sale");
        System.out.println(" (2) Find sale");
        System.out.println(" (3) Update sale");
        System.out.println(" (4) Delete sale");
        System.out.println(" (5) Show sale");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");
        
        while (!keyboard.hasNextInt()) {
        	System.out.println(" Input must be a number - try again");
        	keyboard.nextLine();
        }
        
        int choice = keyboard.nextInt();
        return choice;
	}
}
