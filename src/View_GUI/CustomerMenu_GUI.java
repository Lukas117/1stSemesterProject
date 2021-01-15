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


import Controller.ProductController;
import java.awt.SystemColor; 

public class CustomerMenu_GUI extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel contentPane;
	private JTable table;
	private JList<String> listName;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu_GUI frame= new CustomerMenu_GUI();
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
private JTextField textField_MinimumStock;
private JLabel lblMinimumStock;
private JLabel lblNameOfCustomer;
private JTextField textField_CPRNumber;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;
private JTextField textField_9;
private JLabel lblName_1_1_4;

	/**
	 * Create the application.
	 */
	public CustomerMenu_GUI() {
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
		btnSearch.setBackground(new Color(30, 144, 255));
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
		
		lblNewLabel = new JLabel("Customer Menu");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setBounds(240, 378, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		lblMinimumStock = new JLabel("ZIP Code");
		lblMinimumStock.setBounds(6, 297, 76, 22);
		lblMinimumStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblMinimumStock);
		
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
		btnSave.setBounds(354, 320, 96, 31);
		btnSave.setBackground(Color.YELLOW);
		/*btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "insert into Employeeinfo (EID, Name, SurName, Age) values (?, ?, ?, ?) ";
					PreparedStatement pst = connection.prepareStatement(query);					
					pst.setString(1, textFieldEID.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldSurname.getText());
					pst.setString(4, textFieldAge.getText());					
					pst.execute();					
					JOptionPane.showMessageDialog(null, "Data Saved");					
					pst.close();					
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshTable();
				Reset();
			}
		}); */
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(586, 320, 91, 31);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.GREEN);
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
		btnDelete.setBounds(470, 320, 96, 31);
		btnDelete.setBackground(Color.RED);
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
		
		JButton btnReset = new JButton("New");
		btnReset.setBounds(248, 320, 96, 31);
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.setBackground(Color.BLUE);
		/*btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
			}
		}); */
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnReset);
		
		listName = new JList<String>();
		listName.setBounds(14, 412, 216, 65);
		contentPane.add(listName);
		
		listName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		textField_MinimumStock = new JTextField();
		textField_MinimumStock.setBounds(92, 297, 139, 22);
		textField_MinimumStock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_MinimumStock.setColumns(10);
		contentPane.add(textField_MinimumStock);
		
		lblNameOfCustomer = new JLabel("Name of customer:");
		lblNameOfCustomer.setBounds(356, 86, 117, 22);
		lblNameOfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNameOfCustomer);
		
		textField_CPRNumber = new JTextField();
		textField_CPRNumber.setBounds(92, 117, 140, 22);
		textField_CPRNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_CPRNumber.setColumns(10);
		contentPane.add(textField_CPRNumber);
		
		JLabel lblCprNumb = new JLabel("CPR Numb.");
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
		
		JLabel lblName_1_1_2 = new JLabel("Phone Numb.");
		lblName_1_1_2.setBounds(6, 207, 76, 22);
		lblName_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblName_1_1_2);
		
		JLabel lblName_1_1_3 = new JLabel("Address");
		lblName_1_1_3.setBounds(6, 237, 76, 22);
		lblName_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 177, 140, 22);
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(92, 207, 140, 22);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(92, 237, 140, 22);
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(92, 267, 140, 22);
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_9.setColumns(10);
		contentPane.add(textField_9);
		
		lblName_1_1_4 = new JLabel("City");
		lblName_1_1_4.setBounds(6, 267, 76, 22);
		lblName_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1_4);
		
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
}