package Model;

import java.util.*;
import java.time.LocalDateTime;

public class Sale {
	private int id;
    private ArrayList<Product> shoppingCart;
    private double price;
    private LocalDateTime purchaseDate;
    private LocalDateTime paymentDeadline;
    private boolean delivery;
    private Customer customer;

    public Sale (int id, double price, LocalDateTime purchaseDate, LocalDateTime paymentDeadline, boolean delivery, Customer customer, ArrayList<Product> shoppingCart) {
        
    	this.setId(id);
        this.setPrice(price);
        this.setPurchaseDate(purchaseDate);
        this.setPaymentDeadline(paymentDeadline);
        this.setDelivery(delivery);
        this.setCustomer(customer);
        this.setShoppingCart(shoppingCart);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDueTime() {
        return purchaseDate;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.purchaseDate = dueTime;
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

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}