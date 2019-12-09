package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public static Connection intializeConn() throws ClassNotFoundException, SQLException {
		String name = "uqn9VQ6Hqy";
		String username = "uqn9VQ6Hqy";
		String password = "vooaYhKWmG";
		String dbURL = "jdbc:mysql://remotemysql.com:3306/uqn9VQ6Hqy"; 
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection(dbURL, username, password);
		return con;
	}
}
