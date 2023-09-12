package Insurance_management;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import database.Connection_provider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Life_insurance_verify extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Life_insurance_verify frame = new Admin_Life_insurance_verify();
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
	public Admin_Life_insurance_verify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 690);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 63, 1223, 500);
		contentPane.add(scrollPane);
		
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
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"claim no", "Policy id", "policy plan", "Name", "Phone num", "claim", "DOB", "GENDER", "Cause of death", "Nominee" , "Nominee relationship" , "status"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Issue Claim");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String claim_no = model.getValueAt(index, 0).toString();
				Integer claim_no_table = Integer.parseInt(claim_no);
				String poli_id = model.getValueAt(index, 1).toString();
				String status = model.getValueAt(index, 11).toString();
				String claim = model.getValueAt(index, 5).toString();
				
				System.out.println(poli_id +" " +status + " " +claim );
				Connection connection = Connection_provider.getcon();
				if(status.equals("pending")) {
					String[] responses = {"Accept","Reject"};
					int a = JOptionPane.showOptionDialog
							(null, "Have you verified and Do you want to accept the claim", "status message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,responses ,0);
					if(a==0) {
						 JTextField claim_dis = new JTextField();
						 claim_dis.setText(claim);
						 JPasswordField passField = new JPasswordField();
						  String claim_conform = "Please enter the amount  to be paid";
					      String message = "Please enter your admin password";
					      String message_toPay = "Please enter the nominee Name and aadhar";
					      int result = JOptionPane.showOptionDialog(null, new Object[] {claim_conform,claim_dis,message, passField},"Pay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					      if(result==JOptionPane.OK_OPTION)
					      {
					    	  String claimtobePAid = claim_dis.getText();
					    	  Integer claim_curr =  Integer.parseInt(claimtobePAid);
					    	  String pass = new String(passField.getPassword());
					    	  if(pass.equals(LoginPage.getPassword())) {
					    	  	JTextField  nominee_to = new JTextField();
								JTextField aadhar = new JTextField(); 
								
								int result_1 = JOptionPane.showOptionDialog(null, new Object[] {message_toPay,nominee_to,aadhar},"Pay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
								if(result_1==JOptionPane.OK_OPTION) {
									String nomineeString= nominee_to.getText();
									String aadharString = aadhar.getText();
										try
							    		  { 									
											 PreparedStatement life_update = connection.prepareStatement("update life_insurance set claim_status = ? where policy_id = ?");
									    	 life_update.setString(1, "claimed");
									    	 life_update.setString(2, poli_id);
									    	 life_update.executeUpdate();									    	 
									    	 PreparedStatement cutomer_update = connection.prepareStatement("select * from customers where Aadhar_card = ?");
			  								 cutomer_update.setString(1, aadharString);
			  								 ResultSet cust  = cutomer_update.executeQuery();
			  								 while(cust.next()) {
			  									 int amt = cust.getInt("amount_paid");
			  									 String name_to_pay = cust.getString("Name");
			  									 int upt_amt = amt + claim_curr;
			  									 PreparedStatement fin_update = connection.prepareStatement("update customers set amount_paid=? where Aadhar_card =?");
			  									 fin_update.setInt(1, upt_amt);
			  									 fin_update.setString(2, aadharString);
			  									 fin_update.executeUpdate();
			  									 JOptionPane.showMessageDialog(null, "The amount of " + claim_curr+ " has been paid to "+ cust.getString("Name") );
			  									 	 
			  								 }
			  								 PreparedStatement delete_from = connection.prepareStatement("delete from  life_insurance_verify where life_id = ?");
			  								 delete_from.setInt(1, claim_no_table);
			  								 delete_from.executeUpdate();
			  								 dispose();
			  								 new Admin_Life_insurance_verify().setVisible(true);
			  								
									    	 
									    	 
										}
									 catch(Exception e1)
									{

									         JOptionPane.showMessageDialog(null, e1);

									}

									
									
									
								}
					      }
						
						
						
						
						
						
						
					}	
				}
					
				if(a==1) {
						try
						{ 

							  
							  PreparedStatement ps = connection.prepareStatement("update life_insurance_verify set status='rejected' where life_id=?");
							  ps.setInt(1, claim_no_table);;
							  ps.executeUpdate();
							  
							  JOptionPane.showMessageDialog(null, "Life insurance claim has been rejected");
							  
							  
							  
							  
							  setVisible(false);
							  
							  new Admin_Life_insurance_verify().setVisible(true);

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
							(null, "Do you want to accept a rejected claim?", "status message", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
					if(a==0) {
						
						  JPasswordField passField = new JPasswordField();
					      String message = "Please enter your admin password";
					      int result = JOptionPane.showOptionDialog(null, new Object[] {message, passField},"Payment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					      if (result == JOptionPane.OK_OPTION) {
					    	  String pass = new String(passField.getPassword());
					    	  if(pass.equals(LoginPage.getPassword())) {	
										 JTextField claim_dis = new JTextField();
										 claim_dis.setText(claim);
								
										  String claim_conform = "Please enter the amount  to be paid";
									      String message1 = "Please enter your admin password";
									      String message_toPay = "Please enter the nominee Name and aadhar";
									      int result_1 = JOptionPane.showOptionDialog(null, new Object[] {claim_conform,claim_dis},"Pay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
									      if(result_1==JOptionPane.OK_OPTION)
									      {
									    	  String claimtobePAid = claim_dis.getText();
									    	  Integer claim_curr =  Integer.parseInt(claimtobePAid);
									    	  String pass1 = new String(passField.getPassword());
									    	  if(pass1.equals(LoginPage.getPassword())) {
									    	  	JTextField  nominee_to = new JTextField();
												JTextField aadhar = new JTextField(); 
												
												int result_11 = JOptionPane.showOptionDialog(null, new Object[] {message_toPay,nominee_to,aadhar},"Pay", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
												if(result_11==JOptionPane.OK_OPTION) {
													String nomineeString= nominee_to.getText();
													String aadharString = aadhar.getText();
														try
											    		  { 									
															 PreparedStatement life_update = connection.prepareStatement("update life_insurance set claim_status = ? where policy_id = ?");
													    	 life_update.setString(1, "claimed");
													    	 life_update.setString(2, poli_id);
													    	 life_update.executeUpdate();									    	 
													    	 PreparedStatement cutomer_update = connection.prepareStatement("select * from customers where Aadhar_card = ?");
							  								 cutomer_update.setString(1, aadharString);
							  								 ResultSet cust  = cutomer_update.executeQuery();
							  								 while(cust.next()) {
							  									 int amt = cust.getInt("amount_paid");
							  									 String name_to_pay = cust.getString("Name");
							  									 int upt_amt = amt + claim_curr;
							  									 PreparedStatement fin_update = connection.prepareStatement("update customers set amount_paid=? where Aadhar_card =?");
							  									 fin_update.setInt(1, upt_amt);
							  									 fin_update.setString(2, aadharString);
							  									 fin_update.executeUpdate();
							  									 JOptionPane.showMessageDialog(null, "The amount of " + claim_curr+ " has been paid to "+ cust.getString("Name") );
							  									 	 
							  								 }
							  								 
							  								 
							  								 PreparedStatement delete_from = connection.prepareStatement("delete from  life_insurance_verify where life_id = ?");
							  								 delete_from.setInt(1, claim_no_table);
							  								 delete_from.executeUpdate();
							  								 
							  								 JOptionPane.showMessageDialog(null, "The amount of " + claim_curr+ " has been paid to "+ cust.getString("Name") );
							  								 
							  								 connection.close();
													    	 
													    	 
														}
													 catch(Exception e5)
													{

													        // JOptionPane.showMessageDialog(null, e5);

													}

													
													
													
												}
									      }
										
										
										
										
										
										
										
									
										  
	
										 

									
					    		  
					    		  
					    	  }
					          
					          
					      }
					}
				}

				

						 setVisible(false);
						 new Admin_Life_insurance_verify().setVisible(true);
						
				
			}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(603, 607, 108, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1151, 29, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		try {
			DefaultTableModel dt = (DefaultTableModel) table.getModel();

			Connection connection = Connection_provider.getcon();
			PreparedStatement ps = connection.prepareStatement("select * from life_insurance_verify");
			ResultSet rs = ps.executeQuery();
            
            while(rs.next())

            {

            	dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
            	

            }
		}
		catch (Exception e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(null, e);
		}

		
		
		
		
		
		
	}
}
