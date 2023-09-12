package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_provider {
	public static Connection getcon() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			String url = "jdbc:mysql://localhost:3306/";

			String dataBase = "insurance";

			String user = "root";

			String password = "root";

			Connection connection = DriverManager.getConnection(url+dataBase, user, password);
			return connection;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
	}

}
