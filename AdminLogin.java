package com.neosoft.httptest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		if(req.getParameter("uname").equals("admin")&&req.getParameter("upass").equals("admin123")) {
			HttpSession session=req.getSession(true);
			session.setAttribute("uname","admin");
			session.setAttribute("upass", "admin123");
			session.setMaxInactiveInterval(1000);
			RequestDispatcher rd=req.getRequestDispatcher("homePage.html");
			rd.forward(req, resp);
		}
		else {
			out.write("Admin doesnt exists");
		}
	}
	
}
