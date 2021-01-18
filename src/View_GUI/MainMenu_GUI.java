package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu_GUI {
	private JFrame frame;
	
	public static void MainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu_GUI window = new MainMenu_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu_GUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Main menu");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton saleButton = new JButton("Sale menu");
		saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		saleButton.setBounds(33, 21, 117, 29);
		frame.getContentPane().add(saleButton);
		
		JButton productButton = new JButton("Product menu");
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		productButton.setBounds(33, 60, 117, 29);
		frame.getContentPane().add(productButton);
		
		JButton employeeButton = new JButton(" Employee menu");
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		employeeButton.setBounds(33, 99, 117, 29);
		frame.getContentPane().add(employeeButton);
		
		JButton customerButton = new JButton("Customer menu");
		customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu_GUI.CustomerMenu();
				closeDialog();
			}
		});
		customerButton.setBounds(33, 138, 117, 29);
		frame.getContentPane().add(customerButton);
		
		JButton departmentButton = new JButton("Department menu");
		departmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		departmentButton.setBounds(277, 21, 117, 29);
		frame.getContentPane().add(departmentButton);
		
		JButton locationButton = new JButton("Location menu");
		locationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		locationButton.setBounds(277, 60, 117, 29);
		frame.getContentPane().add(locationButton);
		
		JButton leaseButton = new JButton("Lease menu");
		leaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		leaseButton.setBounds(277, 99, 117, 29);
		frame.getContentPane().add(leaseButton);
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginMenu_GUI.LoginMenu(); //dont know better way
				closeDialog();
			}
		});
		logoutButton.setBounds(246, 232, 85, 21);
		frame.getContentPane().add(logoutButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeDialog();
			}
		});
		exitButton.setBounds(341, 232, 85, 21);
		frame.getContentPane().add(exitButton);
	}
	
	public void closeDialog() {
		frame.setVisible(false);
		frame.dispose();
	}
}