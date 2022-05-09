package fliters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/LoginServlet")
public class UsernameFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter called");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if ((req.getParameter("username") == null) || (req.getParameter("username") == "")) {

			System.out.println("user naem is null");
			req.getRequestDispatcher("jsp/InvalidUser.jsp").forward(req, response);
		} else {
			chain.doFilter(req, response);
		}
	}

}
