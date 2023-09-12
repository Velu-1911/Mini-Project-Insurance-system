package Insurance_management;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.Connection_provider;

import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_View_deleteAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private String usernameString = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_View_deleteAdmin frame = new Add_View_deleteAdmin();
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
	public Add_View_deleteAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblNewLabel.setBounds(516, 11, 242, 50);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 72, 1283, 15);
		contentPane.add(separator);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(46, 118, 1210, 444);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SNO", "User Role", "name", "date of birth", "mobile Number", "Username"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Delete User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String id = model.getValueAt(index, 0).toString();
				String username = model.getValueAt(index, 5).toString();
				if(username.equals(LoginPage.getUsername())) {
					JOptionPane.showMessageDialog(null, "You can't delete your own account");
				}
				else {
					int a = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected user","Select",JOptionPane.YES_NO_OPTION);
					if(a==0) {
						try {
							Connection connection = Connection_provider.getcon();
							PreparedStatement ps = connection.prepareStatement("Delete from employee where appuser_pk =?");
							ps.setString(1, id);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "User Successfully Deleted");
							setVisible(false);
							new Add_View_deleteAdmin().setVisible(true);
							connection.close();
							
							
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null,e2);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(608, 597, 139, 26);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Go back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(1126, 23, 89, 23);
		contentPane.add(btnNewButton_2);
		try
		{ 
		                        DefaultTableModel dt = (DefaultTableModel) table.getModel();

		                        Connection con = Connection_provider.getcon();

		                        Statement st = con.createStatement();

		                        ResultSet rs = st.executeQuery("select * from employee");

		                        while(rs.next())

		                        {

		                        dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});


		                        }
		                        
		                        con.close();

		  }
		 catch(Exception e1)
		{

		         JOptionPane.showMessageDialog(null, e1);

		}
		
	}
}
