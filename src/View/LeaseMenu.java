package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.SaleController;
import Controller.ProductController;
import Controller.CustomerController;
import Controller.LeaseController;
import Model.Lease;
import Model.Sale;
import Model.Customer;
import Model.Product;
import java.time.LocalDateTime;

public class LeaseMenu {
    private SaleController saleController;
    private CustomerController customerController;
    private ProductController productController;
    private LeaseController leaseController;
    private EmployeeMenu employeeMenu;
    private CustomerMenu customerMenu;

    public LeaseMenu(SaleController saleController, CustomerController customerController, ProductController productController, EmployeeMenu employeeMenu, CustomerMenu customerMenu, LeaseController leaseController) {
        this.leaseController = leaseController;
        this.saleController = saleController;
        this.customerController = customerController;
        this.productController = productController;
        this.employeeMenu = employeeMenu;
        this.customerMenu = customerMenu;
    }

    public void start() {
        leaseMenu();
    }

    private void leaseMenu() {
        boolean running = true;

        while (running) {
            int choice = writeLeaseMenu();
            switch (choice) {
                case 1:
                    createLease();
                    break;
                case 2:
                    findLease();
                    break;
                case 3:
                    updateLease();
                    break;
                case 4:
                    deleteLease();
                    break;
                case 5:
                    showLease();
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

    private int writeLeaseMenu() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("****** Lease menu ******");
        System.out.println(" (1) Create lease");
        System.out.println(" (2) Find lease");
        System.out.println(" (3) Update lease");
        System.out.println(" (4) Delete lease");
        System.out.println(" (5) Show leases");
        System.out.println(" (0) Go back");
        System.out.print("\n Choice: ");

        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private void createLease() {
        Lease lease = getDataToNewLease();

        if (saleController.createSale(lease)) {
            System.out.println("Sale already exists.");
        } else {
            saleController.createSale(lease);
            employeeMenu.getCurrentUser().setSaleCounter(employeeMenu.getCurrentUser().getSaleCounter() + 1);
            System.out.println("\n Sale created! \n");
        }
    }

    private void findLease() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("ID: ");
        int id = getIntegerFromUser(keyboard);
        Lease lease = leaseController.findLease(id);

        if (leaseController.findLease(id) != null) {
            System.out.println("----- Lease -----");
            System.out.println("ID: " + lease.getId());
            System.out.println("Customer name: " + lease.getCustomer().getName());
            System.out.println("Customer's CPR number: " + lease.getCustomer().getCprNumber());
            System.out.println("Total price: " + lease.getPrice() + " dkk");
            System.out.print("Items: ");
            for (Product item : lease.getShoppingCart()) {
                System.out.println("	Name: " + item.getName() + " Quantity: " + item.getBarcodeList().size());
            }
            System.out.print("Delivery: ");
            if (lease.isDelivery()) {
                System.out.println("Yes. Item will be delivered.\n");
            } else {
                System.out.println("No. Pick up at the store.\n");
            }
            System.out.println("Start date (DD/MM/YYYY): " + lease.getStartDate());
            System.out.println("Duration in days: " + lease.getDuration());
        } else {
            System.out.println(" Sale does not exist.\n");
        }
    }

    private void updateLease() {
        Scanner keyboard = new Scanner(System.in);

        LocalDateTime purchaseDate = null;
        LocalDateTime paymentDeadline = null;
        boolean dispatchable = false;
        Customer customer = null;
        ArrayList<Product> cart = new ArrayList<>();

        System.out.println("ID: ");
        int id = getIntegerFromUser(keyboard);
        Lease lease = leaseController.getLeaseContainer().findLease(id);

        if (leaseController.updateLease(id) != null) {
            leaseController.deleteLease(lease);

            System.out.println("Current ID " + "[" + lease.getId() + "]");
            System.out.println("Write the new ID: ");
            id = getIntegerFromUser(keyboard);
            System.out.println("Current price " + "[" + lease.getPrice() + "]");
            System.out.println("New price: ");
            double price = getDoubleFromUser(keyboard);
            System.out.println("Current start date (DD/MM/YYYY): " + "[" + lease.getStartDate() + "]");
            String startDate = getStringFromUser(keyboard);
            System.out.println("Current duration in days: " + "[" + lease.getDuration() + "]");
            int duration = getIntegerFromUser(keyboard);

            lease = new Lease(id, price, purchaseDate, paymentDeadline, dispatchable, customer, cart, startDate, duration);

            if (leaseController.getLeaseContainer().addLease(lease)) {
                System.out.println("\n Lease already exists!\n");
            } else {
                leaseController.createLease(lease);
                System.out.println("\nLease updated.\n");
            }
        } else {
            System.out.println(" Lease not found.\n");
        }
    }

    private void deleteLease() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(" ID of the lease that you want to delete: ");
        int id = getIntegerFromUser(keyboard);
        Lease lease = leaseController.findLease(id);
        if (leaseController.deleteLease(lease)) {
            System.out.println(" Lease deleted!");
        } else {
            System.out.println(" Lease not found.");
        }
    }

    private void showLease() {
        ArrayList<Lease> leases = leaseController.getLeaseContainer().getLeases();

        System.out.println("\n****** Registered Leases *******");
        for (int i = 0; i < leases.size(); i++) {
            Lease lease = leases.get(i);

            System.out.println("----- Lease number: " + (i + 1) + "-----");
            System.out.println("Lease ID: " + lease.getId());
            System.out.println("Price: " + lease.getPrice() + " dkk");
            System.out.println("Customer's CPR number: " + lease.getCustomer().getCprNumber());
            System.out.print("Items: ");
            for (Product item : lease.getShoppingCart()) {
                System.out.println("	Name: " + item.getName() + " Quantity: " + item.getStock());
            }
            System.out.println("Start date (DD/MM/YYYY): " + lease.getStartDate());
            System.out.println("Duration in days: " + lease.getDuration());
        }
        System.out.println("************************\n");
    }

    private Lease getDataToNewLease() {
        Scanner keyboard = new Scanner(System.in);
        int id = 0;
        LocalDateTime purchaseDate = null;
        LocalDateTime paymentDeadline = null;
        Customer customer = null;
        ArrayList<Product> shoppingCart = new ArrayList<>();
        String startDate = null;
        int duration = 0;

        while (id == 0) {

            System.out.print(" ID: ");

            int nonCheckedId = getIntegerFromUser(keyboard);
            ArrayList<Sale> saleList = saleController.getSaleContainer().getSales();

            if (saleList.isEmpty()) {
                id = nonCheckedId;
            }
            for (Sale _sale : saleList) {
                if (_sale.getId() == nonCheckedId) {
                    System.out.println(" ID is already taken, try different one");
                } else {
                    id = nonCheckedId;
                }
            }
        }

        System.out.print(" Customer's CPR number: ");
        long cprNumber = getLongFromUser(keyboard);
        if (!customerController.cprCheck(cprNumber)) {

            System.out.println(" Customer does not exist, please create customer.");
            customerMenu.createCustomer();
            customer = customerController.findCustomer(cprNumber);
        } else {
            customer = customerController.findCustomer(cprNumber);
        }

        int choice = 0;
        while (choice != 2) {
            keyboard = new Scanner(System.in);
            System.out.print(" Name of the product: ");
            String name = getStringFromUser(keyboard);
            System.out.print(" Number of products: ");
            int numberOfProducts = getIntegerFromUser(keyboard);
            shoppingCart.add(addProductToCart(name, numberOfProducts));
            System.out.println("Start date of the lease: (DD/MM/YYYY)");
            startDate = getStringFromUser(keyboard);
            System.out.println("Duration of the lease in days: ");
            duration = getIntegerFromUser(keyboard);
            System.out.println(" (1) Add more products");
            System.out.println(" (2) Finish");
            System.out.print(" Choice: ");
            choice = getIntegerFromUser(keyboard);
        }

        double totalPrice = getTotalPrice(shoppingCart);
        boolean delivery = getDelivery();


        return new Lease(id, totalPrice, null, null, delivery, customer, shoppingCart, startDate, duration);
    }

    private Product addProductToCart(String name, int numberOfProducts) {
        Product product = productController.findProduct(name);
        Product temp;
        while (!productController.stockCheck(numberOfProducts, product)) {
            System.out.println(" Not enough in stock.");
            Scanner keyboard = new Scanner(System.in);
            numberOfProducts = getIntegerFromUser(keyboard);
        }
        productController.removeFromStock(name, numberOfProducts);
        temp = product;
        temp.setStock(numberOfProducts);
        return temp;
    }

    private double getTotalPrice(ArrayList<Product> shoppingCart) {
        double total = 0;
        for (Product item : shoppingCart) {
            total += (item.getPrice() * item.getStock());
        }
        return total;
    }

    private boolean getDelivery() {
        boolean delivery = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.print(" Delivery (1 Yes/2 No): ");
        int option = getIntegerFromUser(keyboard);
        switch (option) {
            case 1:
                delivery = true;
                break;
            case 2:
                delivery = false;
                break;
            default:
                System.out.println(" Option not available.");
                break;
        }
        return delivery;
    }

    private Double getDoubleFromUser(Scanner keyboard) {
        while (!keyboard.hasNextDouble()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        return keyboard.nextDouble();
    }

    private Long getLongFromUser(Scanner keyboard) {
        while (!keyboard.hasNextLong()) {
            System.out.println("Input must be a number - try again");
            keyboard.nextLine();
        }
        return keyboard.nextLong();
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
        while ((inputToString = keyboard.nextLine()).isBlank()) {
            System.out.println("You need to type something.");
        }
        return inputToString;
    }
}

