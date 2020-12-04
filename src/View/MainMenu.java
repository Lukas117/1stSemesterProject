package View;

import java.util.Scanner;

public class MainMenu {
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
                    //lpMenu.start();
                    break;
                case 3:
                    //loanMenu.start();
                    break;
                case 4:
                    //copyMenu.start();
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Unknown error, choice = "+choice);
                    break;
            }
        }
    }
    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Borrower menu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Loan menu");
        System.out.println(" (4) Copy menu");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choose:");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
}
