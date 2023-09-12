package database;

import java.sql.Connection;

import javax.swing.JOptionPane;
import java.sql.Statement;


public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = Connection_provider.getcon();
			Statement st = connection.createStatement();
//			st.execute("create table appuser(appuser_pk int AUTO_INCREMENT primary key,UserRole varchar(200),name varchar(200),dob varchar(20),mobileNumber varchar(50),username varchar(200),password varchar(50))");
			st.execute("insert into appuser(UserRole,name,dob,mobileNumber,username,password) values('Admin','Admin','19-11-2001','9789876704','Admin','Admin')");
			
			JOptionPane.showMessageDialog(null, "Table created successfully");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}

	}

}
