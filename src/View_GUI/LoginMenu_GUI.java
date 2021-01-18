package View_GUI;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Controller.EmployeeController;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginMenu_GUI {
	private JFrame frame;
	private JTextField passwordText;
	private JTextField usernameText;
	private EmployeeController employeeController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu_GUI window = new LoginMenu_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginMenu_GUI() {
		employeeController = new EmployeeController();
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeDialog();
			}
		});
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBounds(341, 232, 85, 21);
		frame.getContentPane().add(cancelButton);
		
		JButton signButton = new JButton("Sign up");
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Signup_GUI(employeeController);
			}
		});
		signButton.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(signButton);
		
		JLabel errorText = new JLabel("Wrong username or password!");
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorText.setBounds(130, 104, 185, 21);
		frame.getContentPane().add(errorText);
		errorText.setVisible(false);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameText.getText();
				String password = passwordText.getText();
				
				if (employeeController.checkUser(username, password) != null) {
					System.out.println("hello");
					MainMenu_GUI.MainMenu();
					closeDialog();
					
					
				}
				else {
					errorText.setVisible(true);
				}
			}
		});
		loginButton.setBounds(246, 232, 85, 21);
		frame.getContentPane().add(loginButton);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordText.setColumns(10);
		passwordText.setBounds(130, 75, 162, 19);
		frame.getContentPane().add(passwordText);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(35, 75, 113, 19);
		frame.getContentPane().add(passwordLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setBounds(35, 45, 85, 19);
		frame.getContentPane().add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameText.setColumns(10);
		usernameText.setBounds(130, 46, 162, 19);
		frame.getContentPane().add(usernameText);
	}
	public void closeDialog() {
		frame.setVisible(false);
		frame.dispose();
	}
}
