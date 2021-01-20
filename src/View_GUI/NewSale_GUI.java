package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.table.DefaultTableModel; 

public class NewSale_GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSale_GUI frame= new NewSale_GUI();
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
	private JLabel lblUsernameOfEmployee;
	private JTextField textField_Username;
	private JTextField textField_Email;
	private JTextField textField_Password;
	private JTable table;

	public NewSale_GUI() {
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
		btnLoadTable.setBounds(573, 83, 104, 24);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		contentPane.setLayout(null);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 438, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Price per piece", "Total"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Create Sale");
		lblNewLabel.setBounds(246, 23, 383, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setBounds(240, 465, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(92, 147, 140, 22);
		textField_Name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		btnSave = new JButton("Create");
		btnSave.setBounds(240, 319, 128, 31);
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Add product");
		btnUpdate.setBounds(550, 319, 128, 31);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete product");
		btnDelete.setBounds(395, 319, 128, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnDelete);
		
		lblUsernameOfEmployee = new JLabel("Shopping cart");
		lblUsernameOfEmployee.setBounds(240, 85, 96, 22);
		lblUsernameOfEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblUsernameOfEmployee);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(92, 117, 140, 22);
		textField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Username.setColumns(10);
		contentPane.add(textField_Username);
		
		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(6, 117, 76, 22);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblUsername);
		
		JLabel lblName_1_1 = new JLabel("Customer");
		lblName_1_1.setBounds(6, 147, 76, 22);
		lblName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Purchase date");
		lblName_1_1_1.setBounds(6, 177, 76, 22);
		lblName_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblName_1_1_1);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(92, 177, 140, 22);
		textField_Email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Email.setColumns(10);
		contentPane.add(textField_Email);
		
		JLabel lblName_1_1_1_1 = new JLabel("Payment deadline");
		lblName_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblName_1_1_1_1.setBounds(6, 207, 84, 22);
		contentPane.add(lblName_1_1_1_1);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Password.setColumns(10);
		textField_Password.setBounds(92, 207, 140, 22);
		contentPane.add(textField_Password);
		
		JLabel lblName_1_1_1_1_1 = new JLabel("Subtotal");
		lblName_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName_1_1_1_1_1.setBounds(6, 237, 76, 22);
		contentPane.add(lblName_1_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Delivery");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(92, 265, 100, 22);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(92, 237, 140, 22);
		contentPane.add(lblNewLabel_1);
		
	}
	
	private void reset() {
		textField_Username.setText("");
		textField_Name.setText("");
		textField_Email.setText("");
		textField_Password.setText("");
	}
	
	private void updateTable() {
		
		}
	}