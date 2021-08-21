package com.neosoft.httptest.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LogOut"})
public class LogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		out.print(session.getAttribute("uname").toString()+"<br>"+session.getAttribute("upass"));
		session.invalidate();
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
	
}
