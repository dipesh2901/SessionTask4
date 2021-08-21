package com.neosoft.Task.program34;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/registerUser")
public class UserRegistration extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.write(session.getAttribute("username").toString());
	String emailid,mobile,username,password;
	int id;
	id=Integer.parseInt(req.getParameter("uid"));
	emailid=req.getParameter("uemail");
	mobile=req.getParameter("umobile");
	username=req.getParameter("username");
	password=req.getParameter("pass");
	UserInfo.insertUserInfo(new UserData(id,emailid,mobile,username,password));
	out.print("Success!!!");
	RequestDispatcher rd=req.getRequestDispatcher("index.html"); 
	rd.forward(req,resp);
	
	
}
}
