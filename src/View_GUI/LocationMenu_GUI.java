package View_GUI;

import java.awt.*;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.LocationController;
import javax.swing.table.DefaultTableModel;

import Model.Employee;
import Model.Location;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocationMenu_GUI extends JFrame{

	protected static final LocationController locationController = new LocationController();
	private JFrame frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationMenu_GUI frame= new LocationMenu_GUI(locationController);
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
private JTextField textField_Aisle;
private JButton btnSave;
private JButton btnDelete;
private JScrollPane scrollPane;
private JTextField textField_Shelf;
private JTable table;

	public LocationMenu_GUI(LocationController locationController) {
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
		btnLoadTable.setBounds(401, 89, 104, 24);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLoadTable.setForeground(new Color(30, 144, 255));
		/* btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		}); */
		contentPane.setLayout(null);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 117, 437, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Warehouse", "Aisle", "Shelf"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class
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
		
		lblNewLabel = new JLabel("Location Menu");
		lblNewLabel.setBounds(246, 23, 383, 38);
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
		
		textField_Aisle = new JTextField("0");
		textField_Aisle.setBounds(92, 147, 140, 22);
		textField_Aisle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		contentPane.add(textField_Aisle);
		textField_Aisle.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aisle = Integer.parseInt(textField_Aisle.getText());
				int shelf = Integer.parseInt(textField_Shelf.getText());
				//String warehouse = ;
	//Check these lines!!!!!
					if (textField_Aisle.getText().equals("0")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
	//Check these lines!!!!!		
					else if (textField_Shelf.getText().equals("0")) JOptionPane.showMessageDialog(frame, "***Error! Please fill out all the fields!***");
					
			if(textField_Aisle.getText().equals("") && textField_Shelf.getText().equals("")) {
				Location location = new Location(null, shelf, aisle);
				if (locationController.addLocation(location)) {
					JOptionPane.showMessageDialog(frame, "Employee already exists!");
				}
				else {
					locationController.addLocation(location);
					JOptionPane.showMessageDialog(frame, "Employee is created!");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object [] row = {String.valueOf(aisle), String.valueOf(shelf)};
					model.addRow(row);
					reset();
				}
					
			} 
			else JOptionPane.showMessageDialog(frame, "***Error!***");	
			}
		});
		btnSave.setBounds(346, 320, 96, 31);
		btnSave.setBackground(UIManager.getColor("Button.darkShadow"));
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
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(533, 320, 96, 31);
		btnDelete.setBackground(SystemColor.activeCaptionBorder);
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
		
		JLabel lblCprNumb = new JLabel("Warehouse");
		lblCprNumb.setBounds(6, 117, 76, 22);
		lblCprNumb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblCprNumb);
		
		JLabel lblName_1_1 = new JLabel("Aisle");
		lblName_1_1.setBounds(6, 147, 76, 22);
		lblName_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Shelf");
		lblName_1_1_1.setBounds(6, 177, 76, 22);
		lblName_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblName_1_1_1);
		
		textField_Shelf = new JTextField("0");
		textField_Shelf.setBounds(92, 177, 140, 22);
		textField_Shelf.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_Shelf.setColumns(10);
		contentPane.add(textField_Shelf);
		
		JComboBox comboBox_Warehouse = new JComboBox();
		comboBox_Warehouse.setBounds(92, 114, 143, 23);
		contentPane.add(comboBox_Warehouse);
	}
	private void reset() {
		textField_Aisle.setText("");
		textField_Shelf.setText("");
	}
}