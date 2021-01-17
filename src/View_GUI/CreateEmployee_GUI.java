package View_GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EmployeeController;
import Model.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateEmployee_GUI extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField usernameText;
	private JTextField nameText;
	private JTextField emailText;
	private JTextField passwordText;


	public CreateEmployee_GUI(EmployeeController employeeController) {
		super(null,"Create new employee", ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(144, 40, 96, 19);
		contentPanel.add(usernameText);
		usernameText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setBounds(144, 69, 96, 19);
		contentPanel.add(nameText);
		nameText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setBounds(144, 98, 96, 19);
		contentPanel.add(emailText);
		emailText.setColumns(10);
		
		passwordText = new JTextField();
		passwordText.setBounds(144, 126, 96, 19);
		contentPanel.add(passwordText);
		passwordText.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setBounds(38, 38, 96, 19);
		contentPanel.add(usernameLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(38, 70, 45, 13);
		contentPanel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLabel.setBounds(38, 99, 45, 13);
		contentPanel.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(38, 124, 96, 19);
		contentPanel.add(passwordLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Create");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String username = usernameText.getText();
						String name = nameText.getText();
						String email = emailText.getText();
						String password = passwordText.getText();
						Employee employee = new Employee(username, name, email, password, 0);
						employeeController.createEmployee(employee);
						closeDialog();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void closeDialog() {
		setVisible(false);
		dispose();
	}
}
