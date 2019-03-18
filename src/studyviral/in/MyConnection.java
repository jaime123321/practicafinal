package studyviral.in;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost::3306/email_validation", "root", "practicas");
		} catch (Exception ex) {
			System.out.println("From MyConnection Class" + ex);
		}
		return con;
	}
}
