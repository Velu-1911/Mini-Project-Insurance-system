package Cutomers;

import java.awt.Color;
 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Insurance_management.Admin_Dashboard;
import Insurance_management.LoginPage;
import Insurance_management.Non_Admin_Dashboard;
import database.Connection_provider;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Customers_login extends JFrame {

	private JPanel contentPane;
	private JTextField Cust_email;
	private JPasswordField passwordField;
	
	private static String cust_password; //
	private static String email;//
	private static String secret_ques;
	private static String aadhar_card;//
	private static String uu_name;
	
	JButton btnNewButton;
	static int count;
	
	
	
	
	

	public static void setSecret_ques(String secret_ques) {
		Customers_login.secret_ques = secret_ques;
	}

	public static void setUu_name(String uu_name) {
		Customers_login.uu_name = uu_name;
	}

	public static String getUu_name() {
		return uu_name;
	}

	public static String getAadhar_card() {
		return aadhar_card;
	}

	public static void setAadhar_card(String aadhar_card) {
		Customers_login.aadhar_card = aadhar_card;
	}

	
	
	
	
	

	
	public static String getCust_password() {
		return cust_password;
	}

	public static void setCust_password(String cust_password) {
		Customers_login.cust_password = cust_password;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Customers_login.email = email;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers_login frame = new Customers_login();
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
	public Customers_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 688);
		setExtendedState(MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Cust_email = new JTextField();
		Cust_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Cust_email.setBounds(136, 203, 410, 46);
		Cust_email.setOpaque(false);
		Cust_email.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(Cust_email);
		Cust_email.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( passwordField.getEchoChar() != '\u0000' ) {

				    passwordField.setEchoChar('\u0000');

				} else {

				    passwordField.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));

				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setOpaque(false);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordField.setBounds(136, 343, 410, 46);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email= Cust_email.getText();
				cust_password = passwordField.getText();
				int temp = 0;
				Boolean new_passflag=true;
				if(cust_password.equals("")) {		
					try {
						Connection connection = Connection_provider.getcon();
						Statement st = connection.createStatement();
						ResultSet rs = st.executeQuery("select * from customers where BINARY email='"+email+"'");
						while(rs.next()) {
							temp=1;
							
							String pass = rs.getString("password");
							boolean bool = rs.wasNull();
							if(bool) {
								new_passflag=false;
								JOptionPane.showMessageDialog(null, "you are a new customer please set new password");
							}
							
							
//							setVisible(false);
//							new Customer_dashboard().setVisible(true);
						}
						if(new_passflag) 
						{
							temp=1;
							JOptionPane.showMessageDialog(null, "Password field is required");
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2);
					}
				
					
				}
				try {
					Connection connection = Connection_provider.getcon();
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select * from customers where BINARY email='"+email+"' and  BINARY password='"+cust_password+"'");
					while(rs.next()) {
						temp=1;
						aadhar_card = rs.getString("Aadhar_card");
						uu_name = rs.getString("Name");
						
						setVisible(false);
						new Customer_dashboard().setVisible(true);
					}
					if(temp==0) {
						JOptionPane.showMessageDialog(null, "Incorrect email or password");
					}
					connection.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(249, 413, 171, 46);
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "You are first time customer set password");
				
				
				 String email = JOptionPane.showInputDialog(null, "Please enter your email.");
				 if(email.equals("") == false) {
					 int check_email_temp=0;
					 	
					 	try {
					 		Connection new_Connection = new Connection_provider().getcon();
							Statement st_new = new_Connection.createStatement();
							ResultSet rs_new = st_new.executeQuery("select * from customers where BINARY email='"+email+"'");
							while(rs_new.next()) {
								check_email_temp =1;
								 secret_ques= rs_new.getString("sec_question");
								
							}
							
							if(check_email_temp==1) {
								 JTextField userField = new JTextField();
							     JTextField passField = new JTextField();
							     String message = "Please enter your email.";
							     String message_1 = "Please answer your secret question.";
							     int result = JOptionPane.showOptionDialog(null, new Object[] {message, userField, message_1,secret_ques, passField},
							     "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							     
							     if(result == 0) {
							    	 String first__login_email =userField.getText(); 
							    	 String questuion_answer = passField.getText();
							    	 int temp =0;
							    	 try {
							    		Connection connection = Connection_provider.getcon();
										Statement st = connection.createStatement();
										ResultSet rs = st.executeQuery("select * from customers where email='"+first__login_email+"' and sec_question_ans='"+questuion_answer+"' ");
										while(rs.next()) {
												String pass = rs.getString("password");
												if(rs.wasNull()) {
													JPasswordField set_password = new JPasswordField();
													JPasswordField confirm_set_password = new JPasswordField();
													String message_2 = "Please set your password.";
													String message_3 = "Please confirm your password";
													int choice = JOptionPane.showOptionDialog(null, new Object[] {message_2, set_password,message_3,confirm_set_password},
														     "Set your password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
													if(choice ==0) {
														
														String com_pass =set_password.getText();
														String com_pass_1 = confirm_set_password.getText();
														
														if(set_password.getText().isEmpty() || confirm_set_password.getText().isEmpty()){
															JOptionPane.showMessageDialog(null, "passwords cannot be empty");
														}
														else if(com_pass.equals(com_pass_1)){
															PreparedStatement ps = connection.prepareStatement("update customers set password = ? where email = ? ");
															ps.setString(1, com_pass);
															ps.setString(2, first__login_email);
															ps.executeUpdate();
															JOptionPane.showMessageDialog(null, "Your password has been set");
															
															
														}
														else if(com_pass.equals(com_pass_1) == false) {
															
															JOptionPane.showMessageDialog(null, "password and confirm password must be equal");
														}
														
														
													}
														
//													JOptionPane.showMessageDialog(null, "");
												}
												else {
													JOptionPane.showMessageDialog(null, "password has already been set");
												}
												temp=1;
												
												
										}
						
										
										if(temp==0) {
											JOptionPane.showMessageDialog(null, "Incorrect answer or email");
										}
										connection.close();
							    	 }
							    	 catch (Exception e3) {
										// TODO: handle exception
							    		 JOptionPane.showMessageDialog(null, e3);
									}
							    	 
							    	 
							     }
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Email does not exist");
							}
							
							
							
						} catch (Exception e4) {
							// TODO: handle exception
						}
					 	
					 	
					 
//							 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "email can't be empty");
				 }
				 
			   
				
		
			     
			     

				
				
				
			}
		});
		btnNewButton_1.setBounds(292, 563, 221, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Customers_login.class.getResource("/images/MicrosoftTeams-image (7).png")));
		lblNewLabel_4.setBounds(0, 0, 1282, 661);
		contentPane.add(lblNewLabel_4);
		
		
		
	}
	
	
	
}
