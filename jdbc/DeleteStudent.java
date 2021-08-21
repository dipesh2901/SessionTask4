package com.neosoft.httptest.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/DeleteStudent"})
public class DeleteStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		try {
			if (session.getAttribute("uname") != null) {
			session.setMaxInactiveInterval(100);
			RequestDispatcher rd=req.getRequestDispatcher("DeleteStudent.html");
			rd.include(req, resp);
			}
		} catch (NullPointerException ne) {
			out.print("<h1>Please Login Again!!");
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			StudentController.deleteStudent(Integer.parseInt(req.getParameter("id")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
