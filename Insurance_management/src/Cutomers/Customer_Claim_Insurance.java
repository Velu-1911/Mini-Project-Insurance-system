package Cutomers;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mysql.cj.jdbc.Blob;
import com.toedter.calendar.JDateChooser;

import Insurance_management.Admin_Dashboard;
import Insurance_management.LoginPage;
import database.Connection_provider;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Customer_Claim_Insurance extends JFrame {

	private JPanel contentPane;
	
	public double emailvalue;
	private JTextField Name;
	private JTextField Phone_num;
	private JTextField Unique;
	private JTextField Life_Name;
	private JTextField Life_dob;
	private JTextField Life_Gender;
	private JTextField Life_Phone_num;
	private JTextField Life_aadhar_num;
	private JTextField Life_bloodgroup;
	private JTextField Life_premium;
	JTextArea Life_address;
	private JTextField Home_dob;
	private JTextField Home_claim;
	private JTextField Home_aadhar;
	private JTextField Home_Phone_num;
	private JTextField Home_name;
	private JTextField Vehicle_dob;
	private JTextField Vehicle_claim;
	private JTextField Vehicle_name;
	private JTextField VehiclePhone_num;
	private JTextField Vehicle_aadhar;
	private JTextField Vehicle_Model;
	private JTextField Vehicle_registration;
	JTextArea Vehicle_address;
	JTextArea Home_address;
	String unique;
	private JTextField Nominee;
	private JTextField Nominee_relationship;
	private JTextField Home_claimleft;
	private JTextField Vehicle_claimleft;
	private JTextField home_user_claim;
	private JTextField vehicle_user_claim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Claim_Insurance frame = new Customer_Claim_Insurance();
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
	public Customer_Claim_Insurance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1297, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setBackground(Color.white);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
		insets.top = -1;
		UIManager.put("TabbedPane.contentBorderInsets", insets);
		UIManager.put("TabbedPane.contentOpaque", false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -29, 1283, 686);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		
				
		JLabel lblNewLabel_1_1 = new JLabel("Name:-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(84, 135, 150, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date of birth:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(84, 195, 150, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Phone_num:-");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(84, 252, 150, 35);
		panel_1.add(lblNewLabel_4_1);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(235, 142, 250, 22);
		panel_1.add(Name);
		
		JDateChooser Date_dob = new JDateChooser();
		Date_dob.setBounds(235, 195, 250, 20);
		panel_1.add(Date_dob);
		
		Phone_num = new JTextField();
		Phone_num.setColumns(10);
		Phone_num.setBounds(235, 259, 250, 22);
		panel_1.add(Phone_num);
		
		JLabel aadhar = new JLabel("Aadhar Card:-\r\n");
		aadhar.setVisible(false);
		aadhar.setFont(new Font("Tahoma", Font.BOLD, 13));
		aadhar.setBounds(84, 323, 150, 35);
		panel_1.add(aadhar);
		
		Unique = new JTextField();
		Unique.setColumns(10);
		Unique.setBounds(235, 331, 250, 22);
		panel_1.add(Unique);
		
		JLabel address = new JLabel("Address:-\r\n\r\n");
		address.setVisible(false);
		address.setFont(new Font("Tahoma", Font.BOLD, 13));
		address.setBounds(84, 323, 150, 35);
		panel_1.add(address);
		
		JLabel registration_num = new JLabel("Registration number:-\r\n");
		registration_num.setVisible(false);
		registration_num.setFont(new Font("Tahoma", Font.BOLD, 13));
		registration_num.setBounds(84, 323, 150, 35);
		panel_1.add(registration_num);
		
		
		String[] Insurance_type= {"Life Insurance", "Home Insurance", "Vehicle Insurance"};
		JComboBox comboBox = new JComboBox(Insurance_type);
		comboBox.setBounds(84, 87, 131, 20);
		panel_1.add(comboBox);	
		JLabel lblNewLabel = new JLabel("select the type of insurance you want to claim:-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(84, 33, 463, 32);
		panel_1.add(lblNewLabel);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = (String) comboBox.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Life Insurance":
                        emailvalue = 1.1;
                        System.out.println("Day selected, emailvalue:" + emailvalue);
                        aadhar.setVisible(true);
                        registration_num.setVisible(false);
                        address.setVisible(false);
                        break;
                    case "Home Insurance":
                    	
                        emailvalue = 2.2;
                        aadhar.setVisible(false);
                        registration_num.setVisible(false);
                        address.setVisible(true);
                        System.out.println("Week selected, emailvalue:" + emailvalue);
                        break;
                    case "Vehicle Insurance":
                    	aadhar.setVisible(false);
                        registration_num.setVisible(true);
                        address.setVisible(false);
                        emailvalue = 3.3;
                        System.out.println("Month selected, emailvalue:" + emailvalue);
                        break;
                    default:
                        emailvalue = 4.4;
                        System.out.println("No match selected, emailvalue:" + emailvalue);
                        break;
                }
			}
		});
		
		comboBox.setSelectedIndex(0);
		
		JButton btnNewButton = new JButton("next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name =  Name.getText();
				String dob = "";
				Date date =  Date_dob.getDate();
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				if( date != null) {
					dob = dFormat.format(Date_dob.getDate());
				}
				String phone_num = Phone_num.getText();
				unique = Unique.getText();
				
				
		
				
				
				Boolean existentBoolean = false;
				
				
					Connection connection = Connection_provider.getcon();
					

					String s = (String) comboBox.getSelectedItem();

	                switch (s) {
	                    case "Life Insurance":
	                    	try {
	                    		
	                    		PreparedStatement ps = connection.prepareStatement("select *\r\n"
		            					+ "from life_insurance\r\n"
		            					+ "where aadhar_card_owner= ? and aadhar_card_num_holder= ?");
		            			ps.setString(1, Customers_login.getAadhar_card());
		            			ps.setString(2, unique);
		            			ResultSet rs = ps.executeQuery();
		                        
		                        while(rs.next())

		                        {
		                       
		                        	
		                        	if(name.equals(rs.getString("Name")) &&  phone_num.equals(rs.getString("Phone_num")) && dob.equals(rs.getString("Date_of_birth"))) {
		                        		existentBoolean = true;
		                        	}
		                        }
		                        
		                        if(existentBoolean) {
			            			tabbedPane.setSelectedIndex(1);
			            			try {
			            				
			            				 PreparedStatement ps_4 = connection.prepareStatement("select * from life_insurance where aadhar_card_num_holder = ?");
				               			 ps_4.setString(1, unique);
				               			 ResultSet rs_4 = ps_4.executeQuery();
				               			 while(rs_4.next()) {
				               				 
				               				 Life_Name.setText(rs_4.getString("Name"));
				               				 Life_Phone_num.setText(rs_4.getString("Phone_num"));
				               				 Life_aadhar_num.setText(rs_4.getString("aadhar_card_num_holder"));
				               				 Life_dob.setText(rs_4.getString("Date_of_birth"));
				               				 Life_Gender.setText(rs_4.getString("Gender"));
				               				 Life_bloodgroup.setText(rs_4.getString("blood_group"));
				               				 Life_address.setText(rs_4.getString("address"));
				               				 Life_premium.setText(rs_4.getString("claim"));
				               				 Nominee.setText(rs_4.getString("nominee"));
				               				 Nominee_relationship.setText(rs_4.getString("nominee_relation"));
				               				 
				               			 } 
				               			 
				               			 connection.close();
				          	
				               		} catch (Exception e4) {
				               			// TODO: handle exception
				               			JOptionPane.showMessageDialog(null, e);
				               		}

			            			
		                        }else {
		                        	JOptionPane.showMessageDialog(null, "Please check all details correctly");
		                        }
		                        connection.close();
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
	                    	
	                    		            			
	            			
	                        break;
	                        
	                    case "Home Insurance":
	                 	try {
							
						
	                    	PreparedStatement ps_2 = connection.prepareStatement("select *\r\n"
	                    			+ "from home_insurance\r\n"
	                    			+ "where aadhar_card_owner=? and address = ?\r\n"
	                    			+ "");
	                        ps_2.setString(1,Customers_login.getAadhar_card());
	                        ps_2.setString(2, unique);
	                        
	                        ResultSet rs_2 = ps_2.executeQuery();
	                        while(rs_2.next())

	                        {
	                        	if(name.equals(rs_2.getString("Name")) &&  phone_num.equals(rs_2.getString("Phone_num")) && dob.equals(rs_2.getString("Date_of_birth"))) {
	                        		existentBoolean = true;
	                        	}
	                        	
	                        }
	                        if(existentBoolean) {
		            			tabbedPane.setSelectedIndex(2);
		            			try {
		            				
		            				 PreparedStatement ps_4 = connection.prepareStatement("select * from home_insurance where address = ?");
			               			 ps_4.setString(1, unique);
			               			 ResultSet rs_4 = ps_4.executeQuery();
			               			 while(rs_4.next()) {
			               				//insurance_id, policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, address, 		 
			               				 Home_name.setText(rs_4.getString("Name"));
			               				 Home_Phone_num.setText(rs_4.getString("Phone_num"));
			               				 Home_aadhar.setText(rs_4.getString("aadhar_card_owner"));
			               				 Home_dob.setText(rs_4.getString("Date_of_birth"));			               				 			    
			               				 Home_address.setText(rs_4.getString("address"));
			               				 Home_claim.setText(rs_4.getString("claim"));
			               				 Home_claimleft.setText(rs_4.getString("claim_left"));			               	 
			               			 } 
			               			 connection.close();
			          	
			               		} catch (Exception e4) {
			               			// TODO: handle exception
			               			JOptionPane.showMessageDialog(null, e);
			               		}
		            			
	                        }else {
	                        	JOptionPane.showMessageDialog(null, "Please check all details correctly");
	                        }
	                        
	                        
	                 	} catch (Exception e2) {
							// TODO: handle exception
						}
	                    	
	                        break;
	                        
	                        
	                    case "Vehicle Insurance":
	                    try {
							
							PreparedStatement ps_3 = connection.prepareStatement("select *\r\n"
	                    			+ "from Vechile_insurance\r\n"
	                    			+ "where aadhar_card_owner= ?  and vechile_registration_number =  ? ");
	                        ps_3.setString(1, Customers_login.getAadhar_card());
	                        ps_3.setString(2, unique);
	                        
	                        ResultSet rs_3 = ps_3.executeQuery();
	                        
	                        while(rs_3.next())
	                        {
	                        	if(name.equals(rs_3.getString("Name")) &&  phone_num.equals(rs_3.getString("Phone_num")) && dob.equals(rs_3.getString("Date_of_birth"))) {
	                        		existentBoolean = true;
	                        	}
	                        		                        						
	                        }
	                        if(existentBoolean) {
		            			tabbedPane.setSelectedIndex(3);
		            			try {
		            	//insurance_id, policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, vechile_model, vechile_registration_number, aadhar_card_owner			
		            				 PreparedStatement ps_4 = connection.prepareStatement("select * from Vechile_insurance where vechile_registration_number = ?");
			               			 ps_4.setString(1, unique);
			               			 ResultSet rs_4 = ps_4.executeQuery();
			               			 while(rs_4.next()) {
			               			 
			               				 Vehicle_name.setText(rs_4.getString("Name"));
			               				 VehiclePhone_num.setText(rs_4.getString("Phone_num"));
			               				 Vehicle_aadhar.setText(rs_4.getString("aadhar_card_owner"));
			               				 Vehicle_dob.setText(rs_4.getString("Date_of_birth"));			               				 			    
			               				 Vehicle_address.setText(rs_4.getString("address"));
			               				 Vehicle_claim.setText(rs_4.getString("claim"));
			               				 Vehicle_Model.setText(rs_4.getString("vechile_model"));
			               				 Vehicle_registration.setText(rs_4.getString("vechile_registration_number"));
			               				 Vehicle_claimleft.setText(rs_4.getString("claim_left"));
			               				
			               			 } 
			          	
			               		} catch (Exception e4) {
			               			// TODO: handle exception
			               			JOptionPane.showMessageDialog(null, e);
			               		}
		            			
		            			
		            			  connection.close();
	                        }else {
	                        	JOptionPane.showMessageDialog(null, "Please check all details correctly");
	                        }
	                    	
	                        break;
	                      
	                        
	                    } catch (Exception e2) {
							// TODO: handle exception
						}	
	                        
	                    default:                     
	                        break;
	                }
				
			
				
			}
		});

		btnNewButton.setBounds(515, 477, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Go back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Customer_dashboard().setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(1079, 24, 89, 23);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name:-");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(71, 31, 150, 35);
		panel_2.add(lblNewLabel_1_1_1);
		
		Life_Name = new JTextField();
		Life_Name.setEditable(false);
		Life_Name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_Name.setColumns(10);
		Life_Name.setBounds(260, 38, 200, 22);
		panel_2.add(Life_Name);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date of birth");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(636, 38, 150, 20);
		panel_2.add(lblNewLabel_2_1);
		
		Life_dob = new JTextField();
		Life_dob.setEditable(false);
		Life_dob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_dob.setColumns(10);
		Life_dob.setBounds(808, 38, 200, 22);
		panel_2.add(Life_dob);
		
		Life_Gender = new JTextField();
		Life_Gender.setEditable(false);
		Life_Gender.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_Gender.setColumns(10);
		Life_Gender.setBounds(808, 99, 200, 22);
		
		panel_2.add(Life_Gender);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(636, 92, 150, 35);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Phone Number");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(71, 92, 150, 35);
		panel_2.add(lblNewLabel_5_1);
		
		Life_Phone_num = new JTextField();
		Life_Phone_num.setColumns(10);
		Life_Phone_num.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_Phone_num.setEditable(false);
		Life_Phone_num.setBounds(260, 99, 200, 22);
		panel_2.add(Life_Phone_num);
		
		JLabel lblNewLabel_1_2 = new JLabel("Aadhar card number");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(71, 166, 164, 35);
		panel_2.add(lblNewLabel_1_2);
		
		Life_aadhar_num = new JTextField();
		Life_aadhar_num.setEditable(false);
		Life_aadhar_num.setColumns(10);
		Life_aadhar_num.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_aadhar_num.setBounds(260, 173, 200, 22);
		panel_2.add(Life_aadhar_num);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("blood group");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(636, 166, 150, 35);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		Life_bloodgroup = new JTextField();
		Life_bloodgroup.setEditable(false);
		Life_bloodgroup.setColumns(10);
		Life_bloodgroup.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_bloodgroup.setBounds(808, 173, 200, 22);
		panel_2.add(Life_bloodgroup);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("address");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(636, 240, 150, 35);
		panel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cause of death");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(71, 240, 150, 35);
		panel_2.add(lblNewLabel_1_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 246, 208, 84);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Insurance Coverage\r\n");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1.setBounds(636, 318, 150, 35);
		panel_2.add(lblNewLabel_4_1_1_1);
		
		Life_premium = new JTextField();
		Life_premium.setEditable(false);
		Life_premium.setColumns(10);
		Life_premium.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Life_premium.setBounds(808, 325, 200, 22);
		panel_2.add(Life_premium);
		
		Life_address = new JTextArea();
		Life_address.setOpaque(false);
		Life_address.setEditable(false);
		Life_address.setLineWrap(true);
		Life_address.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		Life_address.setBounds(808, 246, 200, 56);
		panel_2.add(Life_address);
		
		JButton btnNewButton_2 = new JButton("Claim Insurance");
		btnNewButton_2.addActionListener(new ActionListener() {
			/**
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				
				try {
    				Connection connection = Connection_provider.getcon();
   				 	PreparedStatement ps_life = connection.prepareStatement("select * from life_insurance where aadhar_card_num_holder = ?");
          			ps_life.setString(1, unique);
          			ResultSet rs_life = ps_life.executeQuery();
          			while(rs_life.next()) {
          				 
          				String sec_ques = rs_life.getString("secret_ques");
          				String rel = rs_life.getString("nominee_relation");
          				String sec_ans = rs_life.getString("answer");
          				
          				 if(rs_life.getString("claim_status").equals("Not claimed")) {
          					 JTextField passField = new JTextField();
						     String message_1 = "Please answer"+ Life_Name.getText() +"'s secret question.";
						     int result = JOptionPane.showOptionDialog(null, new Object[] {message_1,sec_ques, passField},
						     "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						     
						     if(result == 0) {
						    	 String compString = passField.getText();
						    	 if(compString.equals(sec_ans)) {
						    		 String setString = "Claimed";
							    	 System.out.println("Your claim is " + rs_life.getString("claim"));
							    	 
							    	 PreparedStatement life_find = connection.prepareStatement("select * from life_insurance where aadhar_card_num_holder = ? ");
							    	 life_find.setString(1, unique);
							    	 ResultSet life_details = life_find.executeQuery();
							    	 while(life_details.next()) {
							    		 // policy_id, Type, Name, Phone_num, claim, Date_of_birth, Gender, ,address,  nominee, nominee_relation
							    	//life_verify table	 // Policy_id, policy_plan, Name, Phone_num, claim, DOB, GENDER, Nominee, Nominee_relationship
							    		 String pol_idString = rs_life.getString("policy_id");
							    		 PreparedStatement	ps_background = connection.prepareStatement("insert into life_insurance_verify(Policy_id, policy_plan, Name, Phone_num, claim, DOB, GENDER, Nominee, Nominee_relationship) select policy_id, Type, Name, Phone_num, claim, Date_of_birth, Gender, nominee, nominee_relation from life_insurance where aadhar_card_num_holder = ? ");
		          						 ps_background.setString(1, unique);
		          						 ps_background.executeUpdate();
		          						 PreparedStatement	ps_update = connection.prepareStatement("update life_insurance_verify set status = 'pending',Cause_of_death = ? where policy_id =? ");
		          						 ps_update.setString(1, textArea.getText());
		          						 ps_update.setString(2, pol_idString);
		          						 ps_update.executeUpdate();
		          						 
		          						 
		          						 JOptionPane.showMessageDialog(null, "Your life insurance claim will be verified and amount will be paid to you"); 	
							    		 
							    		 
							    		 
							    	 }
							    	 
							    	 
							    	 
//							    	 PreparedStatement life_update = connection.prepareStatement("update life_insurance set claim_status = ? where aadhar_card_num_holder = ?");
//							    	 life_update.setString(1, setString);
//							    	 life_update.setString(2, unique);
//							    	 life_update.executeUpdate();
//							    	 JOptionPane.showMessageDialog(null, "Your insurance claim will be verified and amount will be paid to you");
						    	 }
						    	 else {
						    		 JOptionPane.showMessageDialog(null, "wrong answer");
						    	 }
						    	 
						     }
          				 }
          				 else {
          					 JOptionPane.showMessageDialog(null, "Your insurance has already been claimed");
          					 JOptionPane.showMessageDialog(null, "Incase of any discrepancies call admin");
          				 }
          	 
          			 } 
          			 
          			 connection.close();
     	
          		} catch (Exception e4) {
          			// TODO: handle exception
          			JOptionPane.showMessageDialog(null, e);
          		}

				
			}
		});
		
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(475, 498, 150, 23);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Nominee");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(71, 357, 164, 35);
		panel_2.add(lblNewLabel_1_2_3);
		
		Nominee = new JTextField();
		Nominee.setEditable(false);
		Nominee.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Nominee.setColumns(10);
		Nominee.setBounds(260, 364, 200, 22);
		panel_2.add(Nominee);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Nominee relationship\r\n");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(619, 383, 164, 35);
		panel_2.add(lblNewLabel_1_2_4);
		
		Nominee_relationship = new JTextField();
		Nominee_relationship.setEditable(false);
		Nominee_relationship.setColumns(10);
		Nominee_relationship.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Nominee_relationship.setBounds(808, 390, 200, 22);
		panel_2.add(Nominee_relationship);
		
		JButton btnNewButton_1_2 = new JButton("Go back");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Customer_dashboard().setVisible(true);
			}
		});
		btnNewButton_1_2.setBounds(1133, 11, 89, 23);
		panel_2.add(btnNewButton_1_2);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		Home_address = new JTextArea();
		Home_address.setOpaque(false);
		Home_address.setLineWrap(true);
		Home_address.setEditable(false);
		Home_address.setBounds(803, 118, 200, 56);
		panel_3.add(Home_address);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("address");
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_2.setBounds(631, 112, 150, 35);
		panel_3.add(lblNewLabel_4_1_1_2);
		
		Home_dob = new JTextField();
		
		Home_dob.setColumns(10);
		Home_dob.setBounds(803, 58, 200, 22);
		panel_3.add(Home_dob);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date of birth");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(631, 58, 150, 20);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Insurance Coverage\r\n");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1_1.setBounds(631, 190, 150, 35);
		panel_3.add(lblNewLabel_4_1_1_1_1);
		
		Home_claim = new JTextField();
		Home_claim.setColumns(10);
		Home_claim.setBounds(803, 197, 200, 22);
		panel_3.add(Home_claim);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Reason to claim Insurance");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBounds(66, 260, 180, 35);
		panel_3.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Aadhar card number");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(66, 186, 164, 35);
		panel_3.add(lblNewLabel_1_2_2);
		
		Home_aadhar = new JTextField();
		Home_aadhar.setColumns(10);
		Home_aadhar.setBounds(255, 193, 200, 22);
		panel_3.add(Home_aadhar);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Phone Number");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_1_1.setBounds(66, 112, 150, 35);
		panel_3.add(lblNewLabel_5_1_1);
		
		Home_Phone_num = new JTextField();
		Home_Phone_num.setColumns(10);
		Home_Phone_num.setBounds(255, 119, 200, 22);
		panel_3.add(Home_Phone_num);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Name:-");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(66, 51, 150, 35);
		panel_3.add(lblNewLabel_1_1_1_2);
		
		Home_name = new JTextField();
		Home_name.setColumns(10);
		Home_name.setBounds(255, 58, 200, 22);
		panel_3.add(Home_name);
		
		JTextArea Home_reason = new JTextArea();
		Home_reason.setLineWrap(true);
		Home_reason.setText("Please enter details here");
		Home_reason.setBounds(256, 266, 199, 82);
		panel_3.add(Home_reason);
		
		Home_aadhar.setEditable(false);
		Home_claim.setEditable(false);
		Home_dob.setEditable(false);
		Home_name.setEditable(false);
		Home_Phone_num.setEditable(false);
		
		
		Home_aadhar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_claim.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_dob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_Phone_num.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		JButton btnNewButton_2_1 = new JButton("Claim Insurance");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
    				Connection connection = Connection_provider.getcon();
   				 	PreparedStatement ps_home = connection.prepareStatement("select * from home_insurance where address = ?");
          			ps_home.setString(1, unique);
          			ResultSet rs_life = ps_home.executeQuery();
          			while(rs_life.next()) {
          					int claim_lft = rs_life.getInt("claim_left");
          					if(claim_lft>0) {
          						String claim_currstr = home_user_claim.getText();
          						Integer claim_curr = Integer.parseInt(claim_currstr);
          						int claim_now = claim_lft-claim_curr;
          						if(claim_now>0) {
          							String insurString ="Home Insurance";
          						//Name, aadhar_card, Phone_number, type_of_Insurance, address, Reason_to_claim, Claim_requested, claim_approved
          							PreparedStatement	ps_background = connection.prepareStatement("insert into non_admin_verify(Name, aadhar_card, Phone_number, type_of_Insurance, address, Reason_to_claim, Claim_requested, claim_approved,policy_id) values(?,?,?,?,?,?,?,?,?)");
          							ps_background.setString(1, rs_life.getString("Name"));
          							ps_background.setString(2, Customers_login.getAadhar_card());
          							ps_background.setString(3, rs_life.getString("Phone_num"));
          							ps_background.setString(4, insurString);
          							ps_background.setString(5, rs_life.getString("address"));
          							ps_background.setString(6, Home_reason.getText());
          							ps_background.setInt(7, claim_curr);
          							ps_background.setInt(8,0);
          							ps_background.setInt(9, rs_life.getInt("policy_id"));
          							ps_background.executeUpdate();
          							
          							
          							
          							
//          						
          							
          				//insurance_id, policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, address, aadhar_card_owner, claim_left
          							
          							
          							
          								//System.out.println(claim_now);
//          							PreparedStatement home_update = connection.prepareStatement("update home_insurance set claim_left = ? where address = ?");
//          							home_update.setInt(1, claim_now);
//          							home_update.setString(2, unique);
//          							home_update.executeUpdate();
          							JOptionPane.showMessageDialog(null, "Your insurance claim will be verified and amount will be paid to you");
          						}
          						else {
          							JOptionPane.showMessageDialog(null,"Sorry you don't have that much claim left" );
          						}
          					}
          					else {
								JOptionPane.showMessageDialog(null, "Sorry you have no claim left");
							}
          	 
          			 }
          			
          			
          			
          			 
          			 connection.close();
     	
          		} catch (Exception e4) {
          			// TODO: handle exception
          			JOptionPane.showMessageDialog(null, e);
          		}

				
			}
		});
		btnNewButton_2_1.setFocusable(false);
		btnNewButton_2_1.setBounds(479, 503, 150, 23);
		panel_3.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("claim Left");
		lblNewLabel_4_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1_1_2.setBounds(631, 260, 150, 35);
		panel_3.add(lblNewLabel_4_1_1_1_1_2);
		
		Home_claimleft = new JTextField();
		Home_claimleft.setEditable(false);
		Home_claimleft.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_claimleft.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Home_claimleft.setColumns(10);
		Home_claimleft.setBounds(803, 267, 200, 22);
		panel_3.add(Home_claimleft);
		
		JLabel lblNewLabel_4_1_1_1_1_2_2 = new JLabel("Enter amount you want to claim");
		lblNewLabel_4_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1_1_1_2_2.setBounds(563, 325, 225, 35);
		panel_3.add(lblNewLabel_4_1_1_1_1_2_2);
		
		home_user_claim = new JTextField();
	
		home_user_claim.setColumns(10);
		home_user_claim.setBounds(803, 332, 200, 22);
		panel_3.add(home_user_claim);
		
		
		
		
		
		JButton btnNewButton_1_3 = new JButton("Go back");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Customer_dashboard().setVisible(true);
			}
		});
		btnNewButton_1_3.setBounds(1141, 25, 89, 23);
		panel_3.add(btnNewButton_1_3);
		JPanel panel = new JPanel();
		
				
				
				
				
				tabbedPane.addTab("New tab", null, panel, null);
				panel.setLayout(null);
				
				Vehicle_dob = new JTextField();
				Vehicle_dob.setColumns(10);
				Vehicle_dob.setBounds(808, 39, 200, 22);
				panel.add(Vehicle_dob);
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("Date of birth");
				lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_2_1_1_1.setBounds(636, 39, 150, 20);
				panel.add(lblNewLabel_2_1_1_1);
				
				JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Insurance Coverage\r\n");
				lblNewLabel_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_1_1_1.setBounds(636, 344, 150, 35);
				panel.add(lblNewLabel_4_1_1_1_1_1);
				
				Vehicle_claim = new JTextField();
				Vehicle_claim.setEditable(false);
				Vehicle_claim.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_claim.setColumns(10);
				Vehicle_claim.setBounds(808, 351, 200, 22);
				panel.add(Vehicle_claim);
				
				JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Name:-");
				lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_1_1_1_2_1.setBounds(71, 32, 150, 35);
				panel.add(lblNewLabel_1_1_1_2_1);
				
				Vehicle_name = new JTextField();
				Vehicle_name.setColumns(10);
				Vehicle_name.setBounds(260, 39, 200, 22);
				panel.add(Vehicle_name);
				
				JLabel lblNewLabel_5_1_1_1 = new JLabel("Phone Number");
				lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_5_1_1_1.setBounds(71, 93, 150, 35);
				panel.add(lblNewLabel_5_1_1_1);
				
				VehiclePhone_num = new JTextField();
				VehiclePhone_num.setColumns(10);
				VehiclePhone_num.setBounds(260, 100, 200, 22);
				panel.add(VehiclePhone_num);
				
				JLabel lblNewLabel_1_2_2_1 = new JLabel("Aadhar card number");
				lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_1_2_2_1.setBounds(71, 167, 164, 35);
				panel.add(lblNewLabel_1_2_2_1);
				
				Vehicle_aadhar = new JTextField();
				Vehicle_aadhar.setColumns(10);
				Vehicle_aadhar.setBounds(260, 174, 200, 22);
				panel.add(Vehicle_aadhar);
				
				JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Reason to claim Insurance");
				lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_1_2_1_1_1.setBounds(71, 241, 180, 35);
				panel.add(lblNewLabel_1_2_1_1_1);
				
				JTextArea Vehicle_reason = new JTextArea();
				Vehicle_reason.setLineWrap(true);
				Vehicle_reason.setText("Please enter details here");
				Vehicle_reason.setBounds(261, 248, 206, 82);
				panel.add(Vehicle_reason);
				
				JLabel lblNewLabel_4_1_1_2_1 = new JLabel("address");
				lblNewLabel_4_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_2_1.setBounds(636, 93, 150, 35);
				panel.add(lblNewLabel_4_1_1_2_1);
				
				Vehicle_address = new JTextArea();
				Vehicle_address.setLineWrap(true);
				Vehicle_address.setEditable(false);
				Vehicle_address.setBounds(808, 99, 200, 56);
				panel.add(Vehicle_address);
				
				JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Vehicle Model");
				lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_1_1_1_1.setBounds(636, 187, 150, 35);
				panel.add(lblNewLabel_4_1_1_1_1_1_1);
				
				Vehicle_Model = new JTextField();
				Vehicle_Model.setColumns(10);
				Vehicle_Model.setBounds(808, 194, 200, 22);
				panel.add(Vehicle_Model);
				
				JLabel lblNewLabel_4_1_1_1_1_1_2 = new JLabel("Vehicle Registration number");
				lblNewLabel_4_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_1_1_1_2.setBounds(586, 261, 200, 35);
				panel.add(lblNewLabel_4_1_1_1_1_1_2);
				
				Vehicle_registration = new JTextField();
				Vehicle_registration.setColumns(10);
				Vehicle_registration.setBounds(808, 268, 200, 22);
				panel.add(Vehicle_registration);
				
				
			
				
				Vehicle_aadhar.setEditable(false);
				Vehicle_address.setEditable(false);
				Vehicle_address.setOpaque(false);
				Vehicle_dob.setEditable(false);
				Vehicle_Model.setEditable(false);
				Vehicle_name.setEditable(false);
				Vehicle_registration.setEditable(false);
				VehiclePhone_num.setEditable(false);
				
				

				Vehicle_aadhar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_dob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_Model.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_registration.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				VehiclePhone_num.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				
				JButton btnNewButton_2_2 = new JButton("Claim Insurance");
				btnNewButton_2_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
		    				Connection connection = Connection_provider.getcon();
		   				 	PreparedStatement ps_vehicle = connection.prepareStatement("select * from Vechile_insurance where vechile_registration_number = ?");
		          			ps_vehicle.setString(1, unique);
		          			ResultSet rs_life = ps_vehicle.executeQuery();
		          			while(rs_life.next()) {
		          					int claim_lft = rs_life.getInt("claim_left");
		          					if(claim_lft>0) {
		          						String claim_currstr = vehicle_user_claim.getText();
		          						int claim_curr = Integer.parseInt(claim_currstr);
		          						int claim_now = claim_lft-claim_curr;
		          						if(claim_now>0) {
		          							String insurString ="Vehicle Insurance";
		              						//Name, aadhar_card, Phone_number, type_of_Insurance, address, Reason_to_claim, Claim_requested, claim_approved
		          							
		          							
		          							PreparedStatement	ps_background = connection.prepareStatement("insert into non_admin_verify(Name, aadhar_card, Phone_number, type_of_Insurance, address, Reason_to_claim, Claim_requested, claim_approved,policy_id) values(?,?,?,?,?,?,?,?,?)");
		          							ps_background.setString(1, rs_life.getString("Name"));
		          							ps_background.setString(2, Customers_login.getAadhar_card());
		          							ps_background.setString(3, rs_life.getString("Phone_num"));
		          							ps_background.setString(4, insurString);
		          							ps_background.setString(5, rs_life.getString("address"));
		          							ps_background.setString(6, Vehicle_reason.getText());
		          							ps_background.setInt(7, claim_curr);
		          							ps_background.setInt(8,0);
		          							ps_background.setInt(9, rs_life.getInt("policy_id"));
		          							ps_background.executeUpdate();
		          							JOptionPane.showMessageDialog(null,"Your claim will be verified and your amount will be paid");
		          							
		          							//  insurance_id, policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, vechile_model, vechile_registration_number, aadhar_card_owner, address, claim_left
		          						
		          							
		          							
		          							
		          							
//		          							System.out.println(claim_now);
//		          							PreparedStatement home_update = connection.prepareStatement("update vechile_insurance set claim_left = ? where vechile_registration_number = ?");
//		          							home_update.setInt(1, claim_now);
//		          							home_update.setString(2, unique);
//		          							home_update.executeUpdate();
//		          							JOptionPane.showMessageDialog(null, "Your insurance claim will be verified and amount will be paid to you");
		          						}
		          						else {
		          							JOptionPane.showMessageDialog(null,"Sorry you don't have that much claim left" );
		          						}
		          					}
		          					else {
										JOptionPane.showMessageDialog(null, "Sorry you have no claim left");
									}
		          	 
		          			 } 
		          			 
		          			 connection.close();
		     	
		          		} catch (Exception e4) {
		          			// TODO: handle exception
		          			JOptionPane.showMessageDialog(null, e);
		          		}
												
					}
				});
				btnNewButton_2_2.setFocusable(false);
				btnNewButton_2_2.setBounds(461, 497, 150, 23);
				panel.add(btnNewButton_2_2);
				
				Vehicle_claimleft = new JTextField();
				Vehicle_claimleft.setEditable(false);
				Vehicle_claimleft.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				Vehicle_claimleft.setColumns(10);
				Vehicle_claimleft.setBounds(260, 366, 200, 22);
				panel.add(Vehicle_claimleft);
				
				JLabel lblNewLabel_4_1_1_1_1_2_1 = new JLabel("claim Left");
				lblNewLabel_4_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_1_1_2_1.setBounds(71, 359, 150, 35);
				panel.add(lblNewLabel_4_1_1_1_1_2_1);
				
				vehicle_user_claim = new JTextField();
				vehicle_user_claim.setColumns(10);
				vehicle_user_claim.setBounds(260, 437, 200, 22);
				panel.add(vehicle_user_claim);
				
				JLabel lblNewLabel_4_1_1_1_1_2_2_1 = new JLabel("Enter amount you want to claim");
				lblNewLabel_4_1_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_4_1_1_1_1_2_2_1.setBounds(26, 430, 225, 35);
				panel.add(lblNewLabel_4_1_1_1_1_2_2_1);
				
				JButton btnNewButton_1_4 = new JButton("Go back");
				btnNewButton_1_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new Customer_dashboard().setVisible(true);
					}
				});
				btnNewButton_1_4.setBounds(1144, 39, 89, 23);
				panel.add(btnNewButton_1_4);
				
				panel_1.setOpaque(false);
				panel_2.setOpaque(false);
				panel_3.setOpaque(false);
				panel.setOpaque(false);
		
		
			}
}
