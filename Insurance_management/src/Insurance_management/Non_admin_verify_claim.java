package Insurance_management;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import Cutomers.Customers_login;
import database.Connection_provider;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Non_admin_verify_claim extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Non_admin_verify_claim frame = new Non_admin_verify_claim();
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
	public Non_admin_verify_claim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1293, 688);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 52, 1231, 519);
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
			  
			  
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"claim_no","Name", "aadhar_card", "Phone_number", "type_of_Insurance", "address", "Reason_to_claim", "Claim_requested", "policy_id"
			}
		));
		
		btnNewButton = new JButton("issue_claim");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String message = "Please enter ammount to approve.";
				  JTextField userField = new JTextField();
			      int result = JOptionPane.showOptionDialog(null, new Object[] {message, userField,},
			      "Claim", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			      if (result == JOptionPane.OK_OPTION) {
			    	  	int index = table.getSelectedRow();
						TableModel model = table.getModel();
						String pol_id = model.getValueAt(index, 8).toString();
						String claim_no = model.getValueAt(index,0).toString();
						Integer claim_noInteger = Integer.parseInt(claim_no);
						Integer pol_Integer = Integer.parseInt(pol_id);
						System.out.println(pol_id);
						String type = model.getValueAt(index, 4).toString();
						System.out.println(type);
						if(type.equals("Vehicle Insurance")) {
							try {
								Connection connection   = Connection_provider.getcon();
								PreparedStatement pStatement = connection.prepareStatement("select * from vechile_insurance where policy_id = ?");
								pStatement.setString(1, pol_id);
								ResultSet rSet = pStatement.executeQuery();

								while(rSet.next()) {
									int claim_lft = rSet.getInt("claim_left");
									String claim_currstr = userField.getText();
									System.out.println(claim_currstr);
	          						int claim_curr = Integer.parseInt(claim_currstr);
	          						int claim_now = claim_lft-claim_curr;
	          						PreparedStatement home_update = connection.prepareStatement("update vechile_insurance set claim_left = ? where policy_id = ?");
	          						home_update.setInt(1, claim_now);
	  								home_update.setString(2, pol_id);
	  								home_update.executeUpdate();
	  								
	  								////YOU ARE UPDATING CONTENT FROM HERE////////////////
	  								
	  								 String aadhar = rSet.getString("aadhar_card_owner");
	  								 PreparedStatement cutomer_update = connection.prepareStatement("select * from customers where Aadhar_card = ?");
	  								 cutomer_update.setString(1, aadhar);
	  								 ResultSet cust  = cutomer_update.executeQuery();
	  								 while(cust.next()) {
	  									 int amt = cust.getInt("amount_paid");
	  									 int upt_amt = amt + claim_curr;
	  									 PreparedStatement fin_update = connection.prepareStatement("update customers set amount_paid=? where Aadhar_card =?");
	  									 fin_update.setInt(1, upt_amt);
	  									 fin_update.setString(2, aadhar);
	  									 fin_update.executeUpdate();
	  									 JOptionPane.showMessageDialog(null,"The amount of " + claim_curr+ " has been paid to "+ cust.getString("Name"));
	  									
	  								 }
	  								 
	  								 PreparedStatement delete_from = connection.prepareStatement("delete from non_admin_verify where claim_no = ?");
	  								 delete_from.setInt(1, claim_noInteger);
	  								 delete_from.executeUpdate();
	  								 dispose();
	  								 new Non_admin_verify_claim().setVisible(true);
	  								 
								}
								
								
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, e);
							}
							
						}
						else if(type.equals("Home Insurance")) {
							try {
								Connection connection   = Connection_provider.getcon();
								PreparedStatement pStatement = connection.prepareStatement("select * from home_insurance where policy_id = ?");
								pStatement.setString(1, pol_id);
								ResultSet rSet = pStatement.executeQuery();
								while(rSet.next()) {
									int claim_lft = rSet.getInt("claim_left");
									String claim_currstr = userField.getText();
									System.out.println(claim_currstr);
	          						int claim_curr = Integer.parseInt(claim_currstr);
	          						int claim_now = claim_lft-claim_curr;
	          						PreparedStatement home_update = connection.prepareStatement("update home_insurance set claim_left = ? where policy_id = ?");
	          						home_update.setInt(1, claim_now);
	  								home_update.setString(2, pol_id);
	  								home_update.executeUpdate();
	  								
	  								 
	  								 String aadhar = rSet.getString("aadhar_card_owner");
	  								 PreparedStatement cutomer_update = connection.prepareStatement("select * from customers where Aadhar_card = ?");
	  								 
	  								 cutomer_update.setString(1, aadhar);
	  								 ResultSet cust  = cutomer_update.executeQuery();
	  								 while(cust.next()) {
	  									 int amt = cust.getInt("amount_paid");
	  									 String name_to_pay = cust.getString("Name");
	  									 int upt_amt = amt + claim_curr;
	  									 PreparedStatement fin_update = connection.prepareStatement("update customers set amount_paid=? where Aadhar_card =?");
	  									 fin_update.setInt(1, upt_amt);
	  									 fin_update.setString(2, aadhar);
	  									 fin_update.executeUpdate();
	  									 JOptionPane.showMessageDialog(null, "The amount of " + claim_curr+ " has been paid to "+ cust.getString("Name") );
	  									 	 
	  								 }
	  								 PreparedStatement delete_from = connection.prepareStatement("delete from non_admin_verify where claim_no = ?");
	  								 delete_from.setInt(1, claim_noInteger);
	  								 delete_from.executeUpdate();
	  								 dispose();
	  								 new Non_admin_verify_claim().setVisible(true);
	  								 
							  }	
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, e2);
							}
						}
			      }
				
				
				
			}
		});
		btnNewButton.setBounds(563, 600, 138, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1155, 18, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		try {
			DefaultTableModel dt = (DefaultTableModel) table.getModel();

			Connection connection = Connection_provider.getcon();
			PreparedStatement ps = connection.prepareStatement("select * from non_admin_verify");
			ResultSet rs = ps.executeQuery();
            
            while(rs.next())

            {

            	dt.addRow(new Object[] { rs.getString("claim_no"),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(9)});
            	

            }
		}
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
}
