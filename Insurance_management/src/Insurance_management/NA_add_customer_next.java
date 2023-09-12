package Insurance_management;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

public class NA_add_customer_next extends JFrame {

	private JPanel contentPane;
		private JFrame frame;
	
	static JComboBox Question_selector;
	static JComboBox Blood_group;
	
	public String mobileNumberPattern = "^[0-9]*$";
	public String emailPatterString = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	private static  JTextField Aadhar_card;
	private JTextField PAN_card;
	private JTextField Passport_path;
	private JTextField Aadhar_path;
	private static JTextField Answer;

	
	
	static String passport_pathString="";
	static String aadhar_pathstring="";
	
	
	static String secret_question="";
	static String answer="";
	static String aadharcar_no="";
	static String blood_group="";
	
	static int sec=0;
	static int blood=0; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NA_add_customer_next frame = new NA_add_customer_next();
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
	public  NA_add_customer_next() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 687);
		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Select a scret question and answer below");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1.setBounds(244, 39, 291, 35);
		contentPane.add(lblNewLabel_4_1_1_1);
		

		Blood_group = new JComboBox();
		Blood_group.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		Blood_group.setBounds(562, 253, 89, 22);
		contentPane.add(Blood_group);
		
		Answer = new JTextField();
		
		Answer.setColumns(10);
		Answer.setBounds(562, 112, 250, 25);
		contentPane.add(Answer);
		
		JButton btnNewButton = new JButton("Send request");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				secret_question = (String) Question_selector.getSelectedItem();
				answer = Answer.getText();
				blood_group = (String) Blood_group.getSelectedItem();
				aadharcar_no = Aadhar_card.getText();
				
				
				
				
				if(Non_admin_add_customer.getname().equals("")) {
					JOptionPane.showMessageDialog(null, "Name field is required");
				}
				else if(Non_admin_add_customer.getDob().equals("")) {
					JOptionPane.showMessageDialog(null, "Date of birth is required");
				}
				else if (Non_admin_add_customer.getMob_num().equals("")) {
					JOptionPane.showMessageDialog(null, "Mobile num is required");
				}
				else if (!Non_admin_add_customer.getMob_num().matches(mobileNumberPattern) || Non_admin_add_customer.getMob_num().length() != 10) {
					JOptionPane.showMessageDialog(null, "mobile number is not valid");
				}
				else if (Non_admin_add_customer.getEmail().equals("")) {
					JOptionPane.showMessageDialog(null, "Email is required");
				}
				else if (!Non_admin_add_customer.getEmail().matches(emailPatterString)) {
					JOptionPane.showMessageDialog(null, "Email is not valid");
				}
				else if (Non_admin_add_customer.getGender().equals("")) {
					JOptionPane.showMessageDialog(null, "gender is required");
					
				}
				else if (Non_admin_add_customer.getOccupation().equals("")) {
					JOptionPane.showMessageDialog(null, "occupation is required");
					
				}
				else if (Non_admin_add_customer.getAddress().equals("")) {
					JOptionPane.showMessageDialog(null, "Address is required");		
				}
				else if(secret_question.equals("")) {
					JOptionPane.showMessageDialog(null, "secret question is required");	
				}
				else if (answer.equals("")) {
					JOptionPane.showMessageDialog(null, "answer for secret question is required");	
				}
				else if (blood_group.equals("")) {
					JOptionPane.showMessageDialog(null, "blood group is required");	
				}
				else if(aadharcar_no.equals("")){
					JOptionPane.showMessageDialog(null, "aadhar card number is required");	
				}
				else if (!aadharcar_no.matches(mobileNumberPattern) || aadharcar_no.length()!=12) {
					JOptionPane.showMessageDialog(null, "invalid aadhar card");	
				}
				else {
					
					try {
						Connection connection = Connection_provider.getcon();
						PreparedStatement ps = connection.prepareStatement("insert into background_verification(Name, address, dob, gender, occupation, Phone_num, reference, ref_username,status,email,sec_question,sec_question_ans,Aadhar_card,blood_group,passport_photo,aadhar_photo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						
		
						ps.setString(1,Non_admin_add_customer.getname());
						ps.setString(2,Non_admin_add_customer.getAddress());
						ps.setString(3, Non_admin_add_customer.getDob());
						ps.setString(4, Non_admin_add_customer.getGender());
						ps.setString(5, Non_admin_add_customer.getOccupation());
						ps.setString(6, Non_admin_add_customer.getMob_num());
						ps.setString(7, LoginPage.getU_name());
						ps.setString(8, LoginPage.getUsername());
						ps.setString(9, "pending");
						ps.setString(10, Non_admin_add_customer.getEmail());
						ps.setString(11, secret_question);
						ps.setString(12, answer);
						ps.setString(13, aadharcar_no);
						ps.setString(14, blood_group);
						InputStream is = null;
						try {
							is = new FileInputStream(new File(passport_pathString));
						} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ps.setBlob(15, is);
						
						
						InputStream is_1 = null;
						try {
							is_1 = new FileInputStream(new File(aadhar_pathstring));
						} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						ps.setBlob(16, is_1);

						
						
						ps.executeUpdate();
						ResetEverything();
						JOptionPane.showMessageDialog(null, "The admin will perform background verification and accept customer");
						setVisible(false);
						new Non_admin_add_customer().setVisible(true);
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					} 

				}
				
				

				
				
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(657, 569, 130, 30);
		contentPane.add(btnNewButton);
		
		JButton Previous = new JButton("Previous");
		Previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SaveEverything();
				
				new Non_admin_add_customer().setVisible(true);
				Non_admin_add_customer.LoadEverything();
				
	
				
			}
		});
		Previous.setBounds(466, 569, 114, 30);
		contentPane.add(Previous);
		
		JLabel lblNewLabel_1 = new JLabel("Aadhar card number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(296, 167, 164, 35);
		contentPane.add(lblNewLabel_1);
		
//		JLabel lblNewLabel_1_1 = new JLabel("PAN card number");
//		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblNewLabel_1_1.setBounds(296, 246, 164, 35);
//		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("blood group");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(296, 246, 164, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Passport size photo");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(296, 330, 164, 35);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Aadhar card photo");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setBounds(296, 409, 164, 35);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		
		
		Question_selector = new JComboBox();
		Question_selector.setModel(new DefaultComboBoxModel(new String[] {"Name of your school", "Year of marriage", "Name of you'r oldest niece", "City you were born", "Your first dogs name"}));
		Question_selector.setBounds(562, 46, 267, 22);
		contentPane.add(Question_selector);
		
		
		Aadhar_card = new JTextField();
		Aadhar_card.setBounds(562, 173, 250, 25);
		contentPane.add(Aadhar_card);
		Aadhar_card.setColumns(10);
		
//		PAN_card = new JTextField();
//		PAN_card.setColumns(10);
//		PAN_card.setBounds(562, 254, 250, 25);
//		contentPane.add(PAN_card);
		
		Passport_path = new JTextField();
		Passport_path.setColumns(10);
		Passport_path.setBounds(562, 338, 250, 25);
		contentPane.add(Passport_path);
		
		Aadhar_path = new JTextField();
		Aadhar_path.setColumns(10);
		Aadhar_path.setBounds(562, 415, 250, 25);
		contentPane.add(Aadhar_path);
		
		
		
		JButton btnNewButton_1 = new JButton("upload");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				passport_pathString = file.getAbsolutePath();
				System.out.println(passport_pathString);
				Passport_path.setText(passport_pathString);
				
				try {
					
					BufferedImage bImage = ImageIO.read(new File(passport_pathString));
					Image img = bImage.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
					
					BufferedImage bufferedImageResult = new BufferedImage(
					        400,
					        400,
					        bImage.getType()
					);
					
					Graphics2D g2d = bufferedImageResult.createGraphics();
					g2d.drawImage(
					        bImage, 
					        0, 
					        0, 
					        400, 
					        400, 
					        null
					);
					
					
					g2d.dispose();
					String formatName = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\pass_img.jpg".substring(
							"C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\pass_img.jpg".lastIndexOf(".") + 1
					);
					
					ImageIO.write(
					        bufferedImageResult, 
					        formatName, 
					        new File("C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\pass_img.jpg")
					);
					
					passport_pathString="C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\pass_img.jpg";
					System.out.println(passport_pathString);
					
					
//					InputStream is = null;
//					try {
//						is = new FileInputStream(new File(passport_pathString));
//					} catch (FileNotFoundException e1) {
//							// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(885, 343, 89, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("upload");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				aadhar_pathstring = file.getAbsolutePath();
				Aadhar_path.setText(aadhar_pathstring);
				try {
					
					BufferedImage bImage = ImageIO.read(new File(aadhar_pathstring));
					Image img = bImage.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
					
					BufferedImage bufferedImageResult = new BufferedImage(
					        400,
					        400,
					        bImage.getType()
					);
					
					Graphics2D g2d = bufferedImageResult.createGraphics();
					g2d.drawImage(
					        bImage, 
					        0, 
					        0, 
					        400, 
					        400, 
					        null
					);
					
					
					g2d.dispose();
					String formatName = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\aadh_img.jpg".substring(
							"C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\aadh_img.jpg".lastIndexOf(".") + 1
					);
					
					ImageIO.write(
					        bufferedImageResult, 
					        formatName, 
					        new File("C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\aadh_img.jpg")
					);
					
					aadhar_pathstring = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\aadh_img.jpg";
					System.out.println(aadhar_pathstring);
					
					
//					InputStream is = null;
//					try {
//						is = new FileInputStream(new File(aadhar_pathstring));
//					} catch (FileNotFoundException e1) {
//							// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				
			}
		});
		btnNewButton_1_1.setBounds(885, 416, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		
		JLabel lblNewLabel = new JLabel("Answer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(310, 112, 172, 22);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
	
	public void SaveEverything() {
		sec= Question_selector.getSelectedIndex();
		answer =Answer.getText();
		aadharcar_no = Aadhar_card.getText();
		blood = Blood_group.getSelectedIndex();		
	}
	
	public static void LoadEverything() {
		Question_selector.setSelectedIndex(sec);
		Answer.setText(answer);
		Aadhar_card.setText(aadharcar_no);
		Blood_group.setSelectedIndex(blood);
		
		
	}
	
	public static void ResetEverything() {
		secret_question="";
		answer="";
	    aadharcar_no="";
	    blood_group="";
	    Non_admin_add_customer.setname("");
	    Non_admin_add_customer.setDob("");
	    Non_admin_add_customer.setMob_num("");
	    Non_admin_add_customer.setGender("");
	    Non_admin_add_customer.setOccupation("");
	    Non_admin_add_customer.setAddress("");
	    Non_admin_add_customer.setEmail("");
						 
		 
	}
	
	
	
}
