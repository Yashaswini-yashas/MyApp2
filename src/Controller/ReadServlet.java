package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PlayersDAOImpl;

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ResultSet rs = PlayersDAOImpl.ReadPlayers();

			PrintWriter out = response.getWriter();
			out.println("<table border=\"1\">");
			out.println("<table border=\"1\">" + "<html> <tr>\r\n" + "    <th>Players id</th>\r\n"
					+ "    <th>Players id</th>\r\n" + "    <th>Players Team</th>\r\n"
					+ "    <th>Players Status</th>\r\n" + "    <th>Players Sports</th>\r\n" + "  </tr><body></body></html>");
			while (rs.next()) {

				out.println("<tr>");
				out.println("<td>" + rs.getInt(1) + "</td>");
				out.println("<td>" + capitalize(rs.getString(2)) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td>" + rs.getString(5) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
