package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlayersDAOImpl;

public class UpdateServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,  
			HttpServletResponse response) 
			        throws ServletException, IOException {
		
		PlayersDAOImpl p = new PlayersDAOImpl();
		int id = Integer.parseInt(request.getParameter("playerId"));
		
		String team = request.getParameter("playerTeam");
		
		try {
			 p.updateTeam(id, team);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        PrintWriter out = response.getWriter(); 
        out.println("<html><body><b>Successfully Updated"
                    + "</b></body></html>"); 
       
		
	}
}

