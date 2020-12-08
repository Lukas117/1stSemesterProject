package Controller;

import java.util.ArrayList;

import Model.SaleContainer;
import Model.Sale;

public class SaleController {
	private SaleContainer saleContainer;
	
	public SaleController() {
		saleContainer = new SaleContainer();
	}
	
	public SaleContainer getSaleContainer() {
		return saleContainer;
	}
	
	public boolean createSale(Sale sale) {
		return saleContainer.addSale(sale);
	}
	
	public Sale findSale(int ID) {
		return saleContainer.findSale(ID);
	}
	
	public Sale updateSale(int ID) {
		return saleContainer.updateSale(ID);
	}
	
	public boolean deleteEmplyee(Sale sale) {
		return saleContainer.deleteSale(sale);
	}
}