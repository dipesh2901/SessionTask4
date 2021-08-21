package com.neosoft.httptest.jdbc;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ViewStudent"})
public class ViewStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		try {
			if (session.getAttribute("uname") != null) {
			session.setMaxInactiveInterval(100);
			for(Student s:StudentController.fetchStudents()) {
				out.print(s.getStid()+" "+s.getStname()+" "+s.getStcourse()+" "+s.getMarks()+"<br>");
			}
			}
		}catch(NullPointerException ne) {
			out.print("<h1>Please Login Again!!</h1>");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
