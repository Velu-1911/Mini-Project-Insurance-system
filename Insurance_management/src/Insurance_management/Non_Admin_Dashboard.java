package Insurance_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Non_Admin_Dashboard extends JFrame {
	int check_member=0;
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Non_Admin_Dashboard frame = new Non_Admin_Dashboard();
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
	public Non_Admin_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1365, 698);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSURANCE AGENT DASHBOARD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(353, 21, 624, 47);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 97, 1283, 13);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Provide assistance");
		btnNewButton.setBounds(819, 162, 200, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Assistance_non_admin().setVisible(true);;
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("You are also an customer thank you.");
		lblNewLabel_1.setBounds(69, 40, 258, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Add Non Admin");
		
		btnNewButton_1.setBounds(302, 162, 200, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add customer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Non_admin_add_customer().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(302, 280, 200, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
				LoginPage.setPassword("");
				LoginPage.setUsername("");
				LoginPage.setU_name("");
			}
		});
		btnNewButton_3.setBounds(819, 430, 200, 35);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Profile");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				profile_non_admin.setProf_count(2);
				new profile_non_admin().setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton_4.setBounds(819, 280, 200, 35);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2_1 = new JButton("Verify claim");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Non_admin_verify_claim().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(302, 436, 200, 35);
		contentPane.add(btnNewButton_2_1);
		lblNewLabel_1.setVisible(false);
		
		
		
		
		try {
			Connection connection = Connection_provider.getcon();
			PreparedStatement ps = connection.prepareStatement("Select username from employee inner join customers on employee.name=customers.name and employee.mobileNumber = customers.Phone_num");
			ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	
            	if(rs.getString("username").equals(LoginPage.getUsername())) {

            		System.out.println("Thank you");
            		lblNewLabel_1.setVisible(true);
            		
            	}

            }
			
			connection.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e2);
		}
	}
}
