package Insurance_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.Blob;

import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

public class profile_non_admin extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Dob;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	public String mobileNumberPattern = "^[0-9]*$";
	public int checkUsername = 0;
	private static int prof_count=0;
	//admin= 1;
	//non_admin=2;
	
	
	
	public static int getProf_count() {
		return prof_count;
	}

	public static void setProf_count(int prof_counter) {
		prof_count = prof_counter;
	}

	String tempusername = "";
	String temppass = "";
	private JTextField Salary;
	private JTextField Commision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile_non_admin frame = new profile_non_admin();
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
	public profile_non_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Profile_label = new JLabel("PROFILE");
		Profile_label.setBounds(455, 24, 420, 40);
		Profile_label.setHorizontalAlignment(SwingConstants.CENTER);
		Profile_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(Profile_label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 1257, 2);
		contentPane.add(separator);
		
		JLabel Profile_image = new JLabel("");
		Profile_image.setBounds(142, 100, 215, 234);
		Profile_image.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Profile_image);
		
		JLabel Name11111 = new JLabel("Name");
		Name11111.setBounds(531, 120, 150, 30);
		Name11111.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(Name11111);
		
		JLabel lblNewLabel_2 = new JLabel("Date of birth");
		lblNewLabel_2.setBounds(531, 185, 150, 30);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("mobile number");
		lblNewLabel_3.setBounds(531, 260, 150, 30);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("username");
		lblNewLabel_4.setBounds(531, 329, 150, 30);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("password");
		lblNewLabel_5.setBounds(531, 399, 150, 30);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5);
		
		Name = new JTextField();
		Name.setBounds(760, 120, 250, 30);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Dob = new JTextField();
		Dob.setBounds(760, 187, 250, 30);
		contentPane.add(Dob);
		Dob.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(760, 260, 250, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(760, 331, 250, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(760, 401, 250, 30);
		contentPane.add(passwordField);
		
		
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBounds(702, 595, 100, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				String dob = Dob.getText();
				String mob_num = textField_2.getText();
//				String username = textField_3.getText();
				String password = passwordField.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Name field is required");
				}
				else if(dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Date of birth is required");
				}
				else if (mob_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Mobile num is required");
				}
				else if (!mob_num.matches(mobileNumberPattern) || mob_num.length() != 10) {
					JOptionPane.showMessageDialog(null, "mobile number is not valid");
				}
//				else if (username.equals("")) {
//					JOptionPane.showMessageDialog(null, "User name field is required");	
//				}
//				else if (checkUsername==1) {
//					JOptionPane.showMessageDialog(null, "Username is not available");
//				}
				else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "Password cannot be empty");
				}
				else {
					try {
						
						 Connection connection = Connection_provider.getcon();
						 PreparedStatement ps = connection.prepareStatement("update employee set name=?,dob=?,mobileNumber=?,password =? where username =?");
						 ps.setString(1,name );
						 ps.setString(2,dob );
						 ps.setString(3, mob_num);
//						 ps.setString(4, username);
						 ps.setString(4, password);
						 ps.setString(5, LoginPage.getUsername());
						 JOptionPane.showMessageDialog(null, "Profile Updated Succesfully");
						 ps.executeUpdate(); 
						 setVisible(false);
						 new profile_non_admin().setVisible(true);
						 connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setBounds(1136, 24, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(prof_count==1) {
					dispose();
					new Admin_Dashboard().setVisible(true);

				}
				if(prof_count==2) {
					dispose();
					new Non_Admin_Dashboard().setVisible(true);

				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Salary");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(531, 466, 150, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Commision");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(531, 527, 150, 30);
		contentPane.add(lblNewLabel_1);
		
		Salary = new JTextField();
		Salary.setEditable(false);
		Salary.setBounds(760, 466, 250, 30);
		contentPane.add(Salary);
		Salary.setColumns(10);
		
		Commision = new JTextField();
		Commision.setEditable(false);
		Commision.setBounds(760, 527, 250, 30);
		
		contentPane.add(Commision);
		Commision.setColumns(10);
		
		
		try {
			 Connection connection = Connection_provider.getcon();
			 PreparedStatement ps = connection.prepareStatement("select * from employee where username = ?");
			 ps.setString(1, LoginPage.getUsername());
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Name.setText(rs.getString("name"));
				 Dob.setText(rs.getString("dob"));
				 textField_2.setText(rs.getString("mobileNumber"));
				 textField_3.setText(rs.getString("username"));
				 passwordField.setText(rs.getString("password"));
				 Salary.setText(rs.getString("salary"));
				 
				 PreparedStatement ps1 = connection.prepareStatement("SELECT COUNT(Cust_id) FROM customers WHERE ref_username =?;");
				 ps1.setString(1, LoginPage.getUsername());
				 ResultSet rs2 = ps1.executeQuery();
				 while(rs2.next()) {
					 int commision =  200 * rs2.getInt(1);
					 Commision.setText(String.valueOf(commision));
					 System.out.println(commision);
				 }
				 PreparedStatement ps3 = connection.prepareStatement("update employee set commission = ? where username = ?");
				 ps3.setString(1, Commision.getText());
				 ps3.setString(2, LoginPage.getUsername());
				 ps3.executeUpdate();
				 
				 byte[] Passimg = rs.getBytes("photoooo");
				 if(Passimg == null) {
					   System.out.println("hello");
				 	}else {
					//show the image like you did before
				 	Blob imageBlob =  (Blob) rs.getBlob("photoooo");
					String pathString = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img1.jpg";
					 byte [] bytea = imageBlob.getBytes(1, (int)imageBlob.length());

					 FileOutputStream fos = new FileOutputStream(pathString);
					 fos.write(bytea);
					 ImageIcon icon = new ImageIcon(bytea);
					 Profile_image.setIcon(icon);

				 }
				 
//				 Blob imageBlob =  (Blob) rs.getBlob("photoooo");
//				 
//				 String pathString = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img1.jpg";
//				 byte [] bytea = imageBlob.getBytes(1, (int)imageBlob.length());

				 
				 //				 if(bytea == null) {
//					 System.out.println("hello");
//					 
//				 }
//				 else {
//					 
//				 }
				 				 
			 } 
	
			 connection.close();
			 
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		if(prof_count==1) {
			Commision.setVisible(false);
			lblNewLabel_1.setVisible(false);
			
		}
		
	
		
	}
}
