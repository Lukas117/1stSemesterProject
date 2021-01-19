package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
//import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import Controller.EmployeeController;
import Model.Employee;

import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel; 

public class EmployeeMenu_GUI extends JFrame{

	protected static final EmployeeController employeeController = new EmployeeController();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel contentPane;
	private JList<String> listName;
	private JLabel lblClock;
 
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
private JLabel lblStock;
private JLabel lblMinStock;
private JTextField textField_Name;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JLabel lblNewLabel_3;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblNameOfCustomer;
private JTextField textField_Username;
private JTextField textField_Email;
private JTextField textField_Password;
private JTable table;

	public EmployeeMenu_GUI(EmployeeController employeeController) {
		/*ProductController productController = new ProductController();
		initialize(); */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//connection = sqliteConnection.dbConnector();
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
		textFieldSearch.setBounds(465, 86, 117, 22);
		/*textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//Search();
			}
		}); */
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(592, 85, 84, 23);
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/* btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		}); */
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
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
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
		
		lblStock = new JLabel("Stock");
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
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
					/*if (username.isEmpty()==true||name.isEmpty()==true||email.isEmpty()==true||password.isEmpty()==true) {
						JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					}
					
					String username;
					String name;
					String email;
					String password; */
		
						if (username.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				
						else if (name.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
						
						else if (email.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
						
						else if (password.isEmpty()==true) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
				if(username.isEmpty()==false && name.isEmpty()==false && email.isEmpty()==false && password.isEmpty()==false) {
					Employee employee = new Employee(username, name, email, password, 0);
					employeeController.createEmployee(employee);
						JOptionPane.showMessageDialog(frame, "Employee is created!");
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						String [] row = {username, name, email};
						model.addRow(row);
						reset();
				} else JOptionPane.showMessageDialog(frame, "***Error!***");	
				
			}
			
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(549, 320, 91, 31);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
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
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(424, 320, 96, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		/*btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(null, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
				try {
					String query = "delete from Employeeinfo where EID = '" + textFieldEID.getText() + "' ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();	
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshTable();
				Reset();
				}
			}
		}); */
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnDelete);
		
		listName = new JList<String>();
		listName.setBounds(14, 412, 216, 65);
		contentPane.add(listName);
		
		listName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lblNameOfCustomer = new JLabel("Name of customer:");
		lblNameOfCustomer.setBounds(356, 86, 117, 22);
		lblNameOfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNameOfCustomer);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(92, 117, 140, 22);
		textField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Username.setColumns(10);
		contentPane.add(textField_Username);
		
		JLabel lblCprNumb = new JLabel("Username");
		lblCprNumb.setBounds(6, 117, 76, 22);
		lblCprNumb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblCprNumb);
		
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
		textField_Username.setText("");
		textField_Name.setText("");
		textField_Email.setText("");
		textField_Password.setText("");
	}
}