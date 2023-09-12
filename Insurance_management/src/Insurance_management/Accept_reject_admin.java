package Insurance_management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.lang.ref.Reference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accept_reject_admin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accept_reject_admin frame = new Accept_reject_admin();
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
	public Accept_reject_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);
		
		
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCEPT/REJECT POLICY REQUEST");
		lblNewLabel.setBounds(293, 22, 663, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 1283, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 106, 1197, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					 "Name", "Date of birth", "Phone_number", "gender","occupation","reference","reference username","aadhar card NO","Status"
				}
			));
		
		JButton btnNewButton = new JButton("Verify Details\r\n");
		btnNewButton.setBounds(610, 598, 125, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String status = model.getValueAt(index, 8).toString();
				String phone_num = model.getValueAt(index, 2).toString();
				String aadhar = model.getValueAt(index, 7).toString();
				Show_photo_bg.aadharString=aadhar;
				new Show_photo_bg().setVisible(true);
				if(status.equals("pending")) {
					String[] responses = {"Accept","Reject"};
					int a = JOptionPane.showOptionDialog
							(null, "Do you want to accept or reject customer", "status message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
					if(a==0) {
						try
						{ 
							  DefaultTableModel dt = (DefaultTableModel) table.getModel();
	
							  Connection con = Connection_provider.getcon();
							  int amt_paid = 0 ;
							  
							  PreparedStatement ps2 = con.prepareStatement("INSERT INTO customers (Name, address, dob, gender, occupation, Phone_num, reference, ref_username,  email, sec_question,  blood_group , Aadhar_card, sec_question_ans) SELECT Name, address, dob, gender, occupation, Phone_num, reference, ref_username, email, sec_question, blood_group, Aadhar_card, sec_question_ans FROM background_verification WHERE Phone_num=?");
							  ps2.setString(1, phone_num);
							  ps2.executeUpdate();
							  PreparedStatement ps3 = con.prepareStatement("update customers set amount_paid=? where Phone_num =? ");
							  ps3.setInt(1, amt_paid);
							  ps3.setString(2, phone_num);
							  ps3.executeUpdate();
							  
	
							  PreparedStatement ps = con.prepareStatement("Delete from background_verification where Phone_num =?");
							  ps.setString(1,phone_num);
							  ps.executeUpdate();
							  
							  JOptionPane.showMessageDialog(null, "User has been accepted as a customer");
							  setVisible(false);
							  new Accept_reject_admin().setVisible(true);
							  con.close();

						  }
						 catch(Exception e1)
						{

						         JOptionPane.showMessageDialog(null, e1);

						}

						
						
					}
					if(a==1) {
						try
						{ 
							  DefaultTableModel dt = (DefaultTableModel) table.getModel();
	
							  Connection con = Connection_provider.getcon();
	
							  PreparedStatement ps = con.prepareStatement("update background_verification set status='rejected' where Phone_num=?");
							  ps.setString(1,phone_num);
							  ps.executeUpdate();
							  
							  JOptionPane.showMessageDialog(null, "User has been rejected as a customer");
							
							  setVisible(false);
							  new Accept_reject_admin().setVisible(true);
							  con.close();

						  }
						 catch(Exception e1)
						{

						         JOptionPane.showMessageDialog(null, e1);

						}

						
					}
				}
				
				if(status.equals("rejected")) {
					String[] responses = {"Override and accept","keep rejected"};
					int a = JOptionPane.showOptionDialog
							(null, "Do you want to accept a reject customer?", "status message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
					if(a==0) {
						
						  JPasswordField passField = new JPasswordField();
					      String message = "Please enter your admin password";
					      int result = JOptionPane.showOptionDialog(null, new Object[] {message, passField},"Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					      if (result == JOptionPane.OK_OPTION) {
					    	  String pass = new String(passField.getPassword());
					    	  if(pass.equals(LoginPage.getPassword())) {
									try
									{ 
										  DefaultTableModel dt = (DefaultTableModel) table.getModel();
				
										  Connection con = Connection_provider.getcon();
										  int amt_paid=0;
										 // PreparedStatement ps2 = con.prepareStatement("INSERT INTO customers (Name, address, dob, gender, occupation, Phone_num, reference, ref_username,sec_question,email) SELECT Name, address, dob, gender, occupation, Phone_num, reference, ref_username, email, sec_question FROM background_verification WHERE Phone_num=?");
										  PreparedStatement ps2 = con.prepareStatement("INSERT INTO customers (Name, address, dob, gender, occupation, Phone_num, reference, ref_username,  email, sec_question,  blood_group , Aadhar_card, sec_question_ans) SELECT Name, address, dob, gender, occupation, Phone_num, reference, ref_username, email, sec_question, blood_group, Aadhar_card, sec_question_ans FROM background_verification WHERE Phone_num=?");
										  ps2.setString(1, phone_num);
										  ps2.executeUpdate();
										  PreparedStatement ps3 = con.prepareStatement("update customers set amount_paid=? where Phone_num =? ");
										  ps3.setInt(1, amt_paid);
										  ps3.setString(2, phone_num);
										  ps3.executeUpdate();
										  
				
										  PreparedStatement ps = con.prepareStatement("Delete from background_verification where Phone_num =?");
										  ps.setString(1,phone_num);
										  ps.executeUpdate();
										  
										  JOptionPane.showMessageDialog(null, "User has been accepted as a customer");
										  setVisible(false);
										  new Accept_reject_admin().setVisible(true);
										  con.close();

									  }
									catch(Exception e1)
									{

									         JOptionPane.showMessageDialog(null, e1);

									}
					    		  
					    		  
					    	  }
					          
					          
					      }
					      
						
						


						
						
						
					}
			

					
				}
				
				
			}
		});
		btnNewButton.setFocusable(false);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1148, 31, 89, 23);
		contentPane.add(btnNewButton_1);
			
			
			try
			{ 
			                        DefaultTableModel dt = (DefaultTableModel) table.getModel();

			                        Connection con = Connection_provider.getcon();

			                        Statement st = con.createStatement();

			                        ResultSet rs = st.executeQuery("select * from background_verification");

			                        while(rs.next())

			                        {

			                        	dt.addRow(new Object[] { rs.getString(1),rs.getString(3),rs.getString(6),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(8),rs.getString(13) ,rs.getString(9)});


			                        }
			                        
			                        con.close();

			  }
			 catch(Exception e1)
			{

			         JOptionPane.showMessageDialog(null, e1);

			}
		}
	
		
	
}

