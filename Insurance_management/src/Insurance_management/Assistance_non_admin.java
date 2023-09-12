package Insurance_management;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import database.Connection_provider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Assistance_non_admin extends JFrame {

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
					Assistance_non_admin frame = new Assistance_non_admin();
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
	public Assistance_non_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 695);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 55, 1175, 565);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Gender", "Phone number"
			}
		));
		
		btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Non_Admin_Dashboard().setVisible(true);

			}
		});
		btnNewButton.setBounds(1160, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		try

        { 
            DefaultTableModel dt = (DefaultTableModel) table.getModel();

            Connection con = Connection_provider.getcon();

            PreparedStatement ps = con.prepareStatement("select * from customers where ref_username=?");
            
            ps.setString(1, LoginPage.getUsername());
			
            ResultSet rs = ps.executeQuery();

            while(rs.next())

            {

            dt.addRow(new Object[] { rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(7)});


            }
            con.close();

        }

        catch(Exception e1)

        {

            JOptionPane.showMessageDialog(null, e1);

        }

	
		
		
	}
}
