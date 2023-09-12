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
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import database.Connection_provider;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class home_insurance_policy_create extends JFrame {

	private JPanel contentPane;
	
	private JTextField NAME;
	private JTextField PHONE_NUM;
	private JTextField ADDRESS;
	
	public static Integer premium_monthly;
	public String mobileNumberPattern = "^[0-9]*$";
	public static Integer coverage;
	public static String plan_type;
	public static Boolean termBoolean=false;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_insurance_policy_create frame = new home_insurance_policy_create();
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
	public home_insurance_policy_create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 686);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSURANCE HOLDER DETAILS");
		lblNewLabel.setBounds(318, 11, 632, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 73, 1263, 2);
		contentPane.add(separator);
		
		NAME = new JTextField();
		NAME.setColumns(10);
		NAME.setBounds(568, 118, 250, 22);
		contentPane.add(NAME);
		
		JDateChooser Date_Dob = new JDateChooser();
		Date_Dob.setBounds(568, 176, 250, 20);
		contentPane.add(Date_Dob);
		
		PHONE_NUM = new JTextField();
		PHONE_NUM.setColumns(10);
		PHONE_NUM.setBounds(568, 247, 250, 22);
		contentPane.add(PHONE_NUM);
		
		ADDRESS = new JTextField();
		ADDRESS.setColumns(10);
		ADDRESS.setBounds(568, 315, 250, 22);
		contentPane.add(ADDRESS);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(373, 111, 150, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date of birth");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(373, 176, 150, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Phone_num");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(373, 240, 150, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("address");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(373, 308, 150, 35);
		contentPane.add(lblNewLabel_4_1);
		
		JCheckBox theft = new JCheckBox("Theft and burglary coverage");
		theft.setBounds(568, 379, 174, 23);
		contentPane.add(theft);
		
		JCheckBox natural = new JCheckBox("Natural calamities");
		natural.setBounds(568, 432, 174, 23);
		contentPane.add(natural);
		
		
		ButtonGroup G = new ButtonGroup();
		
		
		
		JButton btnNewButton = new JButton("Create Policy");
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
				String address = ADDRESS.getText();
				
				
				if(theft.isSelected()) {
					premium_monthly+=150;
				}
				if(natural.isSelected()) {
					premium_monthly+=200;
				}
				
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder name is required");
					
				}else if (dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Date of birth is required");
				}
				else if (address.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Address is required");

				}
				else if (phone_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Phone_num is required");
				}
				else if (!phone_num.matches(mobileNumberPattern)  || phone_num.length() !=10 ) {
					JOptionPane.showMessageDialog(null, "Policy holder Phone_num is invalid");
				}
				else if (address.equals("")) {
					JOptionPane.showMessageDialog(null, "Policy holder Adreess is required");
				}
				else {
					
					try {
						Connection connection = Connection_provider.getcon();
						PreparedStatement ps = connection.prepareStatement("insert into policy(Name, Type, aadhar_card_owner, email) values (?,'home_insurance',?,?)");
						ps.setString(1, Customers_login.getUu_name());
						ps.setString(2, Customers_login.getAadhar_card());
						ps.setString(3, Customers_login.getEmail());
						ps.executeUpdate();
						
					
						
						
						Statement st = connection.createStatement();
						ResultSet rs = st.executeQuery("select *from policy ORDER BY policy_id DESC LIMIT 1;");
						Integer id = null;
						while(rs.next()) {
							System.out.println(rs.getString("policy_id"));
							id=rs.getInt("policy_id"); 
						}
						
						PreparedStatement ps_2 = connection.prepareStatement("insert into home_insurance(policy_id, Name, Date_of_birth, Type, Phone_num, premium_monthly, claim, address, aadhar_card_owner,claim_left)   values (?,?,?,?,?,?,?,?,?,?)");
																									  
						ps_2.setInt(1, id);
						ps_2.setString(2, name);
						ps_2.setString(3, dob);
						ps_2.setString(4, plan_type);
						ps_2.setString(5, phone_num);
						ps_2.setInt(6, premium_monthly);
						ps_2.setInt(7, coverage);
						ps_2.setString(8, address);
						ps_2.setString(9, Customers_login.getAadhar_card());
						ps_2.setInt(10, coverage);
						ps_2.executeUpdate();;
						
						setVisible(false);
						new home_insurance_policy_create().setVisible(true);
						connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,e2);
					}
					
					
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(588, 567, 121, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Optional Coverage\r\n");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(373, 372, 150, 35);
		contentPane.add(lblNewLabel_4_1_1);
		
		JTextArea txtrSelectingTheseOptional = new JTextArea();
		txtrSelectingTheseOptional.setEditable(false);
		txtrSelectingTheseOptional.setOpaque(false);
		txtrSelectingTheseOptional.setText("Caution:-Selecting these \r\noptional coverage\r\nwould increase \r\nyour yearly premium\r\n");
		txtrSelectingTheseOptional.setBounds(373, 401, 150, 82);
		contentPane.add(txtrSelectingTheseOptional);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Apply_policy_customer().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1140, 25, 89, 23);
		contentPane.add(btnNewButton_1);
		
		

		
		
		
	}
}
