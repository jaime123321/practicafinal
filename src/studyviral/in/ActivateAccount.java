package studyviral.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class ActivateAccount extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");

		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(
					"SELECT email,hash, active FROM usertable WHERE email=? AND hash=? AND active='0'");
			pst.setString(1, email);
			pst.setString(2, hash);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				PreparedStatement pst1 = con
						.prepareStatement("UPDATE usertable SET active='1' WHERE email=? AND hash=?");
				pst1.setString(1, email);
				pst1.setString(2, hash);
				int i = pst1.executeUpdate();
				if (i == 1) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			}

		} catch (Exception ex) {
			System.out.println("ActivateAccount File :: " + ex);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
