package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JList;


import Controller.EmployeeController;
import Model.Employee;

import javax.swing.table.DefaultTableModel; 

public class EmployeeMenu_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final EmployeeController employeeController = new EmployeeController();
	private JFrame frame;
	private JPanel contentPane;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMenu_GUI frame= new EmployeeMenu_GUI(employeeController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

private JLabel lblNewLabel;
private final JLabel lblDesignedByMr = new JLabel("Designed By: Mate, Lukas, Marci, Balint");
private JTextField textField_Name;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblUsernameOfEmployee;
private JTextField textField_Username;
private JTextField textField_Email;
private JTextField textField_Password;
private JTable table;

	public EmployeeMenu_GUI(EmployeeController employeeController) {
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
		textFieldSearch.setBounds(465, 86, 117, 22);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(592, 85, 84, 23);
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldSearch.getText();
				Employee employee = employeeController.findEmployee(username);
				for (int i = 0; i < table.getRowCount(); i++) {
				      for(int j = 0; j < table.getColumnCount(); j++) {
				          table.setValueAt("", i, j);
				      }
				   }
				table.setValueAt(employee.getUsername(), 0, 0);
				table.setValueAt(employee.getName(), 0, 1);
				table.setValueAt(employee.getEmail(), 0, 2);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(new Color(255, 248, 220));
		textFieldSearch.setForeground(Color.BLACK);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 437, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username", "Name", "Email"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Employee Menu");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setBounds(240, 378, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(92, 147, 140, 22);
		textField_Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(292, 320, 96, 31);
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String username = textField_Username.getText();
					String name = textField_Name.getText();
					String email = textField_Email.getText();
					String password = textField_Password.getText();
		
						if (username.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				
						else if (name.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
						
						else if (email.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
						
						else if (password.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
						
				if(username.isEmpty()==false && name.isEmpty()==false && email.isEmpty()==false && password.isEmpty()==false) {
					Employee employee = new Employee(username, name, email, password, 0);
					if (employeeController.createEmployee(employee)) {
						JOptionPane.showMessageDialog(frame, "Employee already exists!");
					}
					else {
						employeeController.createEmployee(employee);
						JOptionPane.showMessageDialog(frame, "Employee is created!");
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						String [] row = {username, name, email};
						model.addRow(row);
						reset();
					}
						
				} 
				else JOptionPane.showMessageDialog(frame, "***Error!***");	
			}
			
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(549, 320, 91, 31);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to update!", "Update", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					
					String usernameToupdate = JOptionPane.showInputDialog("Insert the username of the employee: "); 
					employeeController.deleteEmployee(employeeController.findEmployee(usernameToupdate));
					String username = JOptionPane.showInputDialog("Insert the new username of the employee: "); 
					String name = JOptionPane.showInputDialog("Insert the new name of the employee: "); 
					String email = JOptionPane.showInputDialog("Insert the new email of the employee: ");
					String password = JOptionPane.showInputDialog("Insert the new password of the employee: ");
					Employee employee = new Employee(username, name, email, password, 0);
					employeeController.createEmployee(employee);
					updateTable();
		
					
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(424, 320, 96, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					
					String usernameToDelete = JOptionPane.showInputDialog("Insert the username of the employee: "); 
					Employee employee = employeeController.findEmployee(usernameToDelete);
					if(employee == null) {
						JOptionPane.showMessageDialog(frame, "***Employee is not found!***");
					} else {
						employeeController.deleteEmployee(employeeController.findEmployee(usernameToDelete));
						updateTable();
						((DefaultTableModel)table.getModel()).removeRow(table.getRowCount()-1);
					}
				}
			}
		}); 
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnDelete);
		
		lblUsernameOfEmployee = new JLabel("Username of employee:");
		lblUsernameOfEmployee.setBounds(356, 86, 117, 22);
		lblUsernameOfEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblUsernameOfEmployee);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(92, 117, 140, 22);
		textField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Username.setColumns(10);
		contentPane.add(textField_Username);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(6, 117, 76, 22);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Name");
		lblName_1_1.setBounds(6, 147, 76, 22);
		lblName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Email");
		lblName_1_1_1.setBounds(6, 177, 76, 22);
		lblName_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1_1);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(92, 177, 140, 22);
		textField_Email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Email.setColumns(10);
		contentPane.add(textField_Email);
		
		JLabel lblName_1_1_1_1 = new JLabel("Password:");
		lblName_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName_1_1_1_1.setBounds(6, 210, 76, 22);
		contentPane.add(lblName_1_1_1_1);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Password.setColumns(10);
		textField_Password.setBounds(92, 210, 140, 22);
		contentPane.add(textField_Password);
		
	}
	
	private void reset() {
		textField_Username.setText("");
		textField_Name.setText("");
		textField_Email.setText("");
		textField_Password.setText("");
	}
	
	private void updateTable() {
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<employeeController.getEmployeeContainer().getEmployees().size(); i++) {
			table.setValueAt(employeeController.getEmployeeContainer().getEmployees().get(i).getUsername(), i, 0);
			table.setValueAt(employeeController.getEmployeeContainer().getEmployees().get(i).getName(), i, 1);
			table.setValueAt(employeeController.getEmployeeContainer().getEmployees().get(i).getEmail(), i, 2);
		}
	}
	
}