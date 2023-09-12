package Cutomers;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Insurance_management.LoginPage;
import Insurance_management.profile_non_admin;
import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;

public class Customer_dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Name;
	private JTextField Address;
	private JTextField Dob;
	private JTextField Mob_num;
	private JTextField Gender;
	private JTextField Email;
	private JTextField Occupation;
	
	int disp_count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_dashboard frame = new Customer_dashboard();
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
	public Customer_dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 691);
		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
		insets.top = -1;
		UIManager.put("TabbedPane.contentBorderInsets", insets);
		UIManager.put("TabbedPane.contentOpaque", false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(302, -24, 981, 667);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:-");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(203, 196, 150, 35);
		panel.add(lblNewLabel_1);
		
		Name = new JTextField();
		Name.setForeground(Color.RED);
		Name.setEditable(false);
		Name.setColumns(10);
		Name.setBounds(417, 204, 250, 22);
		panel.add(Name);
		
		JLabel lblNewLabel_4_1 = new JLabel("address");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(203, 257, 150, 35);
		panel.add(lblNewLabel_4_1);
		
		Address = new JTextField();
		Address.setForeground(Color.RED);
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBounds(417, 265, 250, 22);
		panel.add(Address);
		
		JLabel lblNewLabel_2 = new JLabel("DOB -- dd/mm/yyyy");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(203, 324, 150, 35);
		panel.add(lblNewLabel_2);
		
		
		
		Dob = new JTextField();
		Dob.setForeground(Color.RED);
		Dob.setEditable(false);
		Dob.setColumns(10);
		Dob.setBounds(417, 332, 250, 22);
		panel.add(Dob);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(203, 389, 150, 35);
		panel.add(lblNewLabel_3);
		
		Mob_num = new JTextField();
		Mob_num.setForeground(Color.RED);
		Mob_num.setEditable(false);
		Mob_num.setColumns(10);
		Mob_num.setBounds(417, 397, 250, 22);
		panel.add(Mob_num);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(203, 449, 150, 35);
		panel.add(lblNewLabel_5);
		
		Gender = new JTextField();
		Gender.setForeground(Color.RED);
		Gender.setEditable(false);
		Gender.setColumns(10);
		Gender.setBounds(417, 457, 250, 22);
		panel.add(Gender);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Email");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(203, 495, 150, 35);
		panel.add(lblNewLabel_4_1_1);
		
		
		
		Email = new JTextField();
		Email.setForeground(Color.RED);
		Email.setEditable(false);
		Email.setColumns(10);
		Email.setBounds(417, 503, 250, 22);
		panel.add(Email);
		
		JLabel lblNewLabel_4 = new JLabel("occupation");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(203, 550, 150, 35);
		panel.add(lblNewLabel_4);
		
		Occupation = new JTextField();
		Occupation.setForeground(Color.RED);
		Occupation.setEditable(false);
		Occupation.setColumns(10);
		Occupation.setBounds(417, 558, 250, 22);
		panel.add(Occupation);
		
		
	
		lblNewLabel_1.setVisible(false);
		Name.setVisible(false);
		lblNewLabel_4_1.setVisible(false);
		Address.setVisible(false);
		lblNewLabel_2.setVisible(false);
		Dob.setVisible(false);
		lblNewLabel_3.setVisible(false);
		Mob_num.setVisible(false);
		lblNewLabel_5.setVisible(false);
		Gender.setVisible(false);
		lblNewLabel_4_1_1.setVisible(false);
		Email.setVisible(false);
		lblNewLabel_4.setVisible(false);
		Occupation.setVisible(false);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 159, 867, 398);
		panel_1.add(scrollPane);
		
		table = new JTable(){
			  @Override
			    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			      Component component = super.prepareRenderer(renderer, row, column);
			      int rendererWidth = component.getPreferredSize().width;
			      TableColumn tableColumn = getColumnModel().getColumn(column);
			      tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			      return component;
			    }
			  };
		table.setForeground(new Color(255, 255, 255));
			 	  
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Policy id","Name", "Insurance", "Policy-Type", "Phone_num", "premium monthly", "claim", "policy holder aadhar card", "DOB/Registration Number"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setMinWidth(220);
		
		
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		scrollPane.setOpaque(false);
		
		JButton btnNewButton = new JButton("Cancel Policy");
		btnNewButton.setFocusable(false);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				  
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String pol_id = (String) model.getValueAt(index, 0);
				Integer pol_id_2 = Integer.parseInt(pol_id);
				try {
					Connection connection = Connection_provider.getcon();
					PreparedStatement get_date = connection.prepareStatement("select policy_create_date from policy where policy_id=?");
					get_date.setString(1, pol_id);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				  String policy_create ="11-11-2023";
				  String poloicy_end = "11-01-2023";
				  java.util.Date date1;
				  java.util.Date date2;
				try {
					date1 =  dFormat.parse(policy_create);
					date2=  dFormat.parse(poloicy_end);
					
					LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1) );
					System.out.println(localDate);
					LocalDate ldate2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date2));
					System.out.println(ldate2);
					long months = ChronoUnit.MONTHS.between(ldate2, localDate);
					System.out.println(months);
					
					if(months>9) {
						System.out.println("false");
					}
					else {
						System.out.println("true");
					}
					
				} catch (ParseException e7) {
					// TODO Auto-generated catch block
					e7.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(426, 589, 118, 23);
		panel_1.add(btnNewButton);
		scrollPane.getViewport().setOpaque(false);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				

				Customers_login.setCust_password("");
				Customers_login.setEmail("");
				Customers_login.setAadhar_card("");
				Customers_login.setUu_name("");
				Customers_login.setSecret_ques("");
				new Customers_login().setVisible(true);
				 
				dispose();
				
			}
		});
		btnNewButton_5.setBounds(47, 568, 200, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setBorderPainted(false);
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				disp_count = disp_count+1;
				if(disp_count%2==1) {
					lblNewLabel_1.setVisible(true);
					Name.setVisible(true);
					lblNewLabel_4_1.setVisible(true);
					Address.setVisible(true);
					lblNewLabel_2.setVisible(true);
					Dob.setVisible(true);
					lblNewLabel_3.setVisible(true);
					Mob_num.setVisible(true);
					lblNewLabel_5.setVisible(true);
					Gender.setVisible(true);
					lblNewLabel_4_1_1.setVisible(true);
					Email.setVisible(true);
					lblNewLabel_4.setVisible(true);
					Occupation.setVisible(true);	
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
				} catch (Exception e7) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e);
				}
			}
			else {
				lblNewLabel_1.setVisible(false);
				Name.setVisible(false);
				lblNewLabel_4_1.setVisible(false);
				Address.setVisible(false);
				lblNewLabel_2.setVisible(false);
				Dob.setVisible(false);
				lblNewLabel_3.setVisible(false);
				Mob_num.setVisible(false);
				lblNewLabel_5.setVisible(false);
				Gender.setVisible(false);
				lblNewLabel_4_1_1.setVisible(false);
				Email.setVisible(false);
				lblNewLabel_4.setVisible(false);
				Occupation.setVisible(false);
				
			}


				
				
				
				
//				setVisible(false);
//				new Customers_profile().setVisible(true);
//				
//				dispose();
		
			}
		});
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBounds(47, 443, 215, 50);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("");
		btnNewButton_6_1.setBorderPainted(false);
		btnNewButton_6_1.setOpaque(false);
		btnNewButton_6_1.setContentAreaFilled(false);
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Apply_policy_customer().setVisible(true);
			}
		});
		btnNewButton_6_1.setFocusable(false);
		btnNewButton_6_1.setBounds(47, 372, 215, 50);
		contentPane.add(btnNewButton_6_1);
		
		JButton btnNewButton_5_1 = new JButton("");
		btnNewButton_5_1.setOpaque(false);
		btnNewButton_5_1.setContentAreaFilled(false);
		btnNewButton_5_1.setBorderPainted(false);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				
				
				try {
					DefaultTableModel dt = (DefaultTableModel) table.getModel();

					Connection connection = Connection_provider.getcon();
					PreparedStatement ps = connection.prepareStatement("select * \r\n"
							+ "from life_insurance\r\n"
							+ "where  exists(\r\n"
							+ " select * \r\n"
							+ " from policy \r\n"
							+ " where policy.policy_id = life_insurance.policy_id  and policy.aadhar_card_owner = ? \r\n"
							+ " );");
					
					ps.setString(1, Customers_login.getAadhar_card());
					ResultSet rs = ps.executeQuery();
		            
		            while(rs.next())

		            {

		            	dt.addRow(new Object[] { rs.getString("policy_id"),rs.getString(3),"Life Insurance" ,rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(10),rs.getString(8)});


		            }
		            
		            PreparedStatement ps_2 = connection.prepareStatement("select * \r\n"
		            		+ "from home_insurance\r\n"
		            		+ "where  exists(\r\n"
		            		+ " select * \r\n"
		            		+ " from policy \r\n"
		            		+ " where policy.policy_id = home_insurance.policy_id  and policy.aadhar_card_owner =  ? \r\n"
		            		+ " );\r\n"
		            		+ "");
		            ps_2.setString(1,Customers_login.getAadhar_card());
		            
		            ResultSet rs_2 = ps_2.executeQuery();
		            /// COntinue to display policy
		            while(rs_2.next())

		            {

		            	dt.addRow(new Object[] { rs_2.getString("policy_id"),rs_2.getString(3),"Home Insurance",rs_2.getString(5),rs_2.getString(6),rs_2.getString(7),rs_2.getString(8),rs_2.getString(10),rs_2.getString(9)});


		            }
		            
		            
		            PreparedStatement ps_3 = connection.prepareStatement("\r\n"
		            		+ "select * \r\n"
		            		+ "from Vechile_insurance\r\n"
		            		+ "where  exists(\r\n"
		            		+ " select * \r\n"
		            		+ " from policy \r\n"
		            		+ " where policy.policy_id = Vechile_insurance.policy_id  and  policy.aadhar_card_owner =  ? \r\n"
		            		+ " );\r\n"
		            		+ "");
		            ps_3.setString(1, Customers_login.getAadhar_card());
		            
		            ResultSet rs_3 = ps_3.executeQuery();
		            
		            while(rs_3.next())

		            {

		            	dt.addRow(new Object[] { rs_3.getString("policy_id"),rs_3.getString(3),"Vechile Insurance",rs_3.getString(5),rs_3.getString(6),rs_3.getString(7),rs_3.getString(8),rs_3.getString(11),rs_3.getString(10)});

		            						
		            }

		            
		            
		            connection.close();

				} catch (Exception e5) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e5);
				}
				
				
//				setVisible(false);
//				new Customer_display_policy().setVisible(true);
//				dispose();
			}
		});
		btnNewButton_5_1.setFocusable(false);
		btnNewButton_5_1.setBounds(47, 150, 200, 50);
		contentPane.add(btnNewButton_5_1);
		
		JButton btnNewButton_6_1_1 = new JButton("");
		btnNewButton_6_1_1.setOpaque(false);
		btnNewButton_6_1_1.setContentAreaFilled(false);
		btnNewButton_6_1_1.setBorderPainted(false);
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Customer_Claim_Insurance().setVisible(true);
				dispose();
			}
		});
		btnNewButton_6_1_1.setFocusable(false);
		btnNewButton_6_1_1.setBounds(47, 219, 200, 50);
		contentPane.add(btnNewButton_6_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Customer_dashboard.class.getResource("/images/Customer_dashboard.png")));
		lblNewLabel_6.setBounds(0, 0, 1283, 654);
		contentPane.add(lblNewLabel_6);
		
		
	}
}
