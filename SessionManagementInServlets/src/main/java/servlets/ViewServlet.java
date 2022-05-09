package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbConfig.UserDao;
import pojo.User;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.getUser(username);
		session.setAttribute("user", user);
		String firstName = user.getFirstName();
		if(firstName==null) {
			String error ="Invalid username. Please login again";
			request.setAttribute("error",error);
			request.getRequestDispatcher("jsp/InvalidUser.jsp").forward(request, response);
		}
		else {
		response.setContentType("text/html");
		response.sendRedirect("jsp/ViewPage.jsp");
		}
	}

}
