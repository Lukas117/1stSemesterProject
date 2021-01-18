package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import View.MainMenu;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sale menu");
		btnNewButton.setBounds(33, 21, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product menu");
		btnNewButton_1.setBounds(33, 72, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Employee menu");
		btnNewButton_2.setBounds(20, 134, 157, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Customer menu");
		btnNewButton_3.setBounds(20, 193, 157, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Department menu");
		btnNewButton_4.setBounds(267, 21, 138, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Location menu");
		btnNewButton_5.setBounds(277, 72, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Lease menu");
		btnNewButton_6.setBounds(277, 134, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Lot out");
		btnNewButton_7.setBounds(306, 237, 138, 29);
		frame.getContentPane().add(btnNewButton_7);
	}

}