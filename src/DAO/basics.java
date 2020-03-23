package DAO  
import static io.restassured.RestAssured.given;  
import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class Example {
	  static Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\yashass\\eclipse-workspace\\Jra\\src\\files\\env.properties");
		prop.load(fis);
		//prop.get("HOST");
	}
	
	@Test
	public static  void getSessionKey() {
		RestAssured.baseURI = prop.getProperty("JIRAHOSTONE");
		Response res = given().header("Content-Type", "application/json").
		body("{ \"username\": \"YashaswiniS\", \"password\": \"jira1@345\" }").
	    when().
	    post("/rest/auth/1/session").then().statusCode(200).
	    extract().response();
		String response=res.asString();	
	    System.out.println(response);
	    JsonPath js = new JsonPath(response);
	    String sessionid = js.get("session.value");
	    System.out.println(sessionid);
	    //return sessionid;
	    
	    
	    
	
}} 
 
