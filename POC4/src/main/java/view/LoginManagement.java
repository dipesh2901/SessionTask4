package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserInfoController;

@WebServlet(urlPatterns = { "/loginManagement" })
public class LoginManagement extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		RequestDispatcher rd;
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			HttpSession session = req.getSession();

			session.setMaxInactiveInterval(1000);

			String pass = UserInfoController.userPassword(username);
			if (pass.equals(password)) {
				session.setAttribute("username", username);
				rd = req.getRequestDispatcher("UserAccess");
				rd.forward(req, resp);

			} else {
				out.print("Login Fail");
			}
		} catch (NullPointerException n) {
			out.print("<h1>You were inactive above 10 seconds!!! You need to Login Again</h1>");
		}
	}
}
