package Model;

import java.util.ArrayList;
import java.util.Random;

public class Product {
	private String name;
    private ArrayList<Integer> barcodes;
    private String type;
    private String location;
    private double price;
    private int stock;


    public Product (String name, String type, String location, double price, int stock){
        this.name = name;
        this.type = type;
        this.price = price;
        this.location = location;
        this.stock = stock;
        barcodes= new ArrayList<>();
    }

    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
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

    public int getBarcode() {
        Random random = new Random();
        return random.nextInt(10000)+1;
    }

    public boolean checkBarcode(ArrayList<Integer> list,int barcode) {
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
