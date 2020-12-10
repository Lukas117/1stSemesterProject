package Controller;

import Model.SaleContainer;
import Model.Sale;

public class SaleController {
	private SaleContainer saleContainer;
	
	public SaleController() {
		saleContainer = SaleContainer.getInstance();
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
	
	public boolean deleteSale(Sale sale) {
		return saleContainer.deleteSale(sale);
	}
}