package View_GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


import Controller.DepartmentController;
import Model.Department;
import Model.Employee;

import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel; 

public class DepartmentMenu_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	protected static final DepartmentController departmentController = new DepartmentController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMenu_GUI frame = new DepartmentMenu_GUI(departmentController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

private JLabel lblNewLabel;
private final JLabel lblDesignedByMr = new JLabel("Designed By: Mate, Lukas, Marci, Balint");
private JTextField textField_Warehouse;
private JButton btnSave;
private JButton btnDelete;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblNameOfCustomer;
private JTextField textField_Name;
private JTable table;
private JButton btnBack;

	/**
	 * Create the application.
	 */
	public DepartmentMenu_GUI(DepartmentController departmentController) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			String [] temp = {"","",""};
			model.addRow(temp);
			updateTable();
				
			}
		});
		btnLoadTable.setBounds(240, 84, 104, 24);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(470, 86, 112, 22);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(592, 85, 84, 23);
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setBackground(new Color(255, 255, 240));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textFieldSearch.getText();
				Department department = departmentController.findDepartment(name);
				for (int i = 0; i < table.getRowCount(); i++) {
				      for(int j = 0; j < table.getColumnCount(); j++) {
				          table.setValueAt("", i, j);
				      }
				   }
				table.setValueAt(department.getName(), 0, 0);
				table.setValueAt(department.getWarehouse(), 0, 1);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(new Color(192, 192, 192));
		textFieldSearch.setForeground(Color.BLACK);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 436, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Warehouse"
			}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Department Menu");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		lblDesignedByMr.setBounds(240, 378, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		textField_Warehouse = new JTextField();
		textField_Warehouse.setBounds(92, 147, 140, 22);
		textField_Warehouse.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Warehouse);
		textField_Warehouse.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(408, 320, 100, 31);
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_Name.getText();
				String warehouse = textField_Warehouse.getText();
				if (name.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				
				else if (warehouse.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				else {
					if(name.isEmpty()==false && warehouse.isEmpty()==false) {
						Department department = new Department(name, warehouse);
						departmentController.createDepartment(department);
						JOptionPane.showMessageDialog(frame, "Department created!");
							DefaultTableModel model = (DefaultTableModel)table.getModel();
							String [] departments = {name, warehouse};
							model.addRow(departments);
							Reset();
					}
					else JOptionPane.showMessageDialog(frame, "***Error!***");	
				}
			}
		});
		contentPane.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(576, 320, 100, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					
					String nameToDelete = JOptionPane.showInputDialog("Insert the name of the department: "); 
					Department department = departmentController.findDepartment(nameToDelete);
					if(department == null) {
						JOptionPane.showMessageDialog(frame, "***Department is not found!***");
					} else {
						departmentController.deleteDepartment(departmentController.findDepartment(nameToDelete));
						updateTable();
						((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
					}
				}
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(240, 320, 100, 31);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to update!", "Update", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					String nameToupdate = JOptionPane.showInputDialog("Insert the name of the department: "); 
					departmentController.deleteDepartment(departmentController.findDepartment(nameToupdate));
					String name = JOptionPane.showInputDialog("Insert the new name of the department: ");
					String warehouse = JOptionPane.showInputDialog("Insert the new warehouse of the departemnt: "); 
					Department department = new Department(name, warehouse);
					departmentController.createDepartment(department);
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object [] temp = {"","","","","","",""};
					model.addRow(temp);
					updateTable();	
				}
			}
		});
		contentPane.add(btnUpdate);
		
		lblNameOfCustomer = new JLabel("Name of department:");
		lblNameOfCustomer.setBounds(354, 85, 117, 22);
		lblNameOfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNameOfCustomer);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(92, 117, 140, 22);
		textField_Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Name.setColumns(10);
		contentPane.add(textField_Name);
		
		JLabel lblName = new JLabel("Name"); 
		lblName.setBounds(6, 117, 76, 22);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName);
		
		JLabel lblWarehouse = new JLabel("Warehouse");
		lblWarehouse.setBounds(6, 147, 76, 22);
		lblWarehouse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblWarehouse);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu_GUI.MainMenu();
				closeDialog();
			}
		});
		btnBack.setBounds(605, 453, 89, 23);
		contentPane.add(btnBack);
	}
	
	public void Reset(){
		textField_Name.setText("");
		textField_Warehouse.setText("");
	}
	
	private void updateTable() {
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<departmentController.getDepartmentContainer().getDepartmentList().size(); i++) {
			table.setValueAt(departmentController.getDepartmentContainer().getDepartmentList().get(i).getName(), i, 0);
			table.setValueAt(departmentController.getDepartmentContainer().getDepartmentList().get(i).getWarehouse(), i, 1);
		}
	}
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
}