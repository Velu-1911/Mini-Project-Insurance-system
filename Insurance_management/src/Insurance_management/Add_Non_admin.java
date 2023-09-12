package Insurance_management;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.Connection_provider;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Add_Non_admin extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Mobile_num;
	private JTextField textField_2;
	private JPasswordField passwordField;
	public String mobileNumberPattern = "^[0-9]*$";
	public int checkUsername = 0;
	JLabel lblNewLabel_6;
	String pathString="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Non_admin frame = new Add_Non_admin();
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
	public Add_Non_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1411, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD NON  ADMIN USER");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblNewLabel.setBounds(493, 11, 431, 75);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 86, 1283, 19);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(432, 178, 150, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DOB -- dd/mm/yyyy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(432, 238, 150, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(432, 313, 150, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(432, 435, 150, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(432, 374, 150, 50);
		contentPane.add(lblNewLabel_5);
		
		Name = new JTextField();
		Name.setBounds(707, 178, 150, 22);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Mobile_num = new JTextField();
		Mobile_num.setBounds(707, 321, 150, 22);
		contentPane.add(Mobile_num);
		Mobile_num.setColumns(10);
		

		JLabel Photo_lbl = new JLabel("Upload profile photo");
		Photo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		Photo_lbl.setBounds(71, 125, 150, 216);
		contentPane.add(Photo_lbl);
		
		JButton Upload_btn = new JButton("Upload");
		Upload_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
//				FileNameExtensionFilter fileNameExtensionFilter=new FileNameExtensionFilter("png", "jpg","jpeg");
//				chooser.addChoosableFileFilter(fileNameExtensionFilter);
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				pathString = file.getAbsolutePath();
		
				try {
					BufferedImage bImage = ImageIO.read(new File(pathString));
					Image img = bImage.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
					
					BufferedImage bufferedImageResult = new BufferedImage(
					        200,
					        200,
					        bImage.getType()
					);
					
					Graphics2D g2d = bufferedImageResult.createGraphics();
					g2d.drawImage(
					        bImage, 
					        0, 
					        0, 
					        200, 
					        200, 
					        null
					);
					g2d.dispose();
					String formatName = "C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img.jpg".substring(
							"C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img.jpg".lastIndexOf(".") + 1
					);
					
					ImageIO.write(
					        bufferedImageResult, 
					        formatName, 
					        new File("C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img.jpg")
					);
					pathString="C:\\Users\\pethachi.pr\\Desktop\\ImageforDisplay\\img.jpg";
					
					
					
					ImageIcon icon = new ImageIcon(img);
					Photo_lbl.setIcon(icon);
					Photo_lbl.setText("");
	
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		Upload_btn.setBounds(85, 413, 89, 23);
		contentPane.add(Upload_btn);

		JDateChooser DOB_chooser = new JDateChooser();
		DOB_chooser.setBounds(707, 250, 150, 20);
		contentPane.add(DOB_chooser);
		
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String username = textField_2.getText();
				if(!username.equals("")) {
					lblNewLabel_6.setVisible(true);
					lblNewLabel_6.setText("available");
					checkUsername = 0;
					try {
						Connection connection = Connection_provider.getcon();
						Statement statement = connection.createStatement();
						ResultSet rSet = statement.executeQuery("select * from employee where username='"+username+"' ");
						while(rSet.next()) {
							checkUsername=1;
							lblNewLabel_6.setVisible(true);
							lblNewLabel_6.setText(" not available");
							
							
						}
					connection.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e);
					} 
					
					
				}
				else {
					lblNewLabel_6.setVisible(false);
				}
			}
		});
		textField_2.setBounds(707, 382, 150, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(707, 451, 150, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				String dob = "";
				String mob_num = Mobile_num.getText();
				String username = textField_2.getText();
				String password = passwordField.getText();
				SimpleDateFormat dFormat =new SimpleDateFormat("dd-MM-yyyy");
				Date date =  DOB_chooser.getDate();
				if( date != null) {
					dob = dFormat.format(DOB_chooser.getDate());
				}
				
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Name field is required");
				}
				else if(dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Date of birth is required");
				}
				else if (mob_num.equals("")) {
					JOptionPane.showMessageDialog(null, "Mobile num is required");
				}
				else if (!mob_num.matches(mobileNumberPattern) || mob_num.length() != 10) {
					JOptionPane.showMessageDialog(null, "mobile number is not valid");
				}
				else if (username.equals("")) {
					JOptionPane.showMessageDialog(null, "User name field is required");
					
				}
				else if (checkUsername==1) {
					JOptionPane.showMessageDialog(null, "Username is not available");
				}
				else if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "Password cannot be empty");
				}
				else {
					try {
						Connection connection = Connection_provider.getcon();
						PreparedStatement ps = connection.prepareStatement("insert into employee(UserRole,name,dob,mobileNumber,username,password,salary,photoooo) values ('Non-Admin',?,?,?,?,?,10000,?)");
						ps.setString(1,name );
						ps.setString(2,dob );
						ps.setString(3, mob_num);
						ps.setString(4, username);
						ps.setString(5, password);
						InputStream is = null;
						try {
							System.out.println(pathString);
							is = new FileInputStream(new File(pathString));
						} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ps.setBlob(6, is);	
						ps.executeUpdate();
						setVisible(false);
						new Add_Non_admin().setVisible(true);
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					} 
					
				}
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(584, 550, 130, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(916, 387, 70, 25);
//		lblNewLabel_6.setVisible(false);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1132, 35, 89, 23);
		
		contentPane.add(btnNewButton_1);
		
		
	}
}
