package Cutomers;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Test_jframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_jframe frame = new Test_jframe();
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
	public Test_jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    LocalDateTime  today=LocalDateTime.now();
		
		  DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		  
		  System.out.println(dFormat.format(today));
		  String todayString = dFormat.format(today);
		  System.out.println(todayString);
		  
//		  String policy_create ="11-10-2023";
//		  String poloicy_end = "11-01-2023";
//		  SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
//		  
//		  
		  
		  
//		  java.util.Date date1;
//		  java.util.Date date2;
//		try {
//			date1 =  dFormat.parse(policy_create);
//			date2=  dFormat.parse(poloicy_end);
//			long time_difference = date1.getTime() - date2.getTime();  
//			LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date1) );
//			System.out.println(localDate);
//			LocalDate ldate2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date2));
//			System.out.println(ldate2);
//			long months = ChronoUnit.MONTHS.between(ldate2, localDate);
//			System.out.println(months);
//			
//			
//			System.out.println(time_difference);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		  
		   
	}
}
