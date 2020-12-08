package Model;

import java.util.*;
import java.time.LocalDateTime;

public class Sale {
	private int ID;
    private ArrayList<Integer> listOfProducts;
    private int price;
    private LocalDateTime purchaseDate;
    private LocalDateTime paymentDeadline;
    private String department;
    private boolean dispatchable;//in store or delivery

    public Sale (int ID, int price) {

        this.price = price;
        this.purchaseDate = purchaseDate;
        this.department = department;
        listOfProducts = new ArrayList<>();
        this.paymentDeadline = paymentDeadline;
        this.ID = ID;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        this.purchaseDate = dueTime;
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

	public boolean isDispatchable() {
		return dispatchable;
	}

	public void setDispatchable(boolean dispatchable) {
		this.dispatchable = dispatchable;
	}
    
}
