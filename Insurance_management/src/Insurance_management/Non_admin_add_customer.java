package Insurance_management;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import database.Connection_provider;
import javax.swing.JScrollPane;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;

public class Non_admin_add_customer extends JFrame {
	

	private JPanel contentPane;
	private static JTextField Name;
	private static JTextField Mobile_num;
	private static JTextField Gender;
	public String mobileNumberPattern = "^[0-9]*$";
	public String emailPatterString = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	public int checkUsername = 0;
	static String   pathString;
	private static JTextField occupation;
	private static JTextField address;
	private static JTextField Email;
	static JDateChooser Date_Dob;
	
	private static String name="";
	private static String dob ="";
	private static String mob_num ="";
	private static String gender ="";
	private static String Occupation="" ;
	private static String Address ="";
	private static String email ="";
		
	public static String getname() {
		return name;
	}

	public static String getDob() {
		return dob;
	}

	public static String getMob_num() {
		return mob_num;
	}

	public static String getGender() {
		return gender;
	}

	public static String getOccupation() {
		return Occupation;
	}

	public static String getAddress() {
		return Address;
	}

	public static String getEmail() {
		return email;
	}
	
	
	
	public static void setname(String name_1) {
		Non_admin_add_customer.name = name_1;
	}

	public static void setDob(String dob) {
		Non_admin_add_customer.dob = dob;
	}

	public static void setMob_num(String mob_num) {
		Non_admin_add_customer.mob_num = mob_num;
	}

	public static void setGender(String gender) {
		Non_admin_add_customer.gender = gender;
	}

	public static void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public static void setAddress(String address) {
		Address = address;
	}

	public static void setEmail(String email) {
		Non_admin_add_customer.email = email;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Non_admin_add_customer frame = new Non_admin_add_customer();
					frame.setVisible(true);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Non_admin_add_customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD CUSTOMER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblNewLabel.setBounds(493, 11, 364, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(432, 130, 150, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date of birth");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(432, 190, 150, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(432, 250, 150, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("occupation");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(432, 370, 150, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(432, 310, 150, 35);
		contentPane.add(lblNewLabel_5);
		
		Name = new JTextField();
		Name.setBounds(707, 137, 250, 22);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Mobile_num = new JTextField();
		Mobile_num.setBounds(707, 258, 250, 22);
		contentPane.add(Mobile_num);
		Mobile_num.setColumns(10);
		
		Gender = new JTextField();
		Gender.setBounds(707, 318, 250, 22);
		contentPane.add(Gender);
		Gender.setColumns(10);
		
		Date_Dob = new JDateChooser();
		Date_Dob.setBounds(707, 202, 250, 20);
		contentPane.add(Date_Dob);
		
		occupation = new JTextField();
		occupation.setColumns(10);
		occupation.setBounds(707, 378, 250, 22);
		contentPane.add(occupation);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(707, 437, 250, 22);
		contentPane.add(address);
		
		
//		JButton btnNewButton = new JButton("Send request");
//		btnNewButton.setVisible(false);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				 name = Name.getText();
//				 dob = "";
//				 mob_num = Mobile_num.getText();
//				 gender = Gender.getText();
//				 Occupation = occupation.getText();
//				 Address = address.getText();
//				 email = Email.getText();
//				 SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
//				 Date date =  Date_Dob.getDate();
//				 if( date != null) {
//						dob = dFormat.format(Date_Dob.getDate());
//				 }
//						
//						
//				if(name.equals("")) {
//					JOptionPane.showMessageDialog(null, "Name field is required");
//				}
//				else if(dob.equals("")) {
//					JOptionPane.showMessageDialog(null, "Date of birth is required");
//				}
//				else if (mob_num.equals("")) {
//					JOptionPane.showMessageDialog(null, "Mobile num is required");
//				}
//				else if (!mob_num.matches(mobileNumberPattern) || mob_num.length() != 10) {
//					JOptionPane.showMessageDialog(null, "mobile number is not valid");
//				}
//				else if (email.equals("")) {
//					JOptionPane.showMessageDialog(null, "Email is required");
//				}
//				else if (!email.matches(emailPatterString)) {
//					JOptionPane.showMessageDialog(null, "Email is not valid");
//				}
//				else if (gender.equals("")) {
//					JOptionPane.showMessageDialog(null, "gender is required");
//					
//				}
//				else if (Occupation.equals("")) {
//					JOptionPane.showMessageDialog(null, "occupation is required");
//					
//				}
//				else if (Address.equals("")) {
//					JOptionPane.showMessageDialog(null, "Address is required");		
//				}
//
//				else {
//					try {
//						Connection connection = Connection_provider.getcon();
//						PreparedStatement ps = connection.prepareStatement("insert into background_verification(Name, address, dob, gender, occupation, Phone_num, reference, ref_username,status,email,sec_question) values (?,?,?,?,?,?,?,?,?,?,?)");
//						
//		
//						ps.setString(1,name );
//						ps.setString(2,Address );
//						ps.setString(3, dob);
//						ps.setString(4, gender);
//						ps.setString(5, Occupation);
//						ps.setString(6, mob_num);
//						ps.setString(7, LoginPage.getU_name());
//						ps.setString(8, LoginPage.getUsername());
//						ps.setString(9, "pending");
//						ps.setString(10, email);
//						
////						InputStream is = null;
////						try {
////							is = new FileInputStream(new File(pathString));
////						} catch (FileNotFoundException e1) {
////								// TODO Auto-generated catch block
////							e1.printStackTrace();
////						}
//
//						
//						
//						ps.executeUpdate();
//						setVisible(false);
//						new Non_admin_add_customer().setVisible(true);
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e);
//					} 
//					
//				}
//				
//			}
//		});
//		btnNewButton.setFocusable(false);
//		btnNewButton.setBounds(67, 148, 130, 30);
//		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NA_add_customer_next.ResetEverything();
				dispose();
				new Non_Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1122, 33, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 97, 1273, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("address");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(432, 430, 150, 35);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Email");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(432, 490, 150, 35);
		contentPane.add(lblNewLabel_4_1_1);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(707, 497, 250, 22);
		contentPane.add(Email);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveEverything();
				setVisible(false);
				new NA_add_customer_next().setVisible(true);
				NA_add_customer_next.LoadEverything();
				
			}
		});

		btnNewButton_2.setBounds(616, 604, 89, 23);
		contentPane.add(btnNewButton_2);	
	
		
	}
	
	
	
	public static void saveEverything() {
		
		 name = Name.getText();
		 mob_num = Mobile_num.getText();
		 gender = Gender.getText();
		 
		 dob = "";
		 Occupation = occupation.getText();
		 Address = address.getText();
		 email = Email.getText();
		 SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
		 Date date =  Date_Dob.getDate();
		 if( date != null) {
				dob = dFormat.format(Date_Dob.getDate());
		 }
		
		
		
	}
	
	

	public static void   LoadEverything() {
		Name.setText(name);
		Mobile_num.setText(mob_num);
		Gender.setText(gender);
		occupation.setText(Occupation);
		address.setText(Address);
		Email.setText(email);
		try {
			Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
			Date_Dob.setDate(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
