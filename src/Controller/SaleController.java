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
}
