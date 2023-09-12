package Cutomers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.Blob;

import Insurance_management.LoginPage;
import database.Connection_provider;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Customers_profile extends JFrame {

	private JPanel contentPane;
	private JTextField Address;
	private JTextField Dob;
	private JTextField Mob_num;
	private JTextField Gender;
	private JTextField Email;
	private JTextField Occupation;
	private JTextField Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers_profile frame = new Customers_profile();
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
	public Customers_profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 688);
		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Customer_dashboard().setVisible(true);	
				
				dispose();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(1151, 35, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 1261, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("CUSTOMERS PROFILE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(413, 4, 546, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(388, 102, 150, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("address");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(388, 158, 150, 35);
		contentPane.add(lblNewLabel_4_1);
		
		Address = new JTextField();
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBounds(602, 166, 250, 22);
		contentPane.add(Address);
		
		JLabel lblNewLabel_2 = new JLabel("DOB -- dd/mm/yyyy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(388, 237, 150, 35);
		contentPane.add(lblNewLabel_2);
		
		Dob = new JTextField();
		Dob.setEditable(false);
		Dob.setColumns(10);
		Dob.setBounds(602, 245, 250, 22);
		contentPane.add(Dob);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(388, 328, 150, 35);
		contentPane.add(lblNewLabel_3);
		
		Mob_num = new JTextField();
		Mob_num.setEditable(false);
		Mob_num.setColumns(10);
		Mob_num.setBounds(602, 336, 250, 22);
		contentPane.add(Mob_num);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(388, 401, 150, 35);
		contentPane.add(lblNewLabel_5);
		
		Gender = new JTextField();
		Gender.setEditable(false);
		Gender.setColumns(10);
		Gender.setBounds(602, 409, 250, 22);
		contentPane.add(Gender);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Email");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(388, 480, 150, 35);
		contentPane.add(lblNewLabel_4_1_1);
		
		Email = new JTextField();
		Email.setEditable(false);
		Email.setColumns(10);
		Email.setBounds(602, 488, 250, 22);
		contentPane.add(Email);
		
		JLabel lblNewLabel_4 = new JLabel("occupation");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(388, 545, 150, 35);
		contentPane.add(lblNewLabel_4);
		
		Occupation = new JTextField();
		Occupation.setEditable(false);
		Occupation.setColumns(10);
		Occupation.setBounds(602, 553, 250, 22);
		contentPane.add(Occupation);
		
		Name = new JTextField();
		Name.setEditable(false);
		Name.setColumns(10);
		Name.setBounds(602, 110, 250, 22);
		contentPane.add(Name);
		
		try {
			 Connection connection = Connection_provider.getcon();
			 PreparedStatement ps = connection.prepareStatement("select * from customers where email = ?");
			 ps.setString(1, Customers_login.getEmail());
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Name.setText(rs.getString("Name"));
			     Address.setText(rs.getString("address"));
			     Dob.setText(rs.getString("dob"));
			     Mob_num.setText(rs.getString("Phone_num"));
			     Gender.setText(rs.getString("gender"));
			     Email.setText(rs.getString("email"));
			     Occupation.setText(rs.getString("occupation"));
			     	 
			 } 
	
			 connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		}
}
