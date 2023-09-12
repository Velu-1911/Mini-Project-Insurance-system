package Cutomers;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import database.Connection_provider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_display_policy extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_display_policy frame = new Customer_display_policy();
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
	public Customer_display_policy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1294, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 55, 1162, 558);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Insurance", "Policy-Type", "Phone_num", "premium monthly", "claim", "policy holder aadhar card", "address/Registration number"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(22);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(15);
		table.getColumnModel().getColumn(6).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setMinWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(360);
		table.getColumnModel().getColumn(7).setMinWidth(350);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Customer_dashboard().setVisible(true);
			}
		});
		btnNewButton.setBounds(1136, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
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

            	dt.addRow(new Object[] { rs.getString(3),"Life Insurance" ,rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(10),rs.getString(8)});


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

            	dt.addRow(new Object[] { rs_2.getString(3),"Home Insurance",rs_2.getString(5),rs_2.getString(6),rs_2.getString(7),rs_2.getString(8),rs_2.getString(10),rs_2.getString(9)});


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

            	dt.addRow(new Object[] { rs_3.getString(3),"Vechile Insurance",rs_3.getString(5),rs_3.getString(6),rs_3.getString(7),rs_3.getString(8),rs_3.getString(11),rs_3.getString(10)});

            						
            }

            
            
            connection.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
