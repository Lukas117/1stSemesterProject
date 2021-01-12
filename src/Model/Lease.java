package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lease extends Sale{

    private String startDate;
    private int duration;

    public Lease(int id, double price, LocalDateTime purchaseDate, LocalDateTime paymentDeadline, boolean delivery, Customer customer, ArrayList<Product> shoppingCart,String startDate, int duration) {
        super(id, price, purchaseDate, paymentDeadline, delivery, customer, shoppingCart);
        this.startDate = startDate;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
