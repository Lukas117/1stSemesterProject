package View_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Inspect_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inspect_GUI window = new Inspect_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inspect_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int x = 0;
		JLabel lblNewLabel = new JLabel("Sale: " + x);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 10, 150, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer:");
		lblNewLabel_1.setBounds(10, 70, 50, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer:");
		lblNewLabel_1_1.setBounds(10, 100, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer:");
		lblNewLabel_1_2.setBounds(10, 130, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Customer:");
		lblNewLabel_1_3.setBounds(10, 160, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Customer:");
		lblNewLabel_1_4.setBounds(230, 70, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Customer:");
		lblNewLabel_1_5.setBounds(230, 100, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Customer:");
		lblNewLabel_1_6.setBounds(230, 130, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Customer:");
		lblNewLabel_1_7.setBounds(70, 70, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Customer:");
		lblNewLabel_1_8.setBounds(70, 100, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Customer:");
		lblNewLabel_1_9.setBounds(70, 160, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_9);
		
		JLabel lblNewLabel_1_10 = new JLabel("Customer:");
		lblNewLabel_1_10.setBounds(70, 130, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("Customer:");
		lblNewLabel_1_11.setBounds(290, 70, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_12 = new JLabel("Customer:");
		lblNewLabel_1_12.setBounds(290, 100, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_12);
		
		JLabel lblNewLabel_1_13 = new JLabel("Customer:");
		lblNewLabel_1_13.setBounds(290, 130, 50, 20);
		frame.getContentPane().add(lblNewLabel_1_13);
		
		JButton btnNewButton = new JButton("Create Invoice");
		btnNewButton.setBounds(316, 232, 110, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send in Email");
		btnNewButton_1.setBounds(10, 232, 110, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
