package View_GUI;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Controller.ProductController;
import Model.Product;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddProduct_GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblClock;
	protected static final ProductController productController = new ProductController();
	/**
	 * Launch the application.
	 */    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct_GUI frame= new AddProduct_GUI(productController);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
private JLabel lblNewLabel;
private JLabel lblName;
private JLabel lblPrice;
private JLabel lblMinStock;
private JButton btnAddToCart;
private JScrollPane scrollPane;
private JTextField textFieldSearch;
private JButton btnSearch;
private JLabel Label_nameOfProduct;
private JTextField nameTextField;
private JTextField priceTextField;
private JLabel lblQty;
private JTextField qtyTextField;

	/**
	 * Create the application.
	 */
	public AddProduct_GUI(ProductController productController) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(getBackground());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			String [] temp = {"","","","","",""};
			model.addRow(temp);
			updateTable();
			}
		});
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		
		textFieldSearch = new JTextField();

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String productName = textFieldSearch.getText();
				Product product = productController.findProduct(productName);
				for (int i = 0; i < table.getRowCount(); i++) {
				for(int j = 0; j < table.getColumnCount(); j++) {
					table.setValueAt("", i, j);
					}
				}
				table.setValueAt(product.getName(), 0, 0);
				table.setValueAt(product.getType(), 0, 1);
				table.setValueAt(product.getLocation().getDepartment().getName(), 0, 2);
				table.setValueAt(product.getLocation().getAisle(), 0, 3);
				table.setValueAt(product.getLocation().getShelf(), 0, 4);
				table.setValueAt(product.getPrice(), 0, 5);
				table.setValueAt(product.getStock(), 0, 6);
				table.setValueAt(product.getMinStock(), 0, 7);
			}
		});
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setBackground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
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
		btnLoadTable.setBounds(240, 84, 104, 24);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 437, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				nameTextField.setText(model.getValueAt(selectedRowIndex, 0).toString());
				priceTextField.setText(model.getValueAt(selectedRowIndex, 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Type", "Department", "Aisle", "Shelf", "Price", "Stock", "Min. Stock"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Product Menu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(246, 23, 383, 38);
		contentPane.add(lblNewLabel);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 117, 50, 20);
		contentPane.add(lblName);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(10, 150, 50, 20);
		contentPane.add(lblPrice);
		
		lblMinStock = new JLabel("Minimum Stock");
		lblMinStock.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMinStock.setBounds(10, 296, 65, 31);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setForeground(new Color(51, 0, 0));
		btnAddToCart.setBackground(new Color(255, 204, 204));
		btnAddToCart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAddToCart.setBounds(530, 320, 147, 31);
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameTextField.getText();
				String price = priceTextField.getText();
				String qty = qtyTextField.getText();
				double _price = Double.parseDouble(price);
				int _qty = Integer.parseInt(qty);
				if (qtyTextField.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out the quantity field!***");
				else if (nameTextField.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please chose a product from the list!***");				
				else if (priceTextField.getText().equals("")) JOptionPane.showMessageDialog(frame, "***Error! Please chose a product from the list!***");
				if(!nameTextField.getText().equals("") && !priceTextField.getText().equals("") && !qtyTextField.getText().equals("")) {
					DefaultTableModel model = (DefaultTableModel)NewSale_GUI.table.getModel();
					Object [] row = {name, qty, price, _price*_qty};
					model.addRow(row);
					NewSale_GUI.totPrice += _price*_qty;
					reset();
				}
			}
		});
		contentPane.add(btnAddToCart);
		
		Label_nameOfProduct = new JLabel("Name of product:");
		Label_nameOfProduct.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Label_nameOfProduct.setBounds(356, 86, 119, 16);
		contentPane.add(Label_nameOfProduct);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(79, 117, 125, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(79, 150, 125, 20);
		contentPane.add(priceTextField);
		
		lblQty = new JLabel("Qty.");
		lblQty.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQty.setBounds(10, 183, 50, 20);
		contentPane.add(lblQty);
		
		qtyTextField = new JTextField();
		qtyTextField.setColumns(10);
		qtyTextField.setBounds(79, 183, 125, 20);
		contentPane.add(qtyTextField);
		
		}
	
	private void reset() {
		nameTextField.setText("");
		priceTextField.setText("");
		qtyTextField.setText("");
	}
	
	private void updateTable() {
		for (int i = 0; i < table.getRowCount(); i++) {
		      for(int j = 0; j < table.getColumnCount(); j++) {
		          table.setValueAt("", i, j);
		      }
		   }
		for(int i = 0; i<productController.getProductContainer().getProductList().size(); i++) {
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getName(), i, 0);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getType(), i, 1);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getPrice(), i, 5);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getStock(), i, 6);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getDepartment().getName(), i, 2);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getAisle(), i, 3);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getLocation().getShelf(), i, 4);
			table.setValueAt(productController.getProductContainer().getProductList().get(i).getMinStock(), i, 7);
		}
	}
}