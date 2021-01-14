package Model;

import java.util.ArrayList;

public class SaleContainer {
	private static SaleContainer instance;
	private ArrayList<Sale> saleList;
		
	private SaleContainer() {
		saleList = new ArrayList<>();
	}
	
	public ArrayList<Sale> getSales() {
		return saleList;
	}
	
	public static SaleContainer getInstance() {
		if(instance == null) {
			instance = new SaleContainer();
		}
		return instance;
	}
	
	public boolean addSale(Sale newSale) {
		boolean foundSale = false;
		
		if (saleList.isEmpty()) {
			foundSale = false;
		}
		for (Sale _sale: saleList) {
			if (_sale.getId()==(newSale.getId())) {
				foundSale = true;
			}
		}
		if (!foundSale) {
			saleList.add(newSale);
		}
		return foundSale;
	}
	
	public Sale findSale(int id) {
		for (Sale _sale : saleList) {
			if (_sale.getId()==(id)) {
				return _sale;
			}
		}
		return null;
	}
	
	public Sale updateSale(int id) {
		return findSale(id);
	}
	
	public boolean deleteSale(Sale sale) {
		boolean deletedSale = false;
		Sale saleToDelete = null;
		for (Sale _sale: saleList) {
			if (_sale.getId()==(sale.getId())) {
				saleToDelete = _sale;
				deletedSale = true;
			}
		}
		if (deletedSale) {
			saleList.remove(saleToDelete);
		}
		return deletedSale;
	}
}