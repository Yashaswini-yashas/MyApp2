package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PlayersDAOImpl  {

	
	public void addPlayers(int id, String name, String team, String status) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionClass.intializeConn();
		PreparedStatement pt = con.prepareStatement("Insert into Players Values(?,?,?,?)");
		pt.setInt(1,id);
		pt.setString(2,name);
		pt.setString(3,team);
		pt.setString(4,status);
		int i = pt.executeUpdate();
		System.out.println(i + "wohooo");
		
	}
	
	public void updateTeam(int id,String team) throws ClassNotFoundException, SQLException {
	
		Connection con = ConnectionClass.intializeConn();
		
		PreparedStatement pt = con.prepareStatement("UPDATE `Players` SET Team=? WHERE Id=?");
		pt.setString(1, team);
		pt.setInt(2, id);
		int i = pt.executeUpdate();
		System.out.println (i);
	}
	public static ResultSet ReadPlayers() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionClass.intializeConn();
	
	PreparedStatement stmt=con.prepareStatement("select * from Players");  
	ResultSet rs=stmt.executeQuery();  
	return  rs;
		}
	public void DeletePlayers(int id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionClass.intializeConn();
		PreparedStatement stmt=con.prepareStatement("delete from Players where id=?");  
		stmt.setInt(1,id);  
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records deleted");  
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PlayersDAOImpl p = new PlayersDAOImpl();
		System.out.println("Please enter the following integers to perform an operation\n"
				           +"1 : to insert players\n"
				           +"2 : to update players\n"
				           +"3 : to read players data\n"
				           +"4 : to delete players data"  );
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch(i) {
		case 1:
		System.out.println("Id of player to insert");
		int id = sc.nextInt();
		System.out.println("name of player added");
		String name = sc.next();
		System.out.println("team of player added");
		String team = sc.next();
		System.out.println("status of new player");
		String status = sc.next();
		p.addPlayers(id, name, team, status);  
	    break;  
	    case 2: 
	    System.out.println("Id ofplayer to update");
		try{int id2 = sc.nextInt(); 
		System.out.println("updated team of player");
		String team2 = sc.next();
	    p.updateTeam(id2, team2);
		
		   } catch (Exception e)
	    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		break;
	    case 3: 
	    p.ReadPlayers();
	    break;
	    case 4: 
	    	System.out.println("Enter Id of Players you want to delete");
	    	int id4 =sc.nextInt();
	    	p.DeletePlayers(id4);
		}
		
		
		/*System.out.println("Id of player to insert");
		int id = sc.nextInt();
		System.out.println("name of player added");
		String name = sc.next();
		System.out.println("team of player added");
		String team = sc.next();
		System.out.println("status of new player");
		String status = sc.nextLine();
		System.out.println("Id ofplayer to update");
		int id2 = sc.nextInt(); 
		System.out.println("updated team of player");
		String team2 = sc.next();
		p.addPlayers(id, name, team, status);
		p.updateTeam(id2,team2);
		*/
	}

	
	
}
