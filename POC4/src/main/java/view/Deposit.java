package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserInfoController;

@WebServlet(urlPatterns = { "/Deposit" })
public class Deposit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session=req.getSession(false);
		RequestDispatcher rd;
		PrintWriter out = resp.getWriter();
		Double deposit=Double.parseDouble(req.getParameter("deposit"));
		UserInfoController.updateBalance((String)session.getAttribute("username"), deposit);
		UserInfoController.updateTransaction((String)session.getAttribute("username"), deposit);
		rd=req.getRequestDispatcher("UserAccess");
		rd.forward(req, resp);
	}

}
