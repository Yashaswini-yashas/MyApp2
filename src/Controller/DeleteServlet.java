package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlayersDAOImpl;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlayersDAOImpl p = new PlayersDAOImpl();
		int id = Integer.parseInt(request.getParameter("PlayerId"));
		System.out.println(id);

		try {
			p.DeletePlayers(id);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println("<html><body><b>Deleted " + "</b></body></html>");

	}
}
