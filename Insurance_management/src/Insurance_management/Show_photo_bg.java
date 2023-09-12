package Insurance_management;

import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.Blob;

import database.Connection_provider;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Show_photo_bg extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField DOB;
	private JTextField AADHAR;
	private JTextField Gender;
	public  int existence=0;
	
	public static String aadharString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_photo_bg frame = new Show_photo_bg();
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
	public Show_photo_bg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1295, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(116, 237, 350, 350);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(879, 237, 350, 350);
		contentPane.add(lblNewLabel_1);
		
		Name = new JTextField();
		Name.setBounds(290, 68, 250, 30);
		contentPane.add(Name);
		Name.setColumns(10);
		
		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(290, 134, 250, 30);
		contentPane.add(DOB);
		
		AADHAR = new JTextField();
		AADHAR.setColumns(10);
		AADHAR.setBounds(979, 68, 250, 30);
		contentPane.add(AADHAR);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		Gender.setBounds(979, 134, 250, 30);
		contentPane.add(Gender);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(78, 68, 200, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date of birth");
		lblNewLabel_2_1.setBounds(78, 134, 200, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Aadhar Number");
		lblNewLabel_2_1_1.setBounds(748, 68, 200, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Gender");
		lblNewLabel_2_1_1_1.setBounds(748, 134, 200, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				existence=1;
				if(existence ==1) {
					setVisible(false);
					dispose();
				}
				
			}
		});
		btnNewButton_1.setBounds(1139, 21, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton.setBounds(598, 586, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		try {
			Connection connection = Connection_provider.getcon();
			PreparedStatement ps = connection.prepareStatement("select * from background_verification where Aadhar_card = ?");
			ps.setString(1, aadharString);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob imageBlob =  (Blob) rs.getBlob("passport_photo");
				String pathString = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\pass_img1.jpg";
				byte [] bytea = imageBlob.getBytes(1, (int)imageBlob.length());
				FileOutputStream fos = new FileOutputStream(pathString);
				fos.write(bytea);
				ImageIcon icon = new ImageIcon(bytea);
				lblNewLabel.setIcon(icon);
				
				Blob imageBlob2 = (Blob) rs.getBlob("aadhar_photo");
				String pathString_1 = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\aadh_img1.jpg";
				byte [] bytea_1 = imageBlob2.getBytes(1, (int)imageBlob2.length());
				FileOutputStream fos_1 = new FileOutputStream(pathString_1);
				fos.write(bytea_1);
				ImageIcon icon_1 = new ImageIcon(bytea_1);
				lblNewLabel_1.setIcon(icon_1);
				
				Name.setText(rs.getString("Name"));
				DOB.setText(rs.getString("dob"));
				Gender.setText(rs.getString("gender"));
				AADHAR.setText(rs.getString("Aadhar_card"));

			}
			connection.close();
					 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
