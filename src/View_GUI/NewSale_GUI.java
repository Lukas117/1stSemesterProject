package View_GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import Model.Product;
import Model.Sale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class NewSale_GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JPanel contentPane;
	public static int totPrice = 0;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSale_GUI frame= new NewSale_GUI();
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
	private JTextField textField_PurchaseDate;
	private JTextField textField_PaymentDeadline;
	public static JTable table;
	
	public NewSale_GUI() {
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
		
		table = new JTable();
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
		chckbxDelivery.setBounds(92, 265, 100, 22);
		contentPane.add(chckbxDelivery);
		
		JLabel lbltotalPrice = new JLabel(Integer.toString(totPrice));
		lbltotalPrice.setBounds(92, 237, 140, 22);
		contentPane.add(lbltotalPrice);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = textField_ID.getText();
				String customer = textField_Customer.getText();
				String purchaseDate = textField_PurchaseDate.getText();
				String paymentDeadline = textField_PaymentDeadline.getText();
				String subtotal = lbltotalPrice.getText();
				boolean delivery = true;
				double _subtotal = Double.parseDouble(subtotal);
				if (textField_Customer.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");		
				else if (textField_ID.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");				
				else if (textField_PaymentDeadline.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else if (textField_PurchaseDate.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				if(!textField_Customer.getText().equals("") && !textField_ID.getText().equals("") && !textField_PaymentDeadline.getText().equals("") && !textField_PurchaseDate.getText().equals("")) {
					//Product product = new Product();
					//ale sale = new Sale(ID, _subtotal, purchaseDate, paymentDeadline, delivery, customer);
					DefaultTableModel model = (DefaultTableModel)SaleMenu_GUI.table_1.getModel();
					Object [] row = {ID, customer, _subtotal, purchaseDate};
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
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(6, 147, 76, 22);
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblCustomer);
		
		JLabel lblPurchaseDate = new JLabel("Purchase date");
		lblPurchaseDate.setBounds(6, 177, 76, 22);
		lblPurchaseDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblPurchaseDate);
		
		textField_PurchaseDate = new JTextField();
		textField_PurchaseDate.setBounds(92, 177, 140, 22);
		textField_PurchaseDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_PurchaseDate.setColumns(10);
		contentPane.add(textField_PurchaseDate);
		
		JLabel lblPaymentDeadline = new JLabel("Payment deadline");
		lblPaymentDeadline.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblPaymentDeadline.setBounds(6, 207, 84, 22);
		contentPane.add(lblPaymentDeadline);
		
		textField_PaymentDeadline = new JTextField();
		textField_PaymentDeadline.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_PaymentDeadline.setColumns(10);
		textField_PaymentDeadline.setBounds(92, 207, 140, 22);
		contentPane.add(textField_PaymentDeadline);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSubtotal.setBounds(6, 237, 76, 22);
		contentPane.add(lblSubtotal);
		
	}
	
	private void reset() {
		textField_ID.setText("");
		textField_Customer.setText("");
		textField_PurchaseDate.setText("");
		textField_PaymentDeadline.setText("");
	}
}