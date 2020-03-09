package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection intializeConn() throws ClassNotFoundException, SQLException {
		String name = "players";
		String username = "root";
		String password = "12345";
		String dbURL = "jdbc:mysql://localhost:3306/players"; 
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(dbURL, username, password);
		return con;
	}
}