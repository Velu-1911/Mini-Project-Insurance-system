package Insurance_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Connection_provider;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.Font;
import javax.swing.ImageIcon;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	
	static int  count=0;



	private static String password; 
	private static String username;
	private static String u_name;
	
	public static String getU_name() {
		return u_name;
	}


	public static void setU_name(String u_name) {
		LoginPage.u_name = u_name;
	}
	


	public static String getUsername() {
		return username;
	}

	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		LoginPage.password = password;
	}
	public static void setUsername(String username) {
		LoginPage.username = username;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
			/////TRY CHANGING IT TO UNDECORATED LATER///////////////
//					frame.setUndecorated(true);
					frame.setVisible(true);
					
					
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}



	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1299, 690);
		
		setExtendedState(MAXIMIZED_BOTH);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(615, 278, 89, 35);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		
		
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
//		txtUsername.setOpaque(false);
//		txtUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsername.setBounds(665, 332, 120, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(665, 376, 121, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(548, 332, 84, 17);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel_1.setBackground(Color.white);
//		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(548, 376, 89, 17);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel_2.setBackground(Color.white);
//		lblNewLabel_2.setOpaque(true);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(597, 433, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = txtUsername.getText();
				password = passwordField.getText();
				int temp = 0;
				try {
					Connection connection = Connection_provider.getcon();
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select * from employee where BINARY username='"+username+"' and BINARY password='"+password+"'");
					while(rs.next()) {

						temp=1;
						if(rs.getString("userRole").equals("Admin")){
							setU_name(rs.getString("name"));
							setVisible(false);
							new Admin_Dashboard().setVisible(true);
						}
						else if (rs.getString("userRole").equals("Non-Admin")) {
							setU_name(rs.getString("name"));
							setVisible(false);
							new Non_Admin_Dashboard().setVisible(true);
						}
						else {
							setVisible(false);
						}
					}
					if(temp==0) {
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					}
					connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
			}
		});
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if ( passwordField.getEchoChar() != '\u0000' ) {

				    passwordField.setEchoChar('\u0000');

				} else {

				    passwordField.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));

				}
				if(count%2==0) {
					btnNewButton_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/visible (2).png")));
				}
				else {
					btnNewButton_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/hide (1).png")));
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/visible (2).png")));
		btnNewButton_1.setBounds(785, 376, 20, 20);
		contentPane.add(btnNewButton_1);
		//TRY TO ADD LOGIN BY ENTER BUTTON;
		
		
	}
}
