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
//import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JList; 

public class CustomerMenu_GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblClock;
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
					CustomerMenu_GUI frame= new CustomerMenu_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Clock1(){
		Thread clock = new Thread() {
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
	
	public CustomerMenu_GUI() {
		/*ProductController productController = new ProductController();
		initialize(); */
		frame = new JFrame("Customer menu");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton loadButton = new JButton("Load Data");
		loadButton.setBounds(240, 85, 104, 23);
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loadButton.setForeground(Color.BLACK);
		
		searchText = new JTextField();
		searchText.setBounds(465, 86, 117, 22);
		/*textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//Search();
			}
		}); */
		
		searchButton = new JButton("Search");
		searchButton.setBounds(593, 86, 84, 22);
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(UIManager.getColor("Button.background"));
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		/* btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		}); */
		contentPane.setLayout(null);
		
		lblClock = new JLabel("");
		lblClock.setBounds(492, 446, 220, 44);
		contentPane.add(lblClock);
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
		saveButton.setForeground(Color.GREEN);
		saveButton.setBounds(356, 320, 91, 31);
		saveButton.setBackground(UIManager.getColor("Button.background"));
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
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(saveButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(586, 320, 91, 31);
		updateButton.setForeground(Color.BLUE);
		updateButton.setBackground(UIManager.getColor("Button.background"));
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
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(updateButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(470, 320, 91, 31);
		deleteButton.setBackground(UIManager.getColor("Button.background"));
		deleteButton.setForeground(Color.RED);
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
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(deleteButton);
		
		JButton newButton = new JButton("New");
		newButton.setBounds(240, 320, 91, 31);
		newButton.setForeground(Color.BLUE);
		newButton.setBackground(UIManager.getColor("Button.background"));
		/*btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reset();
			}
		}); */
		newButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(newButton);
		
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
		
		JLabel cprLabel = new JLabel("CPR Numb.");
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
		
		JLabel phoneLabel = new JLabel("Phone Numb.");
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
	
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
}