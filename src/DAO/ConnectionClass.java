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
	 public static void main(String args[]) throws VaultException {

    }
	public Connection intializeConn() throws ClassNotFoundException, SQLException, InterruptedException, VaultException {

		File sslCertificate = new File("vault.crt");
	     VaultConfig config =
	                new VaultConfig()
	                    .address("http://127.0.0.1:8200")
	                    .token("s.qKpaKoOWxI9Y3uktFEoivMPA")
	                    .build();
	     Vault vault = new Vault(config);
	    
	     String username = vault.logical()
	            .read("secret/database")
	            .getData().get("b.username");
	     String password = vault.logical()
		            .read("secret/database")
		            .getData().get("password");
		System.out.println(username);
        
		String name = "players";

		String dbURL = "jdbc:mysql://localhost:3306/players";
		Class.forName("com.mysql.jdbc.Driver");
        
		Connection con = DriverManager.getConnection(dbURL, username, password);
		return con;
	}

}