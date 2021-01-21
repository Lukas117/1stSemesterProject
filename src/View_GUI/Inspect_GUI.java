package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import Controller.SaleController;

public class Inspect_GUI {

	private JFrame frame;
	private JTable productTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inspect_GUI window = new Inspect_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inspect_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblSaleTitle = new JLabel("Sale: ");
				//SaleMenu_GUI.saleController.getSaleContainer().getSales().get(SaleMenu_GUI.infoID).getId());
		lblSaleTitle.setBounds(150, 10, 150, 50);
		lblSaleTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSaleTitle);
		
		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setBounds(10, 70, 50, 20);
		frame.getContentPane().add(lblCustomer);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 111, 50, 20);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblPurchaseDate = new JLabel("Purchase date:");
		lblPurchaseDate.setBounds(10, 152, 50, 20);
		frame.getContentPane().add(lblPurchaseDate);
		
		JLabel lblDelivery = new JLabel("Delivery:");
		lblDelivery.setBounds(10, 193, 50, 20);
		frame.getContentPane().add(lblDelivery);
		
		JLabel lblProducts = new JLabel("Products:");
		lblProducts.setBounds(180, 70, 50, 20);
		frame.getContentPane().add(lblProducts);
		
		JLabel lblchangeCustomer = new JLabel(SaleMenu_GUI.saleController.getSaleContainer().getSales().get(SaleMenu_GUI.infoID).getCustomer().getName());
		lblchangeCustomer.setBounds(70, 70, 50, 20);
		frame.getContentPane().add(lblchangeCustomer);
		
		JLabel lblChangePrice = new JLabel(Double.toString(SaleMenu_GUI.saleController.getSaleContainer().getSales().get(SaleMenu_GUI.infoID).getPrice()) + " DKK");
		lblChangePrice.setBounds(70, 111, 50, 20);
		frame.getContentPane().add(lblChangePrice);
		
		LocalDateTime time = SaleMenu_GUI.saleController.getSaleContainer().getSales().get(SaleMenu_GUI.infoID).getPurchaseDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = time.format(formatter);
		
		JLabel lblChangePurchaseDate = new JLabel(formattedString);
		lblChangePurchaseDate.setBounds(70, 152, 50, 20);
		frame.getContentPane().add(lblChangePurchaseDate);
		
		boolean delivery = true;
		String yesOrNo = null;
		if(SaleMenu_GUI.saleController.getSaleContainer().getSales().get(SaleMenu_GUI.infoID).isDelivery() == true) {
			delivery = true;
		}
		else {
			delivery = false;
		}
		if(delivery = true) {
			yesOrNo = "yes";
		}
		else {
			yesOrNo = "no";
		}
		JLabel lblChangeDelivery = new JLabel(yesOrNo);
		lblChangeDelivery.setBounds(70, 193, 50, 20);
		frame.getContentPane().add(lblChangeDelivery);
		
		JButton btnNewButton = new JButton("Create Invoice");
		btnNewButton.setBounds(300, 232, 110, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send in Email");
		btnNewButton_1.setBounds(10, 232, 110, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 90, 230, 132);
		frame.getContentPane().add(scrollPane);
		
		productTable = new JTable();
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity"
			}
		));
		scrollPane.setViewportView(productTable);
	}
}
