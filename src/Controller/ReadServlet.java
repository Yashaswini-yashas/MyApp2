package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bettercloud.vault.VaultException;

import DAO.PlayersDAOImpl;

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String capitalize(String str) {
		if (str == null || str.isEmpty()) {
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

			out.println("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "  <title>Myapp</title>\r\n" + "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\r\n"
					+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n"
					+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
					+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n"
					+ "</head>\r\n" + "<body>\r\n" + "\r\n" + "<div class=\"container\">\r\n"
					+ "  <h2>Players Data</h2>\r\n"

					+ "  <table class=\"table\">\r\n" + "    <thead>\r\n" + "      <tr>\r\n" + "        <th>ID</th>\r\n"
					+ "        <th>Name</th>\r\n" + "        <th>Team</th>\r\n" + "        <th>Status</th>\r\n"
					+ "        <th>Sports</th>\r\n" + "      </tr>\r\n" + "    </thead>\r\n" + "    <tbody>");

			while (rs.next()) {
				out.println("<tr>\r\n" + "        <td>" + rs.getInt(1) + "</td>\r\n" + "        <td>"
						+ capitalize(rs.getString(2)) + "</td>\r\n" + "        <td>" + rs.getString(3) + "</td>\r\n"
						+ "        <td>" + rs.getString(4) + "</td>\r\n" + "        <td>" + rs.getString(5)
						+ "</td>    \r\n" + "      </tr> ");
			}

			out.println("</tbody>\r\n" + "  </table>\r\n" + "</div>\r\n" + "\r\n" + "</body>\r\n" + "</html>\r\n" + "");

			/*
			 * out.println("<table border=\"1\">" + "<html> <tr>\r\n" +
			 * "    <th>Players id</th>\r\n" + "    <th>Players id</th>\r\n" +
			 * "    <th>Players Team</th>\r\n" + "    <th>Players Status</th>\r\n" +
			 * "    <th>Players Sports</th>\r\n" + "  </tr>"); while (rs.next()) {
			 * 
			 * out.println("<tr>"); out.println("<td>" + rs.getInt(1) + "</td>");
			 * out.println("<td>" + capitalize(rs.getString(2)) + "</td>");
			 * out.println("<td>" + rs.getString(3) + "</td>"); out.println("<td>" +
			 * rs.getString(4) + "</td>"); out.println("<td>" + rs.getString(5) + "</td>");
			 * out.println("</tr>"); } out.println("</table>");
			 */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VaultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
