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
private JLabel lblName;
private JLabel lblType;
private JLabel lblPrice;
private JLabel lblStock;
private JLabel lblMinStock;
private JTextField textField_Name;
private JTextField textField_Type;
private JTextField textField_Price;
private JTextField textField_Location;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JLabel lblNewLabel_3;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblLocation;
private JTextField textField_Stock;
private JTextField textField_MinimumStock;
private JLabel lblStock_1;
private JLabel lblMinimumStock;
private JLabel Label_nameOfProduct;
private JLabel lblNewLabel_1;

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
		frame.setBackground(getBackground());
		
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
		lblNewLabel.setBounds(246, 23, 383, 38);
		contentPane.add(lblNewLabel);
		
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
		
		lblStock_1 = new JLabel("Stock");
		lblStock_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStock_1.setBounds(10, 265, 65, 31);
		contentPane.add(lblStock_1);
		
		lblMinimumStock = new JLabel("Minimum Stock");
		lblMinimumStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinimumStock.setBounds(10, 310, 102, 31);
		contentPane.add(lblMinimumStock);
		
		lblStock = new JLabel("Stock");
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Name.setBounds(75, 154, 157, 22);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Type = new JTextField();
		textField_Type.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Type.setBounds(75, 184, 156, 22);
		contentPane.add(textField_Type);
		textField_Type.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Price.setBounds(75, 213, 156, 22);
		contentPane.add(textField_Price);
		textField_Price.setColumns(10);
		
		textField_Location = new JTextField();
		textField_Location.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Location.setBounds(75, 240, 156, 22);
		contentPane.add(textField_Location);
		textField_Location.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
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
		btnUpdate.setBounds(586, 320, 91, 31);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 255, 255));
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
		
		lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLocation.setBounds(6, 235, 65, 31);
		contentPane.add(lblLocation);
		
		textField_Stock = new JTextField();
		textField_Stock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Stock.setColumns(10);
		textField_Stock.setBounds(74, 274, 156, 22);
		contentPane.add(textField_Stock);
		
		textField_MinimumStock = new JTextField();
		textField_MinimumStock.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_MinimumStock.setColumns(10);
		textField_MinimumStock.setBounds(120, 308, 111, 22);
		contentPane.add(textField_MinimumStock);
		
		Label_nameOfProduct = new JLabel("Name of product:");
		Label_nameOfProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Label_nameOfProduct.setBounds(356, 86, 119, 16);
		contentPane.add(Label_nameOfProduct);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/balinttamas/Downloads/industryPic.jpg"));
		lblNewLabel_1.setBounds(0, 0, 718, 496);
		contentPane.add(lblNewLabel_1);
		
		
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