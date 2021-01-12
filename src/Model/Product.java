package Model;

import java.util.ArrayList;
import java.util.Random;

public class Product {
	private String name;
    private ArrayList<Integer> barcodes;
    private String type;
    private Location location;
    private double price;
    private int stock;
    private int minStock;
    private int salesCounter;
    private int numberOfItemSold;


    public Product (String name, String type, Location location, double price, int stock, int minStock){
        this.name = name;
        this.type = type;
        this.price = price;
        this.location = location;
        this.stock = stock;
        this.minStock = minStock;
        barcodes= new ArrayList<>();
    }

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
    	return stock;
    }

    public void addBarcodeToList(int barcode) {
        barcodes.add(barcode);
    }

    public ArrayList<Integer> getBarcodeList() {
        return barcodes;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getBarcode() {
        Random random = new Random();
        return random.nextInt(10000)+1;
    }

    public int getNumberOfItemSold() {
        return numberOfItemSold;
    }

    public void setNumberOfItemSold(int numberOfItemSold) {
        this.numberOfItemSold = numberOfItemSold;
    }

    public int getSalesCounter() {
        return salesCounter;
    }

    public void setSalesCounter(int salesCounter) {
        this.salesCounter = salesCounter;
    }

    public boolean checkBarcode(ArrayList<Integer> list, int barcode) {
        boolean exist = false;
        for (int x: list) {
            if(barcode == x) {
            	exist=true;
            }
            else {
            	exist= false;
            }
        }
        return exist;
    }
}