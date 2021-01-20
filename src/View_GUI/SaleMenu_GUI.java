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
import java.awt.Color;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel; 

public class SaleMenu_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
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
					SaleMenu_GUI frame= new SaleMenu_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

private JLabel lblNewLabel;
private final JLabel lblDesignedByMr = new JLabel("Designed By: Mate, Lukas, Marci, Balint");
private JLabel lblMinStock;
private JButton btnSave;
private JButton btnUpdate;
private JButton btnDelete;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel lblNameOfCustomer;
private JTable table_1;

	/**
	 * Create the application.
	 */
	public SaleMenu_GUI() {
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
		btnLoadTable.setBounds(30, 86, 104, 22);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(465, 86, 117, 22);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(594, 86, 84, 22);
		btnSearch.setForeground(Color.WHITE);
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
		scrollPane.setBounds(30, 117, 660, 192);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Customer", "Price", "Purchase date"
			}
		));
		scrollPane.setViewportView(table_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Customer", "Purchase date", "Price", "Delivery"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		lblNewLabel = new JLabel("Sale Menu");
		lblNewLabel.setBounds(169, 24, 380, 38);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblDesignedByMr.setBounds(240, 378, 233, 22);
		lblDesignedByMr.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblDesignedByMr.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesignedByMr);
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		btnSave = new JButton("Update");
		btnSave.setBounds(218, 320, 120, 31);
		btnSave.setBackground(Color.YELLOW);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Inspect");
		btnUpdate.setBounds(570, 320, 120, 31);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(394, 320, 120, 31);
		btnDelete.setBackground(Color.RED);
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("New");
		btnReset.setBounds(30, 319, 120, 31);
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.setBackground(Color.BLUE);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnReset);
		
		listName = new JList<String>();
		listName.setBounds(14, 412, 216, 65);
		contentPane.add(listName);
		
		listName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lblNameOfCustomer = new JLabel("ID of sale:");
		lblNameOfCustomer.setBounds(388, 86, 67, 22);
		lblNameOfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNameOfCustomer);
	}
}