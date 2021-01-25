package View_GUI;

import java.awt.*;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.LocationController;
import javax.swing.table.DefaultTableModel;

import Model.Department;
import Model.Location;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import Controller.DepartmentController;

public class LocationMenu_GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	protected static final DepartmentController DepartmentController = new DepartmentController();
	protected static final LocationController locationController = new LocationController();
	private JFrame frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationMenu_GUI frame= new LocationMenu_GUI(locationController, DepartmentController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
private JLabel lblNewLabel;
private JLabel lblMinStock;
private JTextField textField_Aisle;
private JButton btnSave;
private JButton btnDelete;
private JScrollPane scrollPane;
private JTextField textField_Shelf;
private JTable table;
private JButton btnBack;

	public LocationMenu_GUI(LocationController locationController, DepartmentController departmentController) {
		/*ProductController productController = new ProductController();
		initialize(); */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			updateTable();
				
			}
		});
		btnLoadTable.setBounds(240, 89, 104, 24);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		/* btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		}); */
		contentPane.setLayout(null);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 437, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Department", "Warehouse", "Aisle", "Shelf"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Location Menu");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		textField_Aisle = new JTextField("0");
		textField_Aisle.setBounds(92, 147, 140, 22);
		textField_Aisle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Aisle);
		textField_Aisle.setColumns(10);
		
		JComboBox comboBox_Warehouse = new JComboBox();
		//JComboBox.setAutoCreateRowSorter(true);
		
		for (Department department: departmentController.getDepartmentContainer().getDepartmentList()) {
			comboBox_Warehouse.addItem(department.getName());
		}
		comboBox_Warehouse.setSelectedItem(null);
		comboBox_Warehouse.setBounds(92, 117, 140, 23);
		contentPane.add(comboBox_Warehouse);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String)comboBox_Warehouse.getSelectedItem();
				int aisle = Integer.parseInt(textField_Aisle.getText());
				int shelf = Integer.parseInt(textField_Shelf.getText());
				
					if(comboBox_Warehouse.getSelectedItem()==null) JOptionPane.showMessageDialog(frame, "***Error! Please select the field!***");
					else if (textField_Aisle.getText().equals("0")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					else if (textField_Shelf.getText().equals("0")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
			if(!textField_Aisle.getText().equals("") && !textField_Shelf.getText().equals("") && comboBox_Warehouse.getSelectedItem()!=null) {
				Location location = new Location(departmentController.findDepartment(value), aisle, shelf);
				if (locationController.addLocation(location)) {
					JOptionPane.showMessageDialog(frame, "Location already exists!");
				}
				else {
					locationController.addLocation(location);
					JOptionPane.showMessageDialog(frame, "Location is created!");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object [] row = {value, departmentController.findDepartment(value).getWarehouse(), String.valueOf(aisle), String.valueOf(shelf)};
					model.addRow(row);
					reset();
				}
					
			} 
			else JOptionPane.showMessageDialog(frame, "***Error!***");	
			}
		});
		btnSave.setBounds(240, 320, 100, 31);
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(577, 320, 100, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					String departmentToDelete = JOptionPane.showInputDialog("Insert the name of the department where the location is: "); 
					String aisleToDelete = JOptionPane.showInputDialog("Insert the number of the aisle: ");
					int aisle = Integer.parseInt(aisleToDelete);
					String rowToDelete = JOptionPane.showInputDialog("Insert the number of the shelf: ");
					int shelf = Integer.parseInt(rowToDelete);
					Location locationToDelete = new Location(null,0,0);
//					boolean delete = false;
					for(Location location: locationController.getLocationContainer().getLocationList()) {
						if(String.valueOf(location.getDepartment()).equals(departmentToDelete) && location.getAisle()==aisle && location.getShelf()==shelf) {
							locationToDelete=location;
//							delete = true;
						}
					}

						locationController.deleteLocation(locationToDelete.getDepartment(), locationToDelete.getAisle(), locationToDelete.getShelf());
						JOptionPane.showMessageDialog(frame, "***Location is deleted!***");
						updateTable();
						((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
				}
			}
		}); 
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnDelete);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(6, 117, 76, 22);
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblDepartment);
		
		JLabel lblName_1_1 = new JLabel("Aisle");
		lblName_1_1.setBounds(6, 147, 76, 22);
		lblName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Shelf");
		lblName_1_1_1.setBounds(6, 177, 76, 22);
		lblName_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1_1);
		
		textField_Shelf = new JTextField("0");
		textField_Shelf.setBounds(92, 177, 140, 22);
		textField_Shelf.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Shelf.setColumns(10);
		contentPane.add(textField_Shelf);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu_GUI.MainMenu();
				closeDialog();
			}
		});
		btnBack.setBounds(587, 400, 90, 23);
		contentPane.add(btnBack);
		
	}
	private void reset() {
		textField_Aisle.setText("");
		textField_Shelf.setText("");
	}
	
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private void updateTable() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		String [] temp = {"","",""};
		for(int i = 0; i<locationController.getLocationContainer().getLocationList().size(); i++) model.addRow(temp);
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<locationController.getLocationContainer().getLocationList().size(); i++) {
			table.setValueAt(locationController.getLocationContainer().getLocationList().get(i).getDepartment().getName(), i, 0);
			table.setValueAt(locationController.getLocationContainer().getLocationList().get(i).getDepartment().getWarehouse(), i, 1);
			table.setValueAt(locationController.getLocationContainer().getLocationList().get(i).getAisle(), i, 2);
			table.setValueAt(locationController.getLocationContainer().getLocationList().get(i).getShelf(), i, 3);
		}
	}
}