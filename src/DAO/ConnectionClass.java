package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection intializeConn() throws ClassNotFoundException, SQLException {
		String name = "5V7ccDnOPH";
		String username = "5V7ccDnOPH";
		String password = "EiSIkp2q3j";
		String dbURL = "jdbc:mysql://remotemysql.com:3306/5V7ccDnOPH"; 
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection(dbURL, username, password);
		return con;
	}
}
