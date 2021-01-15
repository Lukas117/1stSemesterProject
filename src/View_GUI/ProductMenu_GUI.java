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

public class ProductMenu_GUI extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBoxName;
	private JList<String> listName;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSelect;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMenu_GUI frame= new ProductMenu_GUI();
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
private final JLabel lblDesignedByMr = new JLabel("Designed By: Mr. Dina Chanthan");
private JLabel lblName;
private JLabel lblType;
private JLabel lblPrice;
private JLabel lblStock;
private JLabel lblMinStock;
private JTextField textFieldEID;
private JTextField textFieldName;
private JTextField textFieldSurname;
private JTextField textFieldAge;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JLabel lblNewLabel_3;
private JScrollPane scrollPane;
private JScrollPane scrollPane_1;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblLocation;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;

	/**
	 * Create the application.
	 */
	public ProductMenu_GUI() {
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
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();
		/*textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//Search();
			}
		}); */
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/* btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		}); */
		
		lblClock = new JLabel("");
		lblClock.setBounds(492, 446, 220, 44);
		contentPane.add(lblClock);
		
		comboBoxSelect = new JComboBox();
		comboBoxSelect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"Name", "Type", "Price", "Location", "Stock", "Minimum Stock"}));
		comboBoxSelect.setBounds(354, 85, 96, 23);
		contentPane.add(comboBoxSelect);
		btnSearch.setBounds(592, 85, 84, 23);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(new Color(255, 248, 220));
		textFieldSearch.setForeground(Color.BLACK);
		textFieldSearch.setBounds(465, 86, 117, 22);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 408, 220, 69);
		contentPane.add(scrollPane_1);
		/*listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				refreshTable();
			}
		}); */
		btnLoadTable.setBounds(240, 84, 104, 24);
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
		
		lblNewLabel = new JLabel("Product Menu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(239, 25, 383, 38);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesignedByMr.setBounds(240, 378, 233, 22);
		contentPane.add(lblDesignedByMr);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 149, 65, 31);
		contentPane.add(lblName);
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(10, 179, 65, 31);
		contentPane.add(lblType);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(10, 208, 65, 31);
		contentPane.add(lblPrice);
		
		lblStock = new JLabel("Stock");
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		textFieldEID = new JTextField();
		textFieldEID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldEID.setBounds(75, 154, 157, 22);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldName.setBounds(76, 184, 156, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSurname.setBounds(76, 213, 156, 22);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldAge.setBounds(76, 240, 156, 22);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		btnSave = new JButton("Save");
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
		btnSave.setBounds(354, 320, 96, 31);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
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
		btnUpdate.setBounds(586, 320, 91, 31);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
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
		btnDelete.setBounds(470, 320, 96, 31);
		contentPane.add(btnDelete);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/*comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Employeeinfo where name = ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1, (String)comboBoxName.getSelectedItem());
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
		comboBoxName.setBounds(10, 121, 220, 21);
		contentPane.add(comboBoxName);
		
		JButton btnReset = new JButton("New");
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.setBackground(Color.BLUE);
		/*btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
			}
		}); */
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset.setBounds(248, 320, 96, 31);
		contentPane.add(btnReset);
		
		listName = new JList<String>();
		listName.setBounds(14, 412, 216, 65);
		contentPane.add(listName);
		
		listName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLocation.setBounds(6, 235, 65, 31);
		contentPane.add(lblLocation);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(74, 274, 156, 22);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(75, 308, 156, 22);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_8.setColumns(10);
		textField_8.setBounds(75, 354, 156, 22);
		contentPane.add(textField_8);
		
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