package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlayersDAOImpl;

public class ReadServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request,  
		HttpServletResponse response) 
		        throws ServletException, IOException {
	
	PlayersDAOImpl p = new PlayersDAOImpl();
	int id = Integer.parseInt(request.getParameter("playerId"));
	String name = request.getParameter("player");
	String team = request.getParameter("playerTeam");
	String status = request.getParameter("playerStatus");
	try {
		p.ReadPlayers(id);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 PrintWriter out = response.getWriter(); 
     String title = "read players data";
	out.println("<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>PlayerId</b>: "
                  + request.getParameter("playerId") + "\n" +
                  "  <li><b>playername</b>: "
                  + request.getParameter("player") + "\n" +
               "</ul>\n" +
            "</body>" +
         "</html>"); 
}
}

