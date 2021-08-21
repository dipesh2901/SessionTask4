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
import model.UserInformation;

@WebServlet(urlPatterns = { "/UserAccess" })
public class UserAccess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		try {
		if (session.getAttribute("username")==null) {
		}
		else {
			session.setMaxInactiveInterval(1000);
			int choice;
			RequestDispatcher rd;
			rd = req.getRequestDispatcher("LoginInput.html");
			rd.include(req, resp);
			choice = Integer.parseInt(req.getParameter("choice2"));
			switch (choice) {
			case 1:
				out.print("This is Deposit");
				rd = req.getRequestDispatcher("deposit.html");
				rd.forward(req, resp);
				break;
			case 2:
				rd = req.getRequestDispatcher("Transfer.html");
				rd.forward(req, resp);
				break;
			case 3:
				out.print(
						"<h2 style='text-align:center;color:#2F4F4F'>Your last 5 Transactions:</h2><br><div align='center' style='color:#191970'><h3>"
								+ UserInfoController.getTransaction((String) session.getAttribute("username"))
								+ "</h3></div>");
				break;
			case 4:
				UserInformation user = UserInfoController.userInfo((String) session.getAttribute("username"));
				out.print("<div align='center'><h3>User Name: " + user.getName() + "</h3>" + "<h3>User Address: "
						+ user.getAddress() + "</h3>" + "<h3>User Contact: " + user.getMobile() + "</h3></div>");
				break;
			case 5:
				session.invalidate();
				rd = req.getRequestDispatcher("poc4Task");
				rd.forward(req, resp);
			}
		}
		}
		catch(NullPointerException ne) {
			out.print("<h1>Please Login Again!! as your Session is expired</h1>");
		}
		//else {
		//	out.print("<h1>Please Login Again!! as your Session is expired</h1>");
		//}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
