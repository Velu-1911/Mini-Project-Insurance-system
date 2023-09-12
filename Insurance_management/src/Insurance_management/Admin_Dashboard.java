package Insurance_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Dashboard frame = new Admin_Dashboard();
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
	public Admin_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Admin_Dashboard = new JLabel("Admin Dashboard");
		Admin_Dashboard.setBounds(505, 35, 318, 58);
		Admin_Dashboard.setFont(new Font("Times New Roman", Font.BOLD, 35));
		Admin_Dashboard.setForeground(new Color(255, 255, 255));
		Admin_Dashboard.setForeground(Color.black);;
		contentPane.add(Admin_Dashboard);
		
		JButton btnNewButton = new JButton("Add Admin User");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new Add_admin().setVisible(true);
				JPasswordField pf = new JPasswordField();
				int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (okCxl == JOptionPane.OK_OPTION) {
				  String password = new String(pf.getPassword());
				  if(password.equals(LoginPage.getPassword())) {
						setVisible(false);
						new Add_admin().setVisible(true);
						dispose();
				  }
				}

			}
		});
		

		btnNewButton.setBounds(373, 176, 200, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Insurance Agent");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add_Non_admin().setVisible(true);
				dispose();
				
		
			}
		});
		btnNewButton_1.setBounds(799, 176, 200, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Background Verification");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Accept_reject_admin().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(373, 288, 200, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View all Customers");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin_policy_holders().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBounds(799, 288, 200, 50);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete User");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 dispose();
				 new Add_View_deleteAdmin().setVisible(true);;
			}
		});
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBounds(373, 536, 200, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				new LoginPage().setVisible(true);
				LoginPage.setPassword("");
				LoginPage.setUsername("");
				LoginPage.setU_name("");
				dispose();
				
			}
		});
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBounds(799, 536, 200, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View/Update profile");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				profile_non_admin.setProf_count(1);
				new profile_non_admin().setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_6.setBounds(373, 408, 200, 50);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Life Insurance Verification");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_Life_insurance_verify().setVisible(true);
				dispose();
			}
		});
		btnNewButton_6_1.setBounds(799, 408, 200, 50);
		contentPane.add(btnNewButton_6_1);
	}
}
