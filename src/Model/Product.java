package Model;

public class Product {
	private String name;
    private long barcode;
    private String type;
    private String location;
    private double price;


    public Product (String name, long barcode, String type, String location, double price){
        this.name = name;
        this.barcode = barcode;
        this.type = type;
        this.price = price;
        this.location = location;
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

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
