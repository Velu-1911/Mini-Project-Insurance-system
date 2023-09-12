package Cutomers;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import database.Connection_provider;
import javax.swing.ImageIcon;

public class Vechile_insurance_registration extends JFrame {
	
	

	private JPanel contentPane;
	
	
	
	private JTextField NAME;
	private JTextField PHONE_NUM;
	
	public static Integer premium_monthly;
	public String mobileNumberPattern = "^[0-9]*$";
	public static Integer coverage;
	public static String plan_type;
	private JTextField VECHILE_REG;
	private JTextField VECH_MODEL;
	private JTextField Address;
	public static Boolean termBoolean=false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vechile_insurance_registration frame = new Vechile_insurance_registration();
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
	public Vechile_insurance_registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1293, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("VECHILE INSURANCE HOLDER DETAILS");
		lblNewLabel.setBounds(244, -5, 830, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 1263, 2);
		contentPane.add(separator);
		
		NAME = new JTextField();
		NAME.setOpaque(false);
		NAME.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		NAME.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NAME.setColumns(10);
		NAME.setBounds(628, 71, 282, 33);
		contentPane.add(NAME);
		
		JDateChooser Date_Dob = new JDateChooser();
		Date_Dob.setBounds(628, 137, 282, 33);
		contentPane.add(Date_Dob);
		
		PHONE_NUM = new JTextField();
		PHONE_NUM.setOpaque(false);
		PHONE_NUM.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		PHONE_NUM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PHONE_NUM.setColumns(10);
		PHONE_NUM.setBounds(628, 206, 282, 33);
		contentPane.add(PHONE_NUM);
		
		JCheckBox theft = new JCheckBox("Theft and burglary coverage");
		theft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		theft.setBounds(662, 460, 235, 23);
		contentPane.add(theft);
		
		JCheckBox riot = new JCheckBox("riot damage");
		riot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		riot.setBounds(662, 514, 235, 23);
		contentPane.add(riot);
		
		VECHILE_REG = new JTextField();
		VECHILE_REG.setOpaque(false);
		VECHILE_REG.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		VECHILE_REG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VECHILE_REG.setColumns(10);
		VECHILE_REG.setBounds(628, 342, 282, 33);
		contentPane.add(VECHILE_REG);
		
		VECH_MODEL = new JTextField();
		VECH_MODEL.setOpaque(false);
		VECH_MODEL.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		VECH_MODEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VECH_MODEL.setColumns(10);
		VECH_MODEL.setBounds(628, 274, 282, 33);
		contentPane.add(VECH_MODEL);
		
		
		
		ButtonGroup G = new ButtonGroup();
		
		
		
		JButton btnNewButton = new JButton("Create Policy");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				String name = NAME.getText();
				String dob = "";
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date date =  Date_Dob.getDate();
				if( date != null) {
					dob = dFormat.format(Date_Dob.getDate());
				}
				String phone_num = PHONE_NUM.getText();
				String vechileModel = VECH_MODEL.getText();
				String vechileReg_no = VECHILE_REG.getText();
				String addressString = Address.getText();
				
				
				if(theft.isSelected()) {
					premium_monthly+=400;
				}
				if(riot.isSelected()) {
					premium_monthly+=100;
				}
				
				
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder name is required");
					
				}else if (dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Date of birth is required");
				}
				else if (phone_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Phone number is required");
				}
				else if (!phone_num.matches(mobileNumberPattern) ||phone_num.length() !=10 ) {
					JOptionPane.showMessageDialog(null, "Policy holder mobile number is invalid ");
				}
				else if (vechileModel.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder vechile model is required");
				}
				else if (vechileReg_no.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder vechile registration is required");
				}
				else if (addressString.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder address is required");
				}
				
				else {
					
					try {
						Connection connection = Connection_provider.getcon();
						PreparedStatement ps = connection.prepareStatement("insert into policy(Name, Type, aadhar_card_owner, email,aadhar_card_holder,policy_create_date) values (?,'Vehicle_Insurance',?,?,?,?)");
						ps.setString(1, Customers_login.getUu_name());
						ps.setString(2, Customers_login.getAadhar_card());
						ps.setString(3, Customers_login.getEmail());
						ps.setString(4, Customers_login.getAadhar_card());
						
						LocalDateTime  today=LocalDateTime.now();
						
						DateTimeFormatter dFormat_5 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

						String todayString = dFormat_5.format(today);
						System.out.println(todayString);
						
						ps.setString(5,todayString );						
						
						ps.executeUpdate();
						
					
						
						
						Statement st = connection.createStatement();
						ResultSet rs = st.executeQuery("select *from policy ORDER BY policy_id DESC LIMIT 1;");
						Integer id = null;
						while(rs.next()) {
							System.out.println(rs.getString("policy_id"));
							id=rs.getInt("policy_id"); 
						}
						
						PreparedStatement ps_2 = connection.prepareStatement("insert into Vechile_insurance(policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim,vechile_model, vechile_registration_number,aadhar_card_owner,address,claim_left)   values (?,?,?,?,?,?,?,?,?,?,?,?)");
																									    
																									 	// policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, vechile_model, vechile_registration_number, aadhar_card_owner
						ps_2.setInt(1, id);
						ps_2.setString(2, name);
						ps_2.setString(3, dob);
						ps_2.setString(4, plan_type);
						ps_2.setString(5, phone_num);
						ps_2.setInt(6, premium_monthly);
						ps_2.setInt(7, coverage);
						ps_2.setString(8, vechileModel);
						ps_2.setString(9, vechileReg_no);
						ps_2.setString(10, Customers_login.getAadhar_card());
						ps_2.setString(11, addressString);
						ps_2.setInt(12, coverage);
						ps_2.executeUpdate();
						
						setVisible(false);
						dispose();
						new Vechile_insurance_registration().setVisible(true);
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,e2);
					}
					
					
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(550, 589, 121, 23);
		contentPane.add(btnNewButton);
		
		JTextArea txtrSelectingTheseOptional = new JTextArea();
		txtrSelectingTheseOptional.setEditable(false);
		txtrSelectingTheseOptional.setOpaque(false);
		txtrSelectingTheseOptional.setText("Caution:-Selecting these \r\noptional coverage\r\nwould increase \r\nyour yearly premium\r\n");
		txtrSelectingTheseOptional.setBounds(306, 501, 150, 82);
		contentPane.add(txtrSelectingTheseOptional);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Apply_policy_customer().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1158, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Address = new JTextField();
		Address.setOpaque(false);
		Address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Address.setColumns(10);
		Address.setBounds(628, 409, 282, 33);
		contentPane.add(Address);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Vechile_insurance_registration.class.getResource("/images/Vechile_insurance.png")));
		lblNewLabel_1.setBounds(0, 0, 1279, 654);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
