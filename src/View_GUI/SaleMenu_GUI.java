package View_GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import Model.Employee;
import Model.Sale; 
import Controller.SaleController;

public class SaleMenu_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JPanel contentPane;
	public static JTable table_1;
	private JList<String> listName;
	private JLabel lblClock;
	protected static final SaleController saleController = new SaleController();
	private int infoID1;
	public static int infoID;

	/**
	 * Launch the application.
	 */    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleMenu_GUI frame= new SaleMenu_GUI(null);
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

	/**
	 * Create the application.
	 */
	public SaleMenu_GUI(SaleController saleController) {
		/*ProductController productController = new ProductController();
		initialize(); */
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
		btnLoadTable.setBounds(30, 86, 104, 22);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(470, 86, 117, 22);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(600, 86, 90, 22);
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.setLayout(null);
		
		lblClock = new JLabel("");
		lblClock.setBounds(492, 446, 220, 44);
		contentPane.add(lblClock);
		contentPane.add(btnSearch);
		textFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSearch.setBackground(Color.WHITE);
		textFieldSearch.setForeground(Color.BLACK);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 117, 660, 192);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				int selectedRowIndex = table_1.getSelectedRow();
				infoID1 = (Integer) model.getValueAt(selectedRowIndex, 0);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Customer's CPR", "Price", "Purchase date"
			}
		));
		scrollPane.setViewportView(table_1);
		infoID = infoID1;
		
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
		btnSave.setForeground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(218, 320, 120, 31);
		btnSave.setBackground(Color.LIGHT_GRAY);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Inspect");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inspect_GUI.main(null);
			}
		});
		btnUpdate.setBounds(570, 320, 120, 31);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(frame, "Do you want to delete!", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0){
					
					String saleIdToDelete = JOptionPane.showInputDialog("Insert the ID of the sale: "); 
					Sale sale = saleController.findSale(Integer.parseInt(saleIdToDelete));
					if(sale == null) {
						JOptionPane.showMessageDialog(frame, "***Sale is not found!***");
					} else {
						saleController.deleteSale(saleController.findSale(Integer.parseInt(saleIdToDelete)));
						updateTable();
						((DefaultTableModel)table_1.getModel()).removeRow(table_1.getRowCount()-1);
					}
				}
			}
		});
		btnDelete.setBounds(394, 320, 120, 31);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnDelete);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewSale_GUI.main(null);;
			}
		});
		btnNew.setBounds(30, 319, 120, 31);
		btnNew.setForeground(Color.BLACK);
		btnNew.setBackground(Color.LIGHT_GRAY);
		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNew);
		
		listName = new JList<String>();
		listName.setBounds(14, 412, 216, 65);
		contentPane.add(listName);
		
		listName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lblNameOfCustomer = new JLabel("ID of sale:");
		lblNameOfCustomer.setBounds(400, 86, 67, 22);
		lblNameOfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(lblNameOfCustomer);
	}
	
	private void updateTable() {
		for (int i = 0; i < table_1.getRowCount(); i++) {
		      for(int j = 0; j < table_1.getColumnCount(); j++) {
		    	  table_1.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<saleController.getSaleContainer().getSales().size(); i++) {
			table_1.setValueAt(saleController.getSaleContainer().getSales().get(i).getId(), i, 0);
			table_1.setValueAt(saleController.getSaleContainer().getSales().get(i).getCustomer().getCprNumber(), i, 1);
			table_1.setValueAt(saleController.getSaleContainer().getSales().get(i).getPrice(), i, 2);
			table_1.setValueAt(saleController.getSaleContainer().getSales().get(i).getPurchaseDate(), i, 3);
		}
	}
}