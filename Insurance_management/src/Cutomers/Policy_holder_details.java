package Cutomers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import database.Connection_provider;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Policy_holder_details extends JFrame {

	private JPanel contentPane;
	
	private static String plan;
	private JTextField NAME;
	private JTextField GENDER;
	private JTextField ADDRESS;
	private JTextField AADHAR_CARD;
	
	public static Integer premium_monthly;
	public String mobileNumberPattern = "^[0-9]*$";
	public static Integer coverage;
	public static String plan_type;
	int smoker;
	private JTextField Phone_Number;
	private JTextField Nominee;
	private JTextField ans;
	private JTextField nominee_rel;
	
	
	public static Boolean termBoolean=false;
	

	
	

	public static String getPlan() {
		return plan;
	}

	public static void setPlan(String plan1) {
		Policy_holder_details.plan = plan1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Policy_holder_details frame = new Policy_holder_details();
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
	public Policy_holder_details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1297, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSURANCE HOLDER DETAILS");
		lblNewLabel.setBounds(316, 0, 632, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 56, 1263, 2);
		contentPane.add(separator);
		
		NAME = new JTextField();
		NAME.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NAME.setOpaque(false);
		NAME.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		NAME.setColumns(10);
		NAME.setBounds(107, 89, 267, 41);
		contentPane.add(NAME);
		
		JDateChooser Date_Dob = new JDateChooser();
		Date_Dob.setBackground(new Color(192, 192, 192));
		Date_Dob.setForeground(new Color(255, 255, 255));
		Date_Dob.setBounds(107, 184, 267, 34);
		contentPane.add(Date_Dob);
		
		GENDER = new JTextField();
		GENDER.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GENDER.setOpaque(false);
		GENDER.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		GENDER.setColumns(10);
		GENDER.setBounds(107, 369, 272, 41);
		contentPane.add(GENDER);
		
		ADDRESS = new JTextField();
		ADDRESS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ADDRESS.setOpaque(false);
		ADDRESS.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ADDRESS.setColumns(10);
		ADDRESS.setBounds(107, 457, 267, 34);
		contentPane.add(ADDRESS);
		
		AADHAR_CARD = new JTextField();
		AADHAR_CARD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AADHAR_CARD.setOpaque(false);
		AADHAR_CARD.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		AADHAR_CARD.setColumns(10);
		AADHAR_CARD.setBounds(107, 566, 267, 41);
		contentPane.add(AADHAR_CARD);
		
		
		JComboBox Blood_group = new JComboBox();
		Blood_group.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Blood_group.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		Blood_group.setBounds(725, 92, 298, 34);
		Blood_group.setUI(new BasicComboBoxUI());
		contentPane.add(Blood_group);
		
		JRadioButton smokeyes = new JRadioButton("Yes");
		smokeyes.setBounds(738, 566, 111, 23);
		contentPane.add(smokeyes);
		
		JRadioButton smokeno = new JRadioButton("No");
		smokeno.setBounds(912, 566, 111, 23);
		contentPane.add(smokeno);
		
		ButtonGroup G = new ButtonGroup();
		G.add(smokeno);
		G.add(smokeyes);
		
		JComboBox secret_ques = new JComboBox();
		secret_ques.setFont(new Font("Tahoma", Font.PLAIN, 15));
		secret_ques.setModel(new DefaultComboBoxModel(new String[] {"Name of your school", "Year of marriage", "Name of you'r oldest niece", "City you were born", "Your first dogs name"}));
		secret_ques.setBounds(711, 388, 314, 34);
		secret_ques.setUI(new BasicComboBoxUI());
		contentPane.add(secret_ques);
		
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
				String gender = GENDER.getText();
				String address = ADDRESS.getText();
				String aadhar = AADHAR_CARD.getText();
				String blood = (String) Blood_group.getSelectedItem();
				String Phone_num = Phone_Number.getText();
				String nominee = Nominee.getText();
				String Nominee_rel = nominee_rel.getText();
				String sec_que = (String) secret_ques.getSelectedItem();
				String answer = ans.getText();				
				
				
				
				if(smokeyes.isSelected()) {
					smoker=1;
				}
				else if(smokeno.isSelected()) {
					smoker=0;
				}
				
				if(smoker==1) {
					premium_monthly+=1000;
					
				}
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder name is required");
					
				}else if (dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Date of birth is required");
				}	
				else if (Phone_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Phone number is required");
				}
				else if (!Phone_num.matches(mobileNumberPattern)  || Phone_num.length() != 10) {
					JOptionPane.showMessageDialog(null, "Policy holder Phone number is invalid");
				}
				else if (gender.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Gender is required");

				}
				else if (address.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Address is required");

				}
				else if (aadhar.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder aadhar number is required");
				}
				else if (!aadhar.matches(mobileNumberPattern) || aadhar.length() != 12 ) {
					JOptionPane.showMessageDialog(null, "Policy holder aadhar is invalid");
				}
				else if(blood.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder blood group is required");

				}
			
					
				else {
					
					try {
						Connection connection = Connection_provider.getcon();
						PreparedStatement ps = connection.prepareStatement("insert into policy(Name, Type, aadhar_card_owner, email,aadhar_card_holder,policy_create_date) values (?,'life_insurance',?,?,?,?)");
						ps.setString(1, Customers_login.getUu_name());
						ps.setString(2, Customers_login.getAadhar_card());
						ps.setString(3, Customers_login.getEmail());
						ps.setString(4, aadhar);
						
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
						
						PreparedStatement ps_2 = connection.prepareStatement("insert into life_insurance(policy_id, Name, Type,Phone_num, premium_monthly, claim, Date_of_birth, Gender, aadhar_card_num_holder, blood_group, aadhar_card_owner,address,claim_status,nominee, nominee_relation, secret_ques, answer)   values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						
						ps_2.setInt(1, id);
						ps_2.setString(2, name);
						ps_2.setString(3, plan_type);
						ps_2.setString(4, Phone_num);
						ps_2.setInt(5, premium_monthly);
						ps_2.setInt(6, coverage);
						ps_2.setString(7, dob);
						ps_2.setString(8, gender);
						ps_2.setString(9, aadhar);
						ps_2.setString(10, blood);
						ps_2.setString(11, Customers_login.getAadhar_card());
						ps_2.setString(12, address);
						ps_2.setString(13, "Not claimed");
						ps_2.setString(14, nominee);
						ps_2.setString(15, Nominee_rel);
						ps_2.setString(16, sec_que);
						ps_2.setString(17, answer);
						
						
						ps_2.executeUpdate();
						
						setVisible(false);
						new Policy_holder_details().setVisible(true);
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,e2);
					}
					
					
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(491, 595, 121, 23);
		contentPane.add(btnNewButton);
		
		Phone_Number = new JTextField();
		Phone_Number.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Phone_Number.setOpaque(false);
		Phone_Number.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Phone_Number.setColumns(10);
		Phone_Number.setBounds(107, 277, 267, 41);
		contentPane.add(Phone_Number);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Apply_policy_customer().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1149, 22, 89, 23);
		contentPane.add(btnNewButton_1);
		
		Nominee = new JTextField();
		Nominee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nominee.setOpaque(false);
		Nominee.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Nominee.setColumns(10);
		Nominee.setBounds(711, 191, 314, 41);
		contentPane.add(Nominee);
		
		ans = new JTextField();
		ans.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ans.setOpaque(false);
		ans.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ans.setColumns(10);
		ans.setBounds(711, 485, 314, 41);
		contentPane.add(ans);
		
		nominee_rel = new JTextField();
		nominee_rel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nominee_rel.setOpaque(false);
		nominee_rel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nominee_rel.setColumns(10);
		nominee_rel.setBounds(711, 286, 314, 41);
		contentPane.add(nominee_rel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Policy_holder_details.class.getResource("/images/Life insurance apply.png")));
		lblNewLabel_4.setBounds(0, 0, 1283, 661);
		contentPane.add(lblNewLabel_4);
		
//		try {
//			
//			Connection connection = Connection_provider.getcon();
//			Statement st = connection.createStatement();
//			ResultSet rs = st.executeQuery("select *from policy ORDER BY policy_id DESC LIMIT 1;");
//			while(rs.next()) {
//				System.out.println(rs.getString("Name"));
//				System.out.println(rs.getString("aadhar_card_owner"));
//				System.out.println(rs.getString("policy_id"));
//			}
//			
//		} catch (Exception e2) {
//			// TODO: handle exception
//		}
//		

	}
	
	
	
}
