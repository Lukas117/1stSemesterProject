package Model;

import java.util.*;
import java.time.LocalDateTime;

public class Sale {
	private int ID;
    private String costumer;
    private ArrayList<Integer> listOfProducts;
    private int price;
    private LocalDateTime purchaseDate;
    private LocalDateTime paymentDeadline;
    private String department;

    public Sale (int ID, String costumer, int price, LocalDateTime purchaseDate, String department, LocalDateTime paymentDeadline) {

        this.costumer = costumer;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.department = department;
        listOfProducts = new ArrayList<>();
        this.paymentDeadline = paymentDeadline;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public ArrayList<Integer> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<Integer> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDueTime() {
        return purchaseDate;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.purchaseDate = purchaseDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDateTime paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }
}
