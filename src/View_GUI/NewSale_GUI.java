package View_GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import java.util.*;

import Controller.SaleController;
import Controller.ProductController;
import Controller.CustomerController;
import Model.Customer;
import Model.Product;
import Model.Sale;
import View_GUI.AddProduct_GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;  

import Controller.SaleController;

public class NewSale_GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	protected final static ProductController productController = new ProductController();
	protected final static CustomerController customerController = new CustomerController();
	protected final static SaleController saleController = new SaleController();
	private AddProduct_GUI addProduct = new AddProduct_GUI(productController);
	public JFrame frame;
	public JPanel contentPane;
	public static int totPrice;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSale_GUI frame= new NewSale_GUI(customerController, productController, saleController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel lblNewLabel;
	private final JLabel lblDesignedByMr = new JLabel("Designed By: Mate, Lukas, Marci, Balint");
	private JTextField textField_Customer;
	private JButton btnCreate;
	private JButton btnAddProduct;
	private JButton btnDelete;
	public JScrollPane scrollPane;
	private JLabel lblUsernameOfEmployee;
	private JTextField textField_ID;
	private JLabel lblPurchasedate;
	private JLabel lblPaymentDate;
	public static JLabel lbltotalPrice = new JLabel();
	public static JTable table;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	
	public NewSale_GUI(CustomerController customerController, ProductController productController, SaleController saleController) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 438, 192);
		contentPane.add(scrollPane);
		
		//JLabel lbltotalPrice = lbltotalPrice;
		lbltotalPrice.setBounds(92, 237, 140, 22);
	/*	lbltotalPrice.setText(String.valueOf(getSubTotal()));
		JComponent parent = (JComponent) lbltotalPrice.getParent();
		if(parent != null) parent.revalidate(); */
		contentPane.add(lbltotalPrice);
		
		table = new JTable();
	/*	table.getModel().addTableModelListener((TableModelListener) new TableModelListener() {

	        @Override
	        public void tableChanged(TableModelEvent e) {
	            if (e.getType()==TableModelEvent.INSERT) {
	            	if(table.getRowCount()==0) lbltotalPrice.setText("0");
					else lbltotalPrice.setText(String.valueOf(getSubTotal()));
	            }
	        }
	    }); */
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Price per piece", "Total"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Create Sale");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setBounds(240, 408, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		textField_Customer = new JTextField();
		textField_Customer.setBounds(92, 147, 140, 22);
		textField_Customer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Customer);
		textField_Customer.setColumns(10);
		
		JCheckBox chckbxDelivery = new JCheckBox("Delivery");
		chckbxDelivery.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxDelivery.setBounds(92, 267, 100, 22);
		contentPane.add(chckbxDelivery);
		
		
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbltotalPrice.setText(String.valueOf(getSubTotal()));
				String ID = textField_ID.getText();
				int id = Integer.parseInt(ID);
				String customerCPR = textField_Customer.getText();
				long cpr = Long.parseLong(customerCPR);
				String subtotal = lbltotalPrice.getText();
				boolean delivery = true;
				double _subtotal = Double.parseDouble(subtotal);
				LocalDateTime purchaseDate;
				LocalDateTime paymentDate;
				purchaseDate = LocalDateTime.now();
		        String formatDateTime = purchaseDate.format(format);  
				paymentDate = LocalDateTime.now().plusDays(14);
				if (textField_Customer.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");		
				else if (textField_ID.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");				
				if(!textField_Customer.getText().equals("") && !textField_ID.getText().equals("")) {
					//Product product = new Product();
					//ale sale = new Sale(ID, _subtotal, purchaseDate, paymentDeadline, delivery, customer);
					//Sale sale = new Sale(int id double price purchD paymDate boolean del customer arraylist);
					Customer customer = customerController.findCustomer(cpr);
					Sale sale = new Sale(id ,_subtotal, purchaseDate, paymentDate, delivery, customer, addProduct.getShoppingcart());
					saleController.createSale(sale);
					
				/*	for(int i = 0; i<sale.getShoppingCart().size(); i++) {
						int oldStock = productController.findProduct(sale.getShoppingCart().get(i).getName()).getStock();
						int q = sale.getShoppingCart().get(i).getStock();
						productController.findProduct(sale.getShoppingCart().get(i).getName()).setStock(9);
					} */
					DefaultTableModel model = (DefaultTableModel)SaleMenu_GUI.table_1.getModel();
					Object [] row = {ID, customer, _subtotal, formatDateTime};
					model.addRow(row);
					reset();
				}
			}
		});
		btnCreate.setBounds(240, 319, 128, 31);
		btnCreate.setBackground(Color.LIGHT_GRAY);
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnCreate);
		
		btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProduct_GUI.main(null);
			}
		});
		btnAddProduct.setBounds(550, 319, 128, 31);
		btnAddProduct.setForeground(Color.BLUE);
		btnAddProduct.setBackground(Color.LIGHT_GRAY);
		btnAddProduct.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnAddProduct);
		
		btnDelete = new JButton("Delete product");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRowIndex = table.getSelectedRow();
				table.remove(selectedRowIndex);
			}
		});
		btnDelete.setBounds(395, 319, 128, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnDelete);
		
		lblUsernameOfEmployee = new JLabel("Shopping cart");
		lblUsernameOfEmployee.setBounds(240, 85, 96, 22);
		lblUsernameOfEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblUsernameOfEmployee);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(92, 117, 140, 22);
		textField_ID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_ID.setColumns(10);
		contentPane.add(textField_ID);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(6, 117, 76, 22);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblID);
		
		JLabel lblCustomer = new JLabel("Customer's CPR");
		lblCustomer.setBounds(6, 147, 76, 22);
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblCustomer);
		
		JLabel lblPurchaseDate = new JLabel("Purchase date");
		lblPurchaseDate.setBounds(6, 177, 76, 22);
		lblPurchaseDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblPurchaseDate);
		
		JLabel lblPaymentDeadline = new JLabel("Payment deadline");
		lblPaymentDeadline.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblPaymentDeadline.setBounds(6, 207, 84, 22);
		contentPane.add(lblPaymentDeadline);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSubtotal.setBounds(6, 237, 76, 22);
		contentPane.add(lblSubtotal);
		
		JButton btnBack = new JButton("Back");
		/*		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMenu_GUI.main(null);
				closeDialog();
			}
		});  */
		btnBack.setBounds(605, 453, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPurchasedate = new JLabel(LocalDateTime.now().format(format));
		lblPurchasedate.setBounds(92, 177, 140, 22);
		contentPane.add(lblPurchasedate);
		
		JLabel lblPaymentDate = new JLabel(LocalDateTime.now().plusDays(14).format(format));
		lblPaymentDate.setBounds(92, 207, 140, 22);
		contentPane.add(lblPaymentDate);
		
	}
	
	private void reset() {
		textField_ID.setText("");
		textField_Customer.setText("");
	//	lblPurchasedate.setText("");
	//	lblPaymentDate.setText("");
	}
	
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private void updateLabel(JLabel lbltotalPrice) {
		if(table.getRowCount()==0) lbltotalPrice.setText("0");
		else lbltotalPrice.setText(String.valueOf(getSubTotal()));
	}
	
	private double getSubTotal() {
		double total = 0;
		double x;
			for(int i = 0; i<table.getRowCount(); i++) {
				x = Double.parseDouble(table.getValueAt(i, 3).toString());
				total = total + x;
			}
		
		return total;
	}
}