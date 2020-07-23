package DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;

@SpringBootApplication
@VaultPropertySource("secret/database")
public class ConnectionClass  {
	/*public static void main(String[] args) {
		SpringApplication.run(MyApp.class,args);
	}
	@Value("${b.username}")
	public String username;
	@Value("${password}")
	public String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getPassword() {
		return password;
	}
	
	@PostConstruct
	public void run() {
	    System.out.println("==========uu================");
	    setPassword(password);
	    setUsername(username);
		System.out.println(username);
		System.out.println(password);
		System.out.println("===========uu================");

	}

	public ConnectionClass() {
	}
*/
	public static Connection intializeConn() throws ClassNotFoundException, SQLException {
			
			String username = "root";
			String password = "12345";
			String dbURL = "jdbc:mysql://localhost:3306/players"; 
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(dbURL, username, password);
			return con;
	}

}
