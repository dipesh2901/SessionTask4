package com.neosoft.Task.program33;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.Task.UserList;

@WebServlet(urlPatterns = "/loginUser")
public class UserLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		boolean flag = false;
		String username;
		LocalTime t1 = LocalTime.parse("12:00:00");
		LocalTime t2 = LocalTime.parse("16:00:00");
		LocalTime t3 = LocalTime.parse("19:30:00");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		username = UserInfo.validUser(uname, upass);
		if (username.length() > 0) {
			
			writer.write("Welcome\t" + username + "<br>");
			int val = java.time.LocalTime.now().compareTo(t1);
			if (val < 0) {
				writer.write("Good Morning");
			} else {
				int val2 = java.time.LocalTime.now().compareTo(t2);
				if (val2 < 0) {
					writer.write("Good Afternoon");
				} else {
					int val3 = java.time.LocalTime.now().compareTo(t3);
					if (val3 < 0) {
						writer.write("Good Evening");
					} else {
						writer.write("Good Night");
					}
				}
			}
		} else {
			writer.write("<a href='registration.html'>Click here for Registration</a>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
