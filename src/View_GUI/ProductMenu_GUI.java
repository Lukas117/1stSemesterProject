package View_GUI;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import Controller.ProductController;
import Controller.LocationController;
import Controller.DepartmentController;
import Model.Product;
import Model.Employee;
import Model.Location;
import Model.Department;

import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent; 

public class ProductMenu_GUI extends JFrame{
	protected static final ProductController productController = new ProductController();
	protected static final LocationController locationController = new LocationController();
	protected static final DepartmentController departmentController = new DepartmentController();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMenu_GUI frame= new ProductMenu_GUI(productController, locationController, departmentController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public void Clock1(){
		
		Thread clock = new Thread()
		{
			public void run(){
				try {
					while(true){
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minute = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					lblClock.setText("Time " + hour +" : "+ minute + " : " + second +" Date " + year + " / " + month + " / " + day );
					sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

Connection connection = null;
private JLabel lblNewLabel;
private JLabel lblName;
private JLabel lblType;
private JLabel lblPrice;
private JLabel lblStock;
private JLabel lblMinStock;
private JTextField textField_Name;
private JTextField textField_Type;
private JTextField textField_Price;
private JTextField textField_Stock;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JLabel lblNewLabel_3;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblDepartment;
private JTextField textField_MinimumStock;
private JLabel lblStock_1;
private JLabel lblMinimumStock;
private JLabel Label_nameOfProduct;

	/**
	 * Create the application.
	 */
	public ProductMenu_GUI(ProductController productController, LocationController locationController, DepartmentController departmentController) {
		/*ProductController productController = new ProductController();
		initialize(); */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(getBackground());
		
		//connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			updateTable();
				
			}
		});
		textFieldSearch = new JTextField();

		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/*public void actionPerformed(ActionEvent arg0) {
			String name = textFieldSearch.getText();
			Product product = productController.findProduct(name);
			for (int i = 0; i < table.getRowCount(); i++) {
			      for(int j = 0; j < table.getColumnCount(); j++) {
			          table.setValueAt("", i, j);
			      }
			   }
			table.setValueAt(employee.getUsername(), 0, 0);
			table.setValueAt(employee.getName(), 0, 1);
			table.setValueAt(employee.getEmail(), 0, 2);
		}
	}); */
		
		lblClock = new JLabel("");
		lblClock.setBounds(492, 446, 220, 44);
		contentPane.add(lblClock);
		btnSearch.setBounds(592, 85, 84, 23);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(new Color(255, 248, 220));
		textFieldSearch.setForeground(Color.BLACK);
		textFieldSearch.setBounds(465, 86, 117, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		/*listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				refreshTable();
			}
		}); */
		btnLoadTable.setBounds(240, 84, 104, 24);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 493, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Type", "Price", "Stock", "Department", "Aisle", "Shelf", "Min. Stock"
			}
		));
		scrollPane.setViewportView(table);
		/*table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String EID = (table.getModel().getValueAt(row, 0).toString());				
					String query = "select * from Employeeinfo where EID = '" + EID + "' ";
					PreparedStatement pst = connection.prepareStatement(query);					
					ResultSet rs = pst.executeQuery();					
					while(rs.next()){
						textFieldEID.setText(rs.getString("EID"));
						textFieldName.setText(rs.getString("Name"));
						textFieldSurname.setText(rs.getString("Surname"));
						textFieldAge.setText(rs.getString("Age"));
					}
					pst.close();					
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}); */
		
		lblNewLabel = new JLabel("Product Menu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(246, 23, 383, 38);
		contentPane.add(lblNewLabel);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 109, 65, 31);
		contentPane.add(lblName);
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(10, 142, 65, 31);
		contentPane.add(lblType);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(10, 175, 65, 31);
		contentPane.add(lblPrice);
		
		lblStock_1 = new JLabel("Stock");
		lblStock_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStock_1.setBounds(10, 208, 65, 31);
		contentPane.add(lblStock_1);
		
		lblMinimumStock = new JLabel("Minimum Stock");
		lblMinimumStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinimumStock.setBounds(10, 334, 102, 31);
		contentPane.add(lblMinimumStock);
		
		lblStock = new JLabel("Stock");
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Name.setBounds(75, 115, 157, 22);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Type = new JTextField();
		textField_Type.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Type.setBounds(74, 148, 156, 22);
		contentPane.add(textField_Type);
		textField_Type.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Price.setBounds(74, 181, 156, 22);
		contentPane.add(textField_Price);
		textField_Price.setColumns(10);
		
		textField_Stock = new JTextField();
		textField_Stock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Stock.setBounds(74, 214, 156, 22);
		contentPane.add(textField_Stock);
		textField_Stock.setColumns(10);
		
		JComboBox comboBox_Shelf = new JComboBox();
		comboBox_Shelf.setBounds(75, 309, 157, 22);
		comboBox_Shelf.setSelectedItem("0");
		contentPane.add(comboBox_Shelf);
		
		JComboBox comboBox_Aisle = new JComboBox();
		comboBox_Aisle.setBounds(75, 280, 155, 22);
		comboBox_Aisle.setSelectedItem("0");
		contentPane.add(comboBox_Aisle);
		
		JComboBox comboBox_Department = new JComboBox();
		comboBox_Department.setBounds(75, 247, 155, 22);
		comboBox_Department.setSelectedItem("");
		contentPane.add(comboBox_Department);
		
		updateComboBox_Dep(comboBox_Department);
		
		comboBox_Department.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateComboBox_Aisle(comboBox_Department, comboBox_Aisle);
			}
			
		});
		
		comboBox_Aisle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateComboBox_Shelf(comboBox_Department, comboBox_Aisle, comboBox_Shelf);
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String name = textField_Name.getText();
			String type = textField_Type.getText();
			String price = textField_Price.getText();
			double _price = Double.parseDouble(price);
			String stock = textField_Stock.getText();
			int _stock = Integer.parseInt(stock);
			String minStock = textField_MinimumStock.getText();
			int _minStock = Integer.parseInt(minStock);
			String department = (String)comboBox_Department.getSelectedItem();
			Department _department = departmentController.findDepartment(department);
			int aisle = (Integer)comboBox_Aisle.getSelectedItem();
		//	int _aisle = Integer.parseInt(aisle);
			int shelf = (Integer)comboBox_Shelf.getSelectedItem();
		//	int _shelf = Integer.parseInt(shelf);
			Location location = locationController.getLocationContainer().findLocation(_department, aisle, shelf);
				if (textField_Name.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");		
				else if (textField_Type.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");				
				else if (textField_Price.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else if (textField_Stock.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else if (textField_MinimumStock.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else if (comboBox_Department.getSelectedItem()==null) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else if (comboBox_Aisle.getSelectedItem()==null) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");				
				else if (comboBox_Shelf.getSelectedItem()==null) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				
				if(!textField_Name.getText().equals("") && !textField_Type.getText().equals("") && !textField_Price.getText().equals("") && !textField_Stock.getText().equals("") && !textField_MinimumStock.getText().equals("") && comboBox_Department.getSelectedItem()!=null && comboBox_Aisle.getSelectedItem()!=null && comboBox_Shelf.getSelectedItem()!=null) {
			Product product = new Product(name, type, location, _price, _stock, _minStock);
			if (productController.createProduct(product)) {
				JOptionPane.showMessageDialog(frame, "Product already exists!");
			}
			else {
				productController.createProduct(product);
				JOptionPane.showMessageDialog(frame, "Product is created!");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				Object [] row = {name, type, price, stock, department, aisle, shelf, minStock};
				model.addRow(row);
				reset();
			}
				
		} 
		else JOptionPane.showMessageDialog(frame, "***Error!***");	
	}
	
});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSave.setBounds(284, 320, 96, 31);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(51, 0, 0));
		btnUpdate.setBackground(new Color(255, 204, 204));
		/*btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "update Employeeinfo set EID = '" + textFieldEID.getText() + "', Name = '" + textFieldName.getText() + "', Surname = '" + textFieldSurname.getText() +"', Age = '" + textFieldAge.getText() + "' where EID = '" + textFieldEID.getText() + "'";
					PreparedStatement pst = connection.prepareStatement(query);									
					pst.execute();				
					JOptionPane.showMessageDialog(null, "Data Updated");	
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshTable();
				Reset();
			}
		}); */
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdate.setBounds(537, 320, 91, 31);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					
					String usernameToDelete = JOptionPane.showInputDialog("Insert the name of the product: "); 
					Product product = productController.findProduct(usernameToDelete);
					if(product == null) {
						JOptionPane.showMessageDialog(frame, "***Product is not found!***");
					} else {
						productController.deleteProduct(productController.findProduct(usernameToDelete));
						updateTable();
						((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
					}
				}
				
			}
		}); 
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.setBounds(415, 320, 96, 31);
		contentPane.add(btnDelete);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDepartment.setBounds(10, 242, 65, 31);
		contentPane.add(lblDepartment);
		
		textField_MinimumStock = new JTextField();
		textField_MinimumStock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_MinimumStock.setColumns(10);
		textField_MinimumStock.setBounds(121, 340, 111, 22);
		contentPane.add(textField_MinimumStock);
		
		Label_nameOfProduct = new JLabel("Name of product:");
		Label_nameOfProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Label_nameOfProduct.setBounds(356, 86, 119, 16);
		contentPane.add(Label_nameOfProduct);
		
		JList barcodeList = new JList();
		barcodeList.setBounds(22, 387, 163, 59);
		contentPane.add(barcodeList);
		
		JLabel lblAisle = new JLabel("Aisle");
		lblAisle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAisle.setBounds(10, 273, 65, 31);
		contentPane.add(lblAisle);
		
		JLabel lblShelf = new JLabel("Shelf");
		lblShelf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblShelf.setBounds(10, 304, 65, 31);
		contentPane.add(lblShelf);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu_GUI.MainMenu();
				closeDialog();
			}
		});
		btnBack.setBounds(655, 446, 89, 23);
		contentPane.add(btnBack);
		
		
		/*lblNewLabel_3 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setBounds(33, 0, 122, 130);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 702, 411);
		contentPane.add(lblNewLabel_1); */
		}
	
	private void reset() {
		textField_Name.setText("");
		textField_Type.setText("");
		textField_Price.setText("");
		textField_Stock.setText("");
		textField_MinimumStock.setText("");
		
	}
	
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private void updateTable() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String [] temp = {"","",""};
		for(int i = 0; i<productController.getProductContainer().getProductList().size(); i++) model.addRow(temp);
		
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<productController.getProductContainer().getProductList().size(); i++) {
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getName(), i, 0);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getType(), i, 1);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getPrice(), i, 2);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getStock(), i, 3);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getDepartment(), i, 4);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getAisle(), i, 5);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getShelf(), i, 6);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getMinStock(), i, 7);
		}
	}
	
	private void updateComboBox_Dep(JComboBox comboBox_Department) {
		ArrayList <String> departments = new ArrayList<>();
		ArrayList <String> finalList = new ArrayList<>();
		for(Location location: locationController.getLocationContainer().getLocationList()) {
			departments.add(location.getDepartment().getName());
		}
		for(int i = 0; i<departments.size(); i++ ) {
			if(!finalList.contains(departments.get(i))) finalList.add(departments.get(i));
		}
		for(int i = 0; i<finalList.size(); i++) comboBox_Department.addItem(finalList.get(i));
	}	
	
	private void updateComboBox_Aisle(JComboBox comboBox_Department, JComboBox comboBox_Aisle) {
		comboBox_Aisle.removeAllItems();
		ArrayList <Integer> aisles = new ArrayList<>();
		ArrayList <Integer> finalList1 = new ArrayList<>();
		String depName = (String) comboBox_Department.getSelectedItem();
		for(Location location: locationController.getLocationContainer().getLocationList()) {
			if(location.getDepartment().getName().equals(depName)) aisles.add(location.getAisle());
		}
		for( int i = 0; i<aisles.size(); i++ ) {
			if(!finalList1.contains(aisles.get(i))) finalList1.add(aisles.get(i));
		}
		for(int i = 0; i<finalList1.size(); i++) comboBox_Aisle.addItem(finalList1.get(i));
	}
	
	private void updateComboBox_Shelf(JComboBox comboBox_Department, JComboBox comboBox_Aisle, JComboBox comboBox_Shelf) {
		comboBox_Shelf.removeAllItems();
		if(comboBox_Aisle.getSelectedItem()==null) comboBox_Shelf.addItem("");
		else {
			ArrayList<Integer> shelves = new ArrayList<>();
			ArrayList <Integer> finalList2 = new ArrayList<>();
			Object aisleName = comboBox_Aisle.getSelectedItem();
			String depName = (String) comboBox_Department.getSelectedItem();
			int aisle = (Integer) aisleName;
			for(Location location: locationController.getLocationContainer().getLocationList()) {
				if(location.getAisle()== aisle && location.getDepartment().getName().equals(depName))
				shelves.add(location.getShelf());
			}
			for( int i = 0; i<shelves.size(); i++ ) {
				if(!finalList2.contains(shelves.get(i))) finalList2.add(shelves.get(i));
			}
			for(int i = 0; i<finalList2.size(); i++) comboBox_Shelf.addItem(finalList2.get(i));
			
		}
	}

}