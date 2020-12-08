package Model;

import java.util.ArrayList;

public class SaleContainer {
	private ArrayList<Sale> saleList = new ArrayList<>();
	
	public SaleContainer() {
		//instance = new SaleContainer();
	}
	
	public ArrayList<Sale> getSales() {
		return saleList;
	}
}
