package Cutomers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Apply_policy_customer extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apply_policy_customer frame = new Apply_policy_customer();
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
	public Apply_policy_customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 689);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		

		Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
		insets.top = -1;
		UIManager.put("TabbedPane.contentBorderInsets", insets);
		UIManager.put("TabbedPane.contentOpaque", false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setBounds(296, -28, 986, 680);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTextArea txtrPremiumStartingFrom = new JTextArea();
		txtrPremiumStartingFrom.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom.setWrapStyleWord(true);
		txtrPremiumStartingFrom.setEditable(false);
		txtrPremiumStartingFrom.setText("Premium starting from 1545 -2500 per month depending on smoking and drinking habits\r\nInclusive of GST\r\nCoverage Upto 75 lackhs");
		txtrPremiumStartingFrom.setBounds(53, 183, 669, 85);
		panel_3.add(txtrPremiumStartingFrom);
		
		JTextArea txtrPremiumStartingFrom_2 = new JTextArea();
		txtrPremiumStartingFrom_2.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_2.setEditable(false);
		txtrPremiumStartingFrom_2.setWrapStyleWord(true);
		txtrPremiumStartingFrom_2.setText("Premium starting from 1800 -2800 per month depending on smoking and drinking habits\r\nInclusive of GST\r\nCoverage Upto 1.5 crores.");
		txtrPremiumStartingFrom_2.setBounds(53, 310, 669, 85);
		panel_3.add(txtrPremiumStartingFrom_2);
		
		JTextArea txtrPremiumStartingFrom_1_1 = new JTextArea();
		txtrPremiumStartingFrom_1_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_1_1.setEditable(false);
		txtrPremiumStartingFrom_1_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_1_1.setText("Premium starting from 2000 -3000 per month depending on smoking and drinking habits\r\nInclusive of GST\r\nCoverage Upto 2 crores");
		txtrPremiumStartingFrom_1_1.setBounds(53, 448, 669, 85);
		panel_3.add(txtrPremiumStartingFrom_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Basic Plan", "Premium Plan", "Premium Plus Plan"}));
		comboBox.setBounds(174, 576, 177, 25);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Basic plan");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 145, 210, 25);
		panel_3.add(lblNewLabel);
		
		JLabel lblPremiumPlan = new JLabel("Premium Plan");
		lblPremiumPlan.setForeground(new Color(255, 0, 0));
		lblPremiumPlan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlan.setBounds(53, 279, 210, 25);
		panel_3.add(lblPremiumPlan);
		
		JLabel lblPremiumPlusPlan = new JLabel("Premium Plus Plan");
		lblPremiumPlusPlan.setForeground(new Color(255, 0, 0));
		lblPremiumPlusPlan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlusPlan.setBounds(53, 412, 210, 25);
		panel_3.add(lblPremiumPlusPlan);
		
		JButton btnNewButton_4 = new JButton("Apply");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Policy_holder_details().setVisible(true);
				String type = (String) comboBox.getSelectedItem();
				
				if(type.equals("Basic Plan")) {
					Policy_holder_details.premium_monthly=1500;
					Policy_holder_details.coverage = 7500000;
					Policy_holder_details.plan_type = "Basic Plan" ;
					
				}else if(type.equals("Premium Plan")) {
					Policy_holder_details.premium_monthly=1800;
					Policy_holder_details.coverage = 15000000;
					Policy_holder_details.plan_type = "Premium Plan" ;
				}
				else if (type.equals("Premium Plus Plan")) {
					Policy_holder_details.premium_monthly=2500;
					Policy_holder_details.coverage = 20000000;
					Policy_holder_details.plan_type = "Premium Plus Plan" ;
				}
				
				dispose();
				
				
			}
		});
		btnNewButton_4.setBounds(410, 576, 89, 23);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_4_3 = new JButton("T&C");
		btnNewButton_4_3.setFocusable(false);
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms_conditions_customer.page_detailString="Life Insurance";
				new Terms_conditions_customer().setVisible(true);
				
				
			}
		});
		btnNewButton_4_3.setBounds(521, 577, 100, 23);
		panel_3.add(btnNewButton_4_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Basic plan");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(48, 140, 80, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		
		JTextArea txtrPremiumStartingFrom_1 = new JTextArea();
		txtrPremiumStartingFrom_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_1.setText("Premium starting from 600 - 950 per year depending on options selected\r\nInclusive of GST\r\nCoverage Upto 7 lacks for contents inside house.\r\nStructure Coverage Upto 35 lacks.");
		txtrPremiumStartingFrom_1.setEditable(false);
		txtrPremiumStartingFrom_1.setBounds(48, 171, 674, 85);
		panel_1.add(txtrPremiumStartingFrom_1);
		
		JTextArea txtrPremiumStartingFrom_3_1 = new JTextArea();
		txtrPremiumStartingFrom_3_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_3_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_3_1.setText("Premium starting from 900 - 1400 per year depending on options selected\r\nInclusive of GST\r\nCoverage Upto 9 lacks for contents inside house.\r\nStructure Coverage Upto 42 lacks.");
		txtrPremiumStartingFrom_3_1.setEditable(false);
		txtrPremiumStartingFrom_3_1.setBounds(48, 326, 674, 85);
		panel_1.add(txtrPremiumStartingFrom_3_1);
		
		JTextArea txtrPremiumStartingFrom_3_1_1 = new JTextArea();
		txtrPremiumStartingFrom_3_1_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_3_1_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_3_1_1.setText("Premium starting from 1200 - 1500 per year depending on options selected\r\nInclusive of GST\r\nCoverage Upto 10 lacks for contents inside house.\r\nStructure Coverage Upto 55 lacks.");
		txtrPremiumStartingFrom_3_1_1.setEditable(false);
		txtrPremiumStartingFrom_3_1_1.setBounds(48, 458, 674, 85);
		panel_1.add(txtrPremiumStartingFrom_3_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Basic Plan", "Premium Plan", "Premium Plus Plan"}));
		comboBox_1.setBounds(154, 594, 177, 25);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton_4_1 = new JButton("Apply");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home_insurance_policy_create().setVisible(true);;
				String type = (String) comboBox_1.getSelectedItem();
				
				if(type.equals("Basic Plan")) {
					home_insurance_policy_create.premium_monthly =600;
					home_insurance_policy_create.coverage = 4200000;
					home_insurance_policy_create.plan_type = "Basic Plan" ;
					
				}else if(type.equals("Premium Plan")) {
					home_insurance_policy_create.premium_monthly=900;
					home_insurance_policy_create.coverage = 5100000;
					home_insurance_policy_create.plan_type = "Premium Plan" ;
				}
				else if (type.equals("Premium Plus Plan")) {
					home_insurance_policy_create.premium_monthly=1200;
					home_insurance_policy_create.coverage = 6500000;
					home_insurance_policy_create.plan_type = "Premium Plus Plan" ;
				}
				
				dispose();
				
				
			}
		});
		btnNewButton_4_1.setBounds(380, 595, 89, 23);
		panel_1.add(btnNewButton_4_1);
		
		JLabel lblPremiumPlan_1 = new JLabel("Premium Plan");
		lblPremiumPlan_1.setForeground(new Color(255, 0, 0));
		lblPremiumPlan_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlan_1.setBounds(48, 285, 210, 25);
		panel_1.add(lblPremiumPlan_1);
		
		JLabel lblPremiumPlusPlan_1 = new JLabel("Premium Plus Plan");
		lblPremiumPlusPlan_1.setForeground(new Color(255, 0, 0));
		lblPremiumPlusPlan_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlusPlan_1.setBounds(48, 422, 210, 25);
		panel_1.add(lblPremiumPlusPlan_1);
		
		JButton btnNewButton_4_3_1 = new JButton("T&C");
		btnNewButton_4_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms_conditions_customer.page_detailString="Home Insurance";
				new Terms_conditions_customer().setVisible(true);
				
			}
		});
		btnNewButton_4_3_1.setFocusable(false);
		btnNewButton_4_3_1.setBounds(479, 595, 100, 23);
		panel_1.add(btnNewButton_4_3_1);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Basic plan");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(63, 144, 210, 25);
		panel.add(lblNewLabel_2);
		
		JTextArea txtrPremiumStartingFrom_4 = new JTextArea();
		txtrPremiumStartingFrom_4.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_4.setWrapStyleWord(true);
		txtrPremiumStartingFrom_4.setText("Premium starting from 1000 - 1600 per month \r\nInclusive of GST\r\nAccident coverage upto 9 lakchs\r\nOptional theft and riot protection is also provided.");
		txtrPremiumStartingFrom_4.setEditable(false);
		txtrPremiumStartingFrom_4.setBounds(63, 183, 669, 85);
		panel.add(txtrPremiumStartingFrom_4);
		
		JLabel lblPremiumPlan_2 = new JLabel("Premium Plan");
		lblPremiumPlan_2.setForeground(new Color(255, 0, 0));
		lblPremiumPlan_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlan_2.setBounds(63, 279, 210, 25);
		panel.add(lblPremiumPlan_2);
		
		JTextArea txtrPremiumStartingFrom_2_1 = new JTextArea();
		txtrPremiumStartingFrom_2_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_2_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_2_1.setText("Premium starting from 1500 - 2100 per month \r\nInclusive of GST\r\nAccident coverage upto 15 lakchs\r\nOptional theft and riot protection is also provided.");
		txtrPremiumStartingFrom_2_1.setEditable(false);
		txtrPremiumStartingFrom_2_1.setBounds(63, 315, 669, 85);
		panel.add(txtrPremiumStartingFrom_2_1);
		
		JLabel lblPremiumPlusPlan_2 = new JLabel("Premium Plus Plan");
		lblPremiumPlusPlan_2.setForeground(new Color(255, 0, 0));
		lblPremiumPlusPlan_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremiumPlusPlan_2.setBounds(63, 420, 210, 25);
		panel.add(lblPremiumPlusPlan_2);
		
		JTextArea txtrPremiumStartingFrom_1_1_1 = new JTextArea();
		txtrPremiumStartingFrom_1_1_1.setBackground(new Color(255, 255, 0));
		txtrPremiumStartingFrom_1_1_1.setWrapStyleWord(true);
		txtrPremiumStartingFrom_1_1_1.setText("Premium starting from 1900 - 2500 per month \r\nInclusive of GST\r\nAccident coverage upto 25 lakchs\r\nOptional theft and riot protection is also provided.");
		txtrPremiumStartingFrom_1_1_1.setEditable(false);
		txtrPremiumStartingFrom_1_1_1.setBounds(63, 460, 669, 85);
		panel.add(txtrPremiumStartingFrom_1_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Basic Plan", "Premium Plan", "Premium Plus Plan"}));
		comboBox_2.setBounds(201, 582, 177, 25);
		panel.add(comboBox_2);
		
		JButton btnNewButton_4_2 = new JButton("Apply");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Vechile_insurance_registration().setVisible(true);;
				String type = (String) comboBox_2.getSelectedItem();
				
				if(type.equals("Basic Plan")) {
					Vechile_insurance_registration.premium_monthly =1000;
					Vechile_insurance_registration.coverage = 900000;
					Vechile_insurance_registration.plan_type = "Basic Plan" ;
					
				}else if(type.equals("Premium Plan")) {
					Vechile_insurance_registration.premium_monthly=1500;
					Vechile_insurance_registration.coverage = 1500000;
					Vechile_insurance_registration.plan_type = "Premium Plan" ;
				}
				else if (type.equals("Premium Plus Plan")) {
					Vechile_insurance_registration.premium_monthly=1200;
					Vechile_insurance_registration.coverage = 2500000;
					Vechile_insurance_registration.plan_type = "Premium Plus Plan" ;
				}
				
				dispose();
				
			}
		});
		btnNewButton_4_2.setBounds(437, 582, 89, 23);
		panel.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3_1_1 = new JButton("T&C");
		btnNewButton_4_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Terms_conditions_customer.page_detailString="Vehicle Insurance";
				new Terms_conditions_customer().setVisible(true);
				
			}
		});
		btnNewButton_4_3_1_1.setFocusable(false);
		btnNewButton_4_3_1_1.setBounds(542, 583, 100, 23);
		panel.add(btnNewButton_4_3_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(42, 145, 175, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		
		btnNewButton_1.setBounds(42, 258, 192, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setOpaque(false);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setBounds(42, 388, 213, 53);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Customer_dashboard().setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(42, 566, 129, 35);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Apply_policy_customer.class.getResource("/images/DISPLAY ALL POLICIES (5).png")));
		lblNewLabel_3.setBounds(0, 0, 1282, 652);
		contentPane.add(lblNewLabel_3);
	}
}
