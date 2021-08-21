package com.neosoft.httptest.jdbc;

import java.io.BufferedReader;
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

@WebServlet(urlPatterns = { "/AddStudent" })
public class AddStudents extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		try {
			if (session.getAttribute("uname") != null) {
				out.print(session.getAttribute("uname"));
				session.setMaxInactiveInterval(100);
				try {
					RequestDispatcher rd = req.getRequestDispatcher("AddStudent.html");
					rd.include(req, resp);
					System.out.println("Insertion Successful!!!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (NullPointerException ne) {
			out.print("<h1> Log In again!!!</h1>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try {
			StudentController.insertStudent(new Student(Integer.parseInt(req.getParameter("id")),
					req.getParameter("name"), req.getParameter("course"), Integer.parseInt(req.getParameter("marks"))));
			out.print("insertion successful");
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
