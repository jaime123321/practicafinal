package studyviral.in;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			//asignamos los datos que escribimos en el registro a las variable
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pword = request.getParameter("pword");
			// DigestUtils.md5Hex es para encriptar
			String newPword = DigestUtils.md5Hex(pword);

			// generamos el codigo hash
			String myHash;
			Random random = new Random();
			random.nextInt(999999);
			myHash = DigestUtils.md5Hex("" + random);

			
			RegisterBean rb = new RegisterBean();
			rb.setFname(fname);
			rb.setLname(lname);
			rb.setEmail(email);
			rb.setPword(newPword);
			rb.setMyhash(myHash);

			RegisterDAO regDao = new RegisterDAO();
			String str = regDao.RegisterUser(rb);
			if (str.equals("SUCCESS")) {
				response.sendRedirect("verify.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (Exception ex) {
			System.out.println("RegisterDAO file :: " + ex);
		}
	}

}
