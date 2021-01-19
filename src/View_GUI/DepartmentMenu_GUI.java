package View_GUI;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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


import Controller.DepartmentController;
import Model.Department;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;
import javax.swing.table.DefaultTableModel; 

public class DepartmentMenu_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMenu_GUI frame = new DepartmentMenu_GUI(null);
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
		btnLoadTable.setBounds(240, 84, 104, 24);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(470, 86, 112, 22);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(592, 85, 84, 23);
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.setLayout(null);
		
		lblClock = new JLabel("");
		lblClock.setBounds(492, 446, 220, 44);
		contentPane.add(lblClock);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(new Color(255, 248, 220));
		textFieldSearch.setForeground(Color.BLACK);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 436, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Warehouse"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
		btnSave.setBackground(Color.YELLOW);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_Name.getText();
				String warehouse = textField_Warehouse.getText();
				Department department = new Department(name, warehouse);
				departmentController.createDepartment(department);
				String[] departments = {name, warehouse};
				JOptionPane.showMessageDialog(frame, "Department created!");
			}
		});
		contentPane.add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(576, 320, 100, 31);
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_Name.getText();
				String warehouse = textField_Warehouse.getText();
				Department department = new Department(name, warehouse);
				departmentController.deleteDepartment(department);
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("New");
		btnReset.setBounds(240, 320, 100, 31);
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.setBackground(Color.BLUE);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
			}
		});
		contentPane.add(btnReset);
		
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
	}
	
	public void Reset(){
		textField_Name.setText("");
		textField_Warehouse.setText("");
	}
}