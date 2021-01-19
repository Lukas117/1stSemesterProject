package View_GUI;

import java.awt.EventQueue;
import java.awt.Font;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CustomerController;
import Model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color; 

public class CustomerMenu_GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	protected static final CustomerController customerController = new CustomerController();
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JLabel customerLabel;
	private final JLabel designLabel = new JLabel("Designed By: Mate, Lukas, Marci, Balint");
	private JLabel lblMinStock;
	private JTextField nameText;
	private JButton saveButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JScrollPane scrollPane;
	private JTextField searchText;
	private JButton searchButton;
	private JTextField zipcodeText;
	private JLabel zipcodeLabel;
	private JLabel searchLabel;
	private JTextField cprText;
	private JTextField emailText;
	private JTextField phoneText;
	private JTextField addressText;
	private JTextField cityText;
	private JLabel cityLabel;
    
	public static void CustomerMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu_GUI frame= new CustomerMenu_GUI(customerController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CustomerMenu_GUI(CustomerController customerController) {
		frame = new JFrame("Customer menu");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton loadButton = new JButton("Load Data");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DefaultTableModel model = (DefaultTableModel)table.getModel();
				//String [] temp = {"","","","","","",""};
				//model.addRow(temp);
				updateTable();
			}
		});
		loadButton.setBounds(240, 85, 104, 23);
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loadButton.setForeground(Color.BLACK);
		
		searchText = new JTextField();
		searchText.setBounds(465, 86, 117, 22);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Long cprNumber = Long.parseLong(cprText.getText());
				Customer customer = customerController.findCustomer(cprNumber);
				for (int i = 0; i < table.getRowCount(); i++) {
				      for(int j = 0; j < table.getColumnCount(); j++) {
				          table.setValueAt("", i, j);
				      }
				}
				table.setValueAt(customer.getCprNumber(), 0, 0);
				table.setValueAt(customer.getName(), 0, 1);
				table.setValueAt(customer.getEmail(), 0, 2);
				table.setValueAt(customer.getPhoneNumber(), 0, 3);
				table.setValueAt(customer.getAddress(), 0, 4);
				table.setValueAt(customer.getCity(), 0, 5);
				table.setValueAt(customer.getZipcode(), 0, 6);
			}
		});
		searchButton.setBounds(593, 86, 84, 22);
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(UIManager.getColor("Button.background"));
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setLayout(null);
		contentPane.add(searchButton);
		searchText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		searchText.setBackground(new Color(255, 248, 220));
		searchText.setForeground(Color.BLACK);
		contentPane.add(searchText);
		searchText.setColumns(10);
		contentPane.add(loadButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 437, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cpr number", "Name", "Email", "Phone number", "Address", "City", "Zipcode"
			}
		) {

			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
				
		customerLabel = new JLabel("Customer Menu");
		customerLabel.setBounds(246, 23, 383, 38);
		customerLabel.setForeground(Color.BLACK);
		customerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(customerLabel);
		designLabel.setBounds(10, 455, 233, 22);
		designLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		designLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(designLabel);
		
		zipcodeLabel = new JLabel("ZIP Code");
		zipcodeLabel.setBounds(6, 297, 76, 22);
		zipcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(zipcodeLabel);
		
		new JLabel("Stock");
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		nameText = new JTextField();
		nameText.setBounds(92, 147, 140, 22);
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long cprNumber = Long.parseLong(cprText.getText());
				String name = nameText.getText();
				String email = emailText.getText();
				String phoneNumber = phoneText.getText();
				String address = addressText.getText();
				String city = cityText.getText();
				int zipCode = Integer.parseInt(zipcodeText.getText());
	
					if (cprNumber == 0) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
			
					else if (name.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
					else if (email.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
					else if (phoneNumber.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
					else if (address.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
					else if (city.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
					else if (zipCode == 0) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
			if(cprNumber != 0 && name.isEmpty() == false && email.isEmpty() == false && phoneNumber.isEmpty() == false && address.isEmpty() == false && city.isEmpty() == false && zipCode != 0) {
				Customer customer = new Customer(cprNumber, name, email, phoneNumber, address, city, zipCode);
				if (customerController.createCustomer(customer)) {
					JOptionPane.showMessageDialog(frame, "Customer already exists!");
				}
				else {
					customerController.createCustomer(customer);
					JOptionPane.showMessageDialog(frame, "Customer is created!");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String [] row = {String.valueOf(cprNumber), name, email, phoneNumber, address, city, String.valueOf(zipCode)};
					model.addRow(row);
					reset();
					}		
				} 
				else JOptionPane.showMessageDialog(frame, "***Error!***");	
			}
		});
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(313, 319, 91, 31);
		saveButton.setBackground(UIManager.getColor("Button.background"));
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(saveButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(515, 319, 91, 31);
		updateButton.setForeground(Color.BLACK);
		updateButton.setBackground(UIManager.getColor("Button.background"));

		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(updateButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(414, 319, 91, 31);
		deleteButton.setBackground(UIManager.getColor("Button.background"));
		deleteButton.setForeground(Color.BLACK);

		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(deleteButton);
		
		zipcodeText = new JTextField();
		zipcodeText.setBounds(92, 297, 139, 22);
		zipcodeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		zipcodeText.setColumns(10);
		contentPane.add(zipcodeText);
		
		searchLabel = new JLabel("CPR n. of customer:");
		searchLabel.setBounds(354, 85, 117, 22);
		searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(searchLabel);
		
		cprText = new JTextField();
		cprText.setBounds(92, 117, 140, 22);
		cprText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cprText.setColumns(10);
		contentPane.add(cprText);
		
		JLabel cprLabel = new JLabel("CPR num.");
		cprLabel.setBounds(6, 117, 76, 22);
		cprLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cprLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(6, 147, 76, 22);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(nameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(6, 177, 76, 22);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(emailLabel);
		
		JLabel phoneLabel = new JLabel("Phone num.");
		phoneLabel.setBounds(6, 207, 76, 22);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(phoneLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(6, 237, 76, 22);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(addressLabel);
		
		emailText = new JTextField();
		emailText.setBounds(92, 177, 140, 22);
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailText.setColumns(10);
		contentPane.add(emailText);
		
		phoneText = new JTextField();
		phoneText.setBounds(92, 207, 140, 22);
		phoneText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneText.setColumns(10);
		contentPane.add(phoneText);
		
		addressText = new JTextField();
		addressText.setBounds(92, 237, 140, 22);
		addressText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressText.setColumns(10);
		contentPane.add(addressText);
		
		cityText = new JTextField();
		cityText.setBounds(92, 267, 140, 22);
		cityText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cityText.setColumns(10);
		contentPane.add(cityText);
		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(6, 267, 76, 22);
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cityLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu_GUI.MainMenu();
				closeDialog();
			}
		});
		backButton.setBounds(592, 379, 84, 23);
		contentPane.add(backButton);
	}
	
	private void reset() {
		cprText.setText("");
		nameText.setText("");
		emailText.setText("");
		phoneText.setText("");
		addressText.setText("");
		cityText.setText("");
		zipcodeText.setText("");
	}
	
	private void updateTable() {
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<customerController.getCustomerContainer().getCustomerList().size(); i++) {
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getCprNumber(), i, 0);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getName(), i, 1);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getEmail(), i, 2);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getPhoneNumber(), i, 3);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getAddress(), i, 4);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getCity(), i, 5);
			table.setValueAt(customerController.getCustomerContainer().getCustomerList().get(i).getZipcode(), i, 6);
		}
	}
	
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
}