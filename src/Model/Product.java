package Model;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Product {
	private String name;
    private long barcode;
    private String department;
    private int aisle;
    private int shelf;
    private int amountInStock;


    public Product (String name, long barcode, String department, int aisle,
                    int shelf, int amountInStock){
        this.name = name;
        this.barcode = barcode;
        this.department = department;
        this.aisle = aisle;
        this.shelf = shelf;
        this.amountInStock = amountInStock;
    }

    public String getLocation() {
        String x = Integer.toString(aisle);
        String y = Integer.toString(shelf);
        String location = x + "." + y;
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
